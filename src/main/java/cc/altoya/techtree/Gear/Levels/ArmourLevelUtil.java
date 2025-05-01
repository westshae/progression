package cc.altoya.techtree.Gear.Levels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import cc.altoya.techtree.Experience.Experience;
import cc.altoya.techtree.Experience.SingletonExperienceBank;
import cc.altoya.techtree.Gear.GearUtil;

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

  public static List<ItemStack> getArmourViaUuid(UUID uuid){
    int experience = SingletonExperienceBank.getExperience(Experience.ARMOUR, uuid);
    int level = getArmourLevelFromXp(experience);

    return getArmourViaLevel(level);
  }

  public static List<ItemStack> getArmourViaLevel(int level) {
    String key = "progression_armour";
    String levelString = Integer.toString(level);

    List<ItemStack> gear = new ArrayList<>();

    switch (level) {
      case 1 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.LEATHER_HELMET, new HashMap<Enchantment, Integer>()));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.LEATHER_CHESTPLATE, new HashMap<Enchantment, Integer>()));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.LEATHER_LEGGINGS, new HashMap<Enchantment, Integer>()));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.LEATHER_BOOTS, new HashMap<Enchantment, Integer>()));
      }
      case 2 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.LEATHER_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.LEATHER_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.LEATHER_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.LEATHER_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        }));
      }
      case 3 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.CHAINMAIL_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.CHAINMAIL_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.CHAINMAIL_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.CHAINMAIL_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        }));
      }
      case 4 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.CHAINMAIL_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.CHAINMAIL_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.CHAINMAIL_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.CHAINMAIL_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
      }
      case 5 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.GOLDEN_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.GOLDEN_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.GOLDEN_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.GOLDEN_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
      }
      case 6 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.GOLDEN_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.GOLDEN_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.GOLDEN_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.GOLDEN_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
            put(Enchantment.FEATHER_FALLING, 1);
          }
        }));
      }
      case 7 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.GOLDEN_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.GOLDEN_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.GOLDEN_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.GOLDEN_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
            put(Enchantment.FEATHER_FALLING, 2);
          }
        }));
      }
      case 8 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.IRON_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.IRON_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.IRON_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.IRON_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
            put(Enchantment.FEATHER_FALLING, 2);
          }
        }));
      }
      case 9 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.IRON_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.IRON_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.IRON_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.IRON_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
            put(Enchantment.FEATHER_FALLING, 2);
            put(Enchantment.DEPTH_STRIDER, 1);
          }
        }));
      }
      case 10 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.IRON_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.IRON_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.IRON_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.IRON_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
            put(Enchantment.FEATHER_FALLING, 2);
            put(Enchantment.DEPTH_STRIDER, 2);
          }
        }));
      }
      case 11 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
            put(Enchantment.FEATHER_FALLING, 2);
            put(Enchantment.DEPTH_STRIDER, 2);
          }
        }));
      }
      case 12 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
            put(Enchantment.FEATHER_FALLING, 2);
            put(Enchantment.DEPTH_STRIDER, 2);
          }
        }));
      }
      case 13 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
            put(Enchantment.FEATHER_FALLING, 3);
            put(Enchantment.DEPTH_STRIDER, 2);
          }
        }));
      }
      case 14 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.DIAMOND_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
            put(Enchantment.FEATHER_FALLING, 3);
            put(Enchantment.DEPTH_STRIDER, 3);
          }
        }));
      }
      case 15 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
            put(Enchantment.FEATHER_FALLING, 3);
            put(Enchantment.DEPTH_STRIDER, 3);
          }
        }));
      }
      case 16 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 3);
            put(Enchantment.DEPTH_STRIDER, 3);
          }
        }));
      }
      case 17 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
          }
        }));
      }
      case 18 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 1);
          }
        }));
      }
      case 19 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 2);
          }
        }));
      }
      case 20 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        }));
      }
      case 21 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        }));
      }
      case 22 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 1);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        }));
      }
      case 23 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        }));
      }
      case 24 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_CHESTPLATE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        }));
      }
      case 25 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.ELYTRA, new HashMap<Enchantment, Integer>()));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        }));
      }
      case 26 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.ELYTRA, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 1);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        }));
      }
      case 27 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.ELYTRA, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 2);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        }));
      }
      case 28 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.ELYTRA, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        }));
      }
      case 29 -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.ELYTRA, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        }));
      }
      default -> {
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HELMET, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.AQUA_AFFINITY, 1);
            put(Enchantment.RESPIRATION, 3);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.ELYTRA, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_LEGGINGS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
          }
        }));
        gear.add(GearUtil.createCustomGear(key, levelString, Material.NETHERITE_BOOTS, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PROTECTION, 4);
            put(Enchantment.FEATHER_FALLING, 4);
            put(Enchantment.DEPTH_STRIDER, 3);
            put(Enchantment.SOUL_SPEED, 3);
          }
        }));
      }
    }

    return gear;
  }
}
