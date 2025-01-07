package cc.altoya.progression.Gear;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;

import cc.altoya.progression.Experience.Experience;
import cc.altoya.progression.Gear.Levels.ArmourLevelUtil;
import cc.altoya.progression.Gear.Levels.AxeLevelUtil;
import cc.altoya.progression.Gear.Levels.FishingLevelUtil;
import cc.altoya.progression.Gear.Levels.HoeLevelUtil;
import cc.altoya.progression.Gear.Levels.MeleeLevelUtil;
import cc.altoya.progression.Gear.Levels.PickaxeLevelUtil;
import cc.altoya.progression.Gear.Levels.RangedLevelUtil;
import cc.altoya.progression.Gear.Levels.ShovelLevelUtil;
import cc.altoya.progression.Util.GeneralUtil;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;

public class GearUtil {
  public static FileConfiguration getGearConfig() {
    return GeneralUtil.getPluginConfig("progression", "gear.yml");
  }

  public static void saveGearConfig(FileConfiguration config) {
    File file = new File(Bukkit.getServer().getPluginManager().getPlugin("progression").getDataFolder(),
        "gear.yml");
    try {
      config.save(file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static HashMap<String, String> getGearCommands() {
    HashMap<String, String> commands = new HashMap<>();
    commands.put("/gear update", "Updates the gear in your inventory if it's behind.");
    commands.put("/gear view {gui-type}", "View gear level information. Valid types: pickaxe, axe, shovel, hoe, fishing, melee, ranged, armour1, armour2, armour3");
    commands.put("/gear help", "The command you're looking at right now.");

    return commands;
  }


  public static void viewGearInventory(Player player, String gearType) {

    switch (gearType) {
      case "pickaxe" -> GuiUtil.viewPickaxeGui(player);
      case "axe" -> GuiUtil.viewAxeGui(player);
      case "shovel" -> GuiUtil.viewShovelGui(player);
      case "hoe" -> GuiUtil.viewHoeGui(player);
      case "fishing" -> GuiUtil.viewFishingGui(player);
      case "melee" -> GuiUtil.viewMeleeGui(player);
      case "ranged" -> GuiUtil.viewRangedGui(player);
      case "armour1" -> GuiUtil.viewArmour1Gui(player);
      case "armour2" -> GuiUtil.viewArmour2Gui(player);
      case "armour3" -> GuiUtil.viewArmour3Gui(player);
      default -> {
        return;
      }
    }
  }

  public static void initPlayerGear(Player player) {
    Inventory inventory = player.getInventory();
    if (inventoryContainsKey(inventory, "progression_pickaxe") == null)
      inventory.addItem(PickaxeLevelUtil.getPickaxeViaUuid(player.getUniqueId()));

    if (inventoryContainsKey(inventory, "progression_axe") == null)
      inventory.addItem(AxeLevelUtil.getAxeViaUuid(player.getUniqueId()));

    if (inventoryContainsKey(inventory, "progression_shovel") == null)
      inventory.addItem(ShovelLevelUtil.getShovelViaUuid(player.getUniqueId()));

    if (inventoryContainsKey(inventory, "progression_hoe") == null)
      inventory.addItem(HoeLevelUtil.getHoeViaUuid(player.getUniqueId()));

    if (inventoryContainsKey(inventory, "progression_fishing") == null)
      inventory.addItem(FishingLevelUtil.getFishingViaUuid(player.getUniqueId()));

    if (inventoryContainsKey(inventory, "progression_melee") == null)
      inventory.addItem(MeleeLevelUtil.getMeleeViaUuid(player.getUniqueId()));

    if (inventoryContainsKey(inventory, "progression_ranged") == null)
      inventory.addItem(RangedLevelUtil.getRangedViaUuid(player.getUniqueId()));

    if (inventoryContainsKey(inventory, "progression_armour") == null){
      ItemStack[] newArmour = ArmourLevelUtil.getArmourViaUuid(player.getUniqueId());
      PlayerInventory playerInventory = (PlayerInventory) inventory;
      playerInventory.setHelmet(newArmour[0]);
      playerInventory.setChestplate(newArmour[1]);
      playerInventory.setLeggings(newArmour[2]);
      playerInventory.setBoots(newArmour[3]);
    }
  }

  public static ItemStack inventoryContainsKey(Inventory inventory, String stringKey) {
    for (ItemStack item : inventory.getContents()) {
      if (item != null && item.getType() != Material.AIR) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
          NamespacedKey key = new NamespacedKey(
              Bukkit.getServer().getPluginManager().getPlugin("progression"),
              stringKey);
          PersistentDataContainer container = meta.getPersistentDataContainer();
          if (container.has(key, PersistentDataType.STRING)) {
            return item;
          }
        }
      }
    }

    return null;
  }

  public static boolean itemStackHasKey(ItemStack item, String stringKey) {
    if (item != null && item.getType() != Material.AIR) {
      ItemMeta meta = item.getItemMeta();
      if (meta != null) {
        NamespacedKey key = new NamespacedKey(
            Bukkit.getServer().getPluginManager().getPlugin("progression"),
            stringKey);
        PersistentDataContainer container = meta.getPersistentDataContainer();
        return container.has(key, PersistentDataType.STRING);
      }
    }
    return false;
  }

  public static void updatePlayerGear(Player player, Experience xpType, ItemStack gear) {
    switch (xpType) {
      case AXE ->
        updateAxe(player, gear);
      case PICKAXE ->
        updatePickaxe(player, gear);
      case SHOVEL ->
        updateShovel(player, gear);
      case HOE ->
        updateHoe(player, gear);
      case FISHING ->
        updateFishing(player, gear);
      case MELEE ->
        updateMelee(player, gear);
      case RANGED ->
        updateRanged(player, gear);
      case ARMOUR ->
        updateArmour(player);

      default -> {
        return;
      }
    }
  }

  public static void updateArmour(Player player) {
    ItemStack[] currentArmour = player.getInventory().getArmorContents();
    ItemStack[] newArmour = ArmourLevelUtil.getArmourViaUuid(player.getUniqueId());

    for (int i = 0; i < 4; i++) {
      player.getInventory().remove(currentArmour[i]);
    }

    player.getInventory().setHelmet(newArmour[0]);
    player.getInventory().setChestplate(newArmour[1]);
    player.getInventory().setLeggings(newArmour[2]);
    player.getInventory().setBoots(newArmour[3]);
  }

  public static void updateRanged(Player player, ItemStack gear) {
    if (gear == null)
      return;

    if (!itemStackHasKey(gear, "progression_ranged"))
      return;

    Inventory inventory = player.getInventory();
    inventory.remove(gear);
    inventory.addItem(RangedLevelUtil.getRangedViaUuid(player.getUniqueId()));
  }

  public static void updateMelee(Player player, ItemStack gear) {
    if (gear == null)
      return;
    if (!itemStackHasKey(gear, "progression_melee"))
      return;
    Inventory inventory = player.getInventory();
    inventory.remove(gear);
    inventory.addItem(MeleeLevelUtil.getMeleeViaUuid(player.getUniqueId()));
  }

  public static void updateHoe(Player player, ItemStack gear) {
    if (gear == null)
      return;
    if (!itemStackHasKey(gear, "progression_hoe"))
      return;
    Inventory inventory = player.getInventory();
    inventory.remove(gear);
    inventory.addItem(HoeLevelUtil.getHoeViaUuid(player.getUniqueId()));
  }

  public static void updateAxe(Player player, ItemStack gear) {
    if (gear == null)
      return;
    if (!itemStackHasKey(gear, "progression_axe"))
      return;
    Inventory inventory = player.getInventory();
    inventory.remove(gear);
    inventory.addItem(AxeLevelUtil.getAxeViaUuid(player.getUniqueId()));
  }

  public static void updateShovel(Player player, ItemStack gear) {
    if (gear == null)
      return;
    if (!itemStackHasKey(gear, "progression_shovel"))
      return;
    Inventory inventory = player.getInventory();
    inventory.remove(gear);
    inventory.addItem(ShovelLevelUtil.getShovelViaUuid(player.getUniqueId()));
  }

  public static void updatePickaxe(Player player, ItemStack gear) {
    if (gear == null)
      return;
    if (!itemStackHasKey(gear, "progression_pickaxe"))
      return;
    Inventory inventory = player.getInventory();
    inventory.remove(gear);
    inventory.addItem(PickaxeLevelUtil.getPickaxeViaUuid(player.getUniqueId()));
  }

  public static void updateFishing(Player player, ItemStack gear) {
    if (gear == null)
      return;
    if (!itemStackHasKey(gear, "progression_fishing"))
      return;
    Inventory inventory = player.getInventory();
    inventory.remove(gear);
    inventory.addItem(FishingLevelUtil.getFishingViaUuid(player.getUniqueId()));
  }

  public static ItemStack createCustomGear(String stringKey, Material material,
      HashMap<Enchantment, Integer> enchantments) {
    ItemStack gear = new ItemStack(material);
    ItemMeta meta = gear.getItemMeta();

    if (meta != null) {
      NamespacedKey key = new NamespacedKey(Bukkit.getServer().getPluginManager().getPlugin("progression"),
          stringKey);
      PersistentDataContainer container = meta.getPersistentDataContainer();
      container.set(key, PersistentDataType.STRING, "true");
      if (enchantments != null) {
        for (Map.Entry<Enchantment, Integer> enchantment : enchantments.entrySet()) {
          meta.addEnchant(enchantment.getKey(), enchantment.getValue(), true);
        }
      }
      meta.setUnbreakable(true);
      gear.setItemMeta(meta);
      return gear;
    }

    return null;
  }
}
