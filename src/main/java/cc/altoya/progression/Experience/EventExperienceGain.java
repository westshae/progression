package cc.altoya.progression.Experience;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import cc.altoya.progression.Gear.GearUtil;
import cc.altoya.progression.Gear.Levels.AxeLevelUtil;
import cc.altoya.progression.Gear.Levels.HoeLevelUtil;
import cc.altoya.progression.Gear.Levels.PickaxeLevelUtil;
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
}