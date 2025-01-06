package cc.altoya.progression.Gear;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;

import cc.altoya.progression.Gear.Levels.AxeLevelUtil;
import cc.altoya.progression.Gear.Levels.PickaxeLevelUtil;
import cc.altoya.progression.Gear.Levels.ShovelLevelUtil;
import cc.altoya.progression.Util.GeneralUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
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
    commands.put("/gear help", "The command you're looking at right now.");

    return commands;
  }

  public static void initPlayerGear(Player player) {
    Inventory inventory = player.getInventory();
    if (inventoryContainsKey(inventory, "progression_pickaxe") == null)
      inventory.addItem(PickaxeLevelUtil.getPickaxeViaLevel(player.getUniqueId()));
    if (inventoryContainsKey(inventory, "progression_axe") == null)
      inventory.addItem(AxeLevelUtil.getAxeViaLevel(player.getUniqueId()));
    if (inventoryContainsKey(inventory, "progression_shovel") == null)
      inventory.addItem(ShovelLevelUtil.getShovelViaLevel(player.getUniqueId()));

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

  public static void updatePlayerGear(Player player) {
    updatePickaxe(player);
    updateAxe(player);
    updateShovel(player);
  }
  public static void updateAxe(Player player) {
    Inventory inventory = player.getInventory();
    ItemStack axe = inventoryContainsKey(inventory, "progression_axe");
    if (axe != null) {
      inventory.remove(axe);
      inventory.addItem(AxeLevelUtil.getAxeViaLevel(player.getUniqueId()));
    }
  }

  public static void updateShovel(Player player) {
    Inventory inventory = player.getInventory();
    ItemStack shovel = inventoryContainsKey(inventory, "progression_shovel");
    if (shovel != null) {
      inventory.remove(shovel);
      inventory.addItem(ShovelLevelUtil.getShovelViaLevel(player.getUniqueId()));
    }
  }

  public static void updatePickaxe(Player player) {
    Inventory inventory = player.getInventory();
    ItemStack pickaxe = inventoryContainsKey(inventory, "progression_pickaxe");
    if (pickaxe != null) {
      inventory.remove(pickaxe);
      inventory.addItem(PickaxeLevelUtil.getPickaxeViaLevel(player.getUniqueId()));
    }
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
