package cc.altoya.progression.Gear.Levels;

import java.util.HashMap;
import java.util.UUID;

import cc.altoya.progression.Experience.Experience;
import cc.altoya.progression.Experience.SingletonExperienceBank;
import cc.altoya.progression.Gear.GearUtil;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class ArmourLevelUtil {
  private static int getArmourLevelFromXp(int xp) {
    int[] thresholds = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100, 105, 110, 115, 120, 125, 130, 135, 140, 145 }; // 29 levels

    for (int i = 0; i < thresholds.length; i++) {
      if (xp <= thresholds[i]) {
        return i + 1;
      }
    }
    return thresholds.length + 1;
  }

  public static boolean willPlayerUpdateArmour(UUID uuid, int xpGain) {
    int currentLevel = getArmourLevelFromXp(SingletonExperienceBank.getExperience(Experience.ARMOUR, uuid));
    int newLevel = getArmourLevelFromXp(SingletonExperienceBank.getExperience(Experience.ARMOUR, uuid) + xpGain);

    return newLevel > currentLevel;
  }

  public static ItemStack[] getArmourViaLevel(UUID uuid) {
    int experience = SingletonExperienceBank.getExperience(Experience.ARMOUR, uuid);
    int level = getArmourLevelFromXp(experience);

    String key = "progression_armour";

    ItemStack[] gear = new ItemStack[4];

    switch (level) {
      case 1 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.LEATHER_HELMET, new HashMap<Enchantment, Integer>());
        gear[1] = GearUtil.createCustomGear(key, Material.LEATHER_CHESTPLATE, new HashMap<Enchantment, Integer>());
        gear[2] = GearUtil.createCustomGear(key, Material.LEATHER_LEGGINGS, new HashMap<Enchantment, Integer>());
        gear[3] = GearUtil.createCustomGear(key, Material.LEATHER_BOOTS, new HashMap<Enchantment, Integer>());
      }
      case 2 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.LEATHER_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.LEATHER_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.LEATHER_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.LEATHER_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        });
      }
      case 3 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.CHAINMAIL_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.CHAINMAIL_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.CHAINMAIL_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.CHAINMAIL_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        });
      }
      case 4 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.CHAINMAIL_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.CHAINMAIL_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.CHAINMAIL_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.CHAINMAIL_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
      }
      case 5 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.GOLDEN_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.GOLDEN_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.GOLDEN_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.GOLDEN_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
      }
      case 6 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.GOLDEN_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.GOLDEN_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.GOLDEN_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.GOLDEN_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
            put(Enchantment.FEATHER_FALLING, 1);
          }
        });
      }
      case 7 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.GOLDEN_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.GOLDEN_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.GOLDEN_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.GOLDEN_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
            put(Enchantment.FEATHER_FALLING, 2);
          }
        });
      }
      case 8 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.IRON_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.IRON_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.IRON_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.IRON_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
            put(Enchantment.FEATHER_FALLING, 2);
          }
        });
      }
      case 9 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.IRON_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.IRON_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.IRON_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.IRON_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
            put(Enchantment.FEATHER_FALLING, 2);
            put(Enchantment.DEPTH_STRIDER, 1);
          }
        });
      }
      case 10 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.IRON_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.IRON_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.IRON_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.IRON_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
            put(Enchantment.FEATHER_FALLING, 2);
            put(Enchantment.DEPTH_STRIDER, 2);
          }
        });
      }
      case 11 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.DIAMOND_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.DIAMOND_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.DIAMOND_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.DIAMOND_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
            put(Enchantment.FEATHER_FALLING, 2);
            put(Enchantment.DEPTH_STRIDER, 2);
          }
        });
      }
      case 12 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.DIAMOND_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.DIAMOND_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.DIAMOND_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.DIAMOND_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
            put(Enchantment.FEATHER_FALLING, 2);
            put(Enchantment.DEPTH_STRIDER, 2);
          }
        });
      }
      case 13 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.DIAMOND_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.DIAMOND_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.DIAMOND_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.DIAMOND_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
            put(Enchantment.FEATHER_FALLING, 3);
            put(Enchantment.DEPTH_STRIDER, 2);
          }
        });
      }
      case 14 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.DIAMOND_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.DIAMOND_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.DIAMOND_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.DIAMOND_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
            put(Enchantment.FEATHER_FALLING, 3);
            put(Enchantment.DEPTH_STRIDER, 3);
          }
        });
      }
      case 15 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
            put(Enchantment.FEATHER_FALLING, 3);
            put(Enchantment.DEPTH_STRIDER, 3);
          }
        });
      }
      case 16 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 3);
            put(Enchantment.DEPTH_STRIDER, 3);
          }
        });
      }
      case 17 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
          }
        });
      }
      case 18 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 1);
          }
        });
      }
      case 19 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 2);
          }
        });
      }
      case 20 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        });
      }
      case 21 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        });
      }
      case 22 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 1);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        });
      }
      case 23 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 2);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        });
      }
      case 24 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 3);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        });
      }
      case 25 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 3);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.ELYTRA, new HashMap<Enchantment, Integer>());
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        });
      }
      case 26 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 3);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.ELYTRA, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        });
      }
      case 27 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 3);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.ELYTRA, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        });
      }
      case 28 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 3);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.ELYTRA, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        });
      }
      case 29 -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 3);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.ELYTRA, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        });
      }




      default -> {
        gear[0] = GearUtil.createCustomGear(key, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 3);
          }
        });
        gear[1] = GearUtil.createCustomGear(key, Material.ELYTRA, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[2] = GearUtil.createCustomGear(key, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        });
        gear[3] = GearUtil.createCustomGear(key, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        });
      }
    }

    return gear;
  }
}
