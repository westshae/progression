package cc.altoya.progression.Gear;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import cc.altoya.progression.Experience.Experience;
import cc.altoya.progression.Experience.SingletonExperienceBank;
import cc.altoya.progression.Util.DBUtil;
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
        commands.put("/gear help", "The command you're looking at right now.");

        return commands;
    }

    public static void updatePlayerGear(Player player) {
        Inventory inventory = player.getInventory();
        boolean hasCustomPickaxe = false;
        ItemStack customPickaxe = null;

        for (ItemStack item : inventory.getContents()) {
            if (item != null && item.getType() != Material.AIR) {
                ItemMeta meta = item.getItemMeta();
                if (meta != null) {
                    NamespacedKey key = new NamespacedKey(Bukkit.getServer().getPluginManager().getPlugin("progression"),
                            "progression_pickaxe");
                    PersistentDataContainer container = meta.getPersistentDataContainer();
                    if (container.has(key, PersistentDataType.STRING)) {
                        hasCustomPickaxe = true;
                        customPickaxe = item;
                        break;
                    }
                }
            }
        }

        if (!hasCustomPickaxe) {
            inventory.addItem(createCustomPickaxe(Material.WOODEN_PICKAXE));
        } else {
            UUID uuid = player.getUniqueId();
            int miningExperience = SingletonExperienceBank.getExperience(Experience.PICKAXE, uuid);

            switch (miningExperience) {
                case 5:
                    inventory.remove(customPickaxe);
                    inventory.addItem(createCustomPickaxe(Material.STONE_PICKAXE));
                    break;

                case 10:
                    inventory.remove(customPickaxe);
                    inventory.addItem(createCustomPickaxe(Material.GOLDEN_PICKAXE));
                    break;
                case 15:
                    inventory.remove(customPickaxe);
                    inventory.addItem(createCustomPickaxe(Material.IRON_PICKAXE));
                    break;
                case 20:
                    inventory.remove(customPickaxe);
                    inventory.addItem(createCustomPickaxe(Material.DIAMOND_PICKAXE));
                    break;
                case 25:
                    inventory.remove(customPickaxe);
                    inventory.addItem(createCustomPickaxe(Material.NETHERITE_PICKAXE));
                    break;
            
                default:
                    break;
            }
        }
    }

    public static ItemStack createCustomPickaxe(Material pickaxeMaterial) {
        ItemStack pickaxe = new ItemStack(pickaxeMaterial);
        ItemMeta meta = pickaxe.getItemMeta();

        if (meta != null) {
            NamespacedKey key = new NamespacedKey(Bukkit.getServer().getPluginManager().getPlugin("progression"),
                    "progression_pickaxe");
            PersistentDataContainer container = meta.getPersistentDataContainer();
            container.set(key, PersistentDataType.STRING, "true");
            pickaxe.setItemMeta(meta);
        }

        return pickaxe;
    }

}
