package cc.altoya.progression.Experience;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import com.destroystokyo.paper.event.player.PlayerPickupExperienceEvent;

import cc.altoya.progression.Gear.GearUtil;
import cc.altoya.progression.Gear.Levels.ArmourLevelUtil;
import cc.altoya.progression.Gear.Levels.AxeLevelUtil;
import cc.altoya.progression.Gear.Levels.FishingLevelUtil;
import cc.altoya.progression.Gear.Levels.HoeLevelUtil;
import cc.altoya.progression.Gear.Levels.MeleeLevelUtil;
import cc.altoya.progression.Gear.Levels.PickaxeLevelUtil;
import cc.altoya.progression.Gear.Levels.RangedLevelUtil;
import cc.altoya.progression.Gear.Levels.ShovelLevelUtil;
import cc.altoya.progression.Util.ChatUtil;

public class EventExperienceGain implements Listener {
  @EventHandler
  public void handleBreakEvent(BlockBreakEvent event) {
    ItemStack gear = event.getPlayer().getInventory().getItemInMainHand();
    Experience xpType = switch (gear.getType()) {
      case WOODEN_PICKAXE, STONE_PICKAXE, GOLDEN_PICKAXE, IRON_PICKAXE, DIAMOND_PICKAXE, NETHERITE_PICKAXE ->
        Experience.PICKAXE;
      case WOODEN_SHOVEL, STONE_SHOVEL, GOLDEN_SHOVEL, IRON_SHOVEL, DIAMOND_SHOVEL, NETHERITE_SHOVEL ->
        Experience.SHOVEL;
      case WOODEN_AXE, STONE_AXE, GOLDEN_AXE, IRON_AXE, DIAMOND_AXE, NETHERITE_AXE ->
        Experience.AXE;
      case WOODEN_HOE, STONE_HOE, GOLDEN_HOE, IRON_HOE, DIAMOND_HOE, NETHERITE_HOE ->
        Experience.HOE;
      default -> null;
    };

    if (xpType == null) {
      return;
    }

    Material blockType = event.getBlock().getType();
    int xpAmount = switch (xpType) {
      case PICKAXE -> PickaxeLevelUtil.getExperienceFromBreak(blockType);
      case SHOVEL -> ShovelLevelUtil.getExperienceFromBreak(blockType);
      case AXE -> AxeLevelUtil.getExperienceFromBreak(blockType);
      case HOE -> HoeLevelUtil.getExperienceFromBreak(blockType);
      default -> 0;
    };

    if (xpAmount == 0) {
      return;
    }

    if (xpAmount > 0 && xpType == Experience.HOE) {
      if (event.getBlock().getBlockData() instanceof Ageable ageable) {
        if (ageable.getAge() < ageable.getMaximumAge()) {
          return;
        }
      }
    }

    UUID uuid = event.getPlayer().getUniqueId();

    boolean willPlayerUpgrade = switch (xpType) {
      case PICKAXE -> PickaxeLevelUtil.willPlayerUpdatePickaxe(uuid, xpAmount);
      case SHOVEL -> ShovelLevelUtil.willPlayerUpdateShovel(uuid, xpAmount);
      case AXE -> AxeLevelUtil.willPlayerUpdateAxe(uuid, xpAmount);
      case HOE -> HoeLevelUtil.willPlayerUpdateHoe(uuid, xpAmount);
      default -> false;
    };

    SingletonExperienceBank.addExperience(xpType, uuid, xpAmount);
    ChatUtil.sendSuccessBar(event.getPlayer(),
        xpType.toString() + " XP: " + SingletonExperienceBank.getExperience(xpType, uuid));

    if (!willPlayerUpgrade)
      return;
    GearUtil.updatePlayerGear(event.getPlayer(), xpType, gear);

    switch (xpType) {
      case PICKAXE -> ChatUtil.sendSuccessMessage(event.getPlayer(), "Your pickaxe has leveled up!");
      case SHOVEL -> ChatUtil.sendSuccessMessage(event.getPlayer(), "Your shovel has leveled up!");
      case AXE -> ChatUtil.sendSuccessMessage(event.getPlayer(), "Your axe has leveled up!");
      case HOE -> ChatUtil.sendSuccessMessage(event.getPlayer(), "Your hoe has leveled up!");
    }
  }

  @EventHandler
  public void handleEntityKill(EntityDeathEvent event) {
    if (event.getEntity().getKiller() == null) {
      return;
    }

    ItemStack gear = event.getEntity().getKiller().getInventory().getItemInMainHand();
    Experience xpType = switch (gear.getType()) {
      case WOODEN_SWORD, STONE_SWORD, GOLDEN_SWORD, IRON_SWORD, DIAMOND_SWORD, NETHERITE_SWORD, TRIDENT ->
        Experience.MELEE;
      case BOW, CROSSBOW ->
        Experience.RANGED;
      default -> null;
    };

    if (xpType == null) {
      return;
    }

    UUID uuid = event.getEntity().getKiller().getUniqueId();

    int xpAmount = switch (xpType) {
      case MELEE -> MeleeLevelUtil.getExperienceFromKill(event.getEntity());
      case RANGED -> RangedLevelUtil.getExperienceFromKill(event.getEntity());
      default -> 0;
    };

    if (xpAmount == 0) {
      return;
    }

    boolean willPlayerUpgrade = switch (xpType) {
      case MELEE -> MeleeLevelUtil.willPlayerUpdateMelee(uuid, xpAmount);
      case RANGED -> RangedLevelUtil.willPlayerUpdateRanged(uuid, xpAmount);
      default -> false;
    };

    SingletonExperienceBank.addExperience(xpType, uuid, xpAmount);
    ChatUtil.sendSuccessBar(event.getEntity().getKiller(),
        xpType.toString() + " XP: " + SingletonExperienceBank.getExperience(xpType, uuid));

    if (!willPlayerUpgrade)
      return;
    GearUtil.updatePlayerGear(event.getEntity().getKiller(), xpType, gear);

    switch (xpType) {
      case MELEE -> ChatUtil.sendSuccessMessage(event.getEntity().getKiller(), "Your sword has leveled up!");
      case RANGED -> ChatUtil.sendSuccessMessage(event.getEntity().getKiller(), "Your bow has leveled up!");
    }
  }

  @EventHandler
  public void handleFishCaught(PlayerFishEvent event) {
    ItemStack gear = event.getPlayer().getInventory().getItemInMainHand();
    if (gear.getType() != Material.FISHING_ROD) {
      return;
    }
    Experience xpType = Experience.FISHING;

    if (event.getState() != PlayerFishEvent.State.CAUGHT_FISH) {
      return;
    }

    Entity caughtEntity = event.getCaught();
    ItemStack fish = null;
    if (caughtEntity instanceof Item) {
      Item caughtItem = (Item) caughtEntity;
      fish = caughtItem.getItemStack();
    } else {
      return;
    }

    int xpAmount = FishingLevelUtil.getExperienceFromCatch(fish.getType());

    if (xpAmount == 0) {
      return;
    }

    UUID uuid = event.getPlayer().getUniqueId();

    boolean willPlayerUpgrade = FishingLevelUtil.willPlayerUpdateFishing(uuid, xpAmount);

    SingletonExperienceBank.addExperience(xpType, uuid, xpAmount);
    ChatUtil.sendSuccessBar(event.getPlayer(),
        xpType.toString() + " XP: " + SingletonExperienceBank.getExperience(xpType, uuid));

    if (!willPlayerUpgrade)
      return;
    GearUtil.updatePlayerGear(event.getPlayer(), xpType, gear);

    ChatUtil.sendSuccessMessage(event.getPlayer(), "Your fishing rod has leveled up!");
  }

  @EventHandler
  public void handleFishCaught(PlayerPickupExperienceEvent event) {
    Experience xpType = Experience.ARMOUR;

    int xpAmount = event.getExperienceOrb().getExperience();

    if (xpAmount == 0) {
      return;
    }

    UUID uuid = event.getPlayer().getUniqueId();

    boolean willPlayerUpgrade = ArmourLevelUtil.willPlayerUpdateArmour(uuid, xpAmount);

    SingletonExperienceBank.addExperience(xpType, uuid, xpAmount);
    ChatUtil.sendSuccessBar(event.getPlayer(),
        xpType.toString() + " XP: " + SingletonExperienceBank.getExperience(xpType, uuid));

    if (!willPlayerUpgrade)
      return;

    ItemStack[] currentArmour = event.getPlayer().getInventory().getArmorContents();
    ItemStack[] newArmour = ArmourLevelUtil.getArmourViaLevel(event.getPlayer().getUniqueId());

    for (int i = 0; i < 4; i++) {
      event.getPlayer().getInventory().remove(currentArmour[i]);
    }

    event.getPlayer().getInventory().setHelmet(newArmour[0]);
    event.getPlayer().getInventory().setChestplate(newArmour[1]);
    event.getPlayer().getInventory().setLeggings(newArmour[2]);
    event.getPlayer().getInventory().setBoots(newArmour[3]);

    ChatUtil.sendSuccessMessage(event.getPlayer(), "Your armour has leveled up!");
  }

}