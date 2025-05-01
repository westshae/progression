package cc.altoya.techtree.Gear.Levels;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import cc.altoya.techtree.Experience.Experience;
import cc.altoya.techtree.Experience.SingletonExperienceBank;
import cc.altoya.techtree.Gear.GearUtil;

public class HoeLevelUtil {
  private static int getHoeLevelFromXp(int xp) {
    int[] thresholds = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70 }; // 14 levels
    for (int i = 0; i < thresholds.length; i++) {
      if (xp <= thresholds[i]) {
        return i + 1;
      }
    }
    return thresholds.length + 1;
  }

  public static boolean willPlayerUpdateHoe(UUID uuid, int xpGain) {
    int currentLevel = getHoeLevelFromXp(SingletonExperienceBank.getExperience(Experience.HOE, uuid));
    int newLevel = getHoeLevelFromXp(SingletonExperienceBank.getExperience(Experience.HOE, uuid) + xpGain);

    return newLevel > currentLevel;
  }

  public static int getExperienceFromBreak(Material material) {
    return switch (material) {
      case WHEAT -> 1;
      case CARROTS -> 2;
      case POTATOES -> 3;
      case BEETROOTS -> 4;
      case NETHER_WART -> 5;
      case MELON -> 6;
      case PUMPKIN -> 7;
      case SUGAR_CANE -> 8;
      case CACTUS -> 9;
      default -> 0;
    };
  }

  public static ItemStack getHoeViaUuid(UUID uuid){
    int experience = SingletonExperienceBank.getExperience(Experience.HOE, uuid);
    int level = getHoeLevelFromXp(experience);

    return getHoeViaLevel(level);
  }


  public static ItemStack getHoeViaLevel(int level) {
    String levelString = Integer.toString(level);

    String key = "progression_hoe";

    switch (level) {
      case 1 -> {
        return GearUtil.createCustomGear(key, levelString, Material.WOODEN_HOE, new HashMap<Enchantment, Integer>());
      }
      case 2 -> {
        return GearUtil.createCustomGear(key, levelString, Material.WOODEN_HOE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 1);
          }
        });
      }
      case 3 -> {
        return GearUtil.createCustomGear(key, levelString, Material.GOLDEN_HOE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 1);
          }
        });
      }
      case 4 -> {
        return GearUtil.createCustomGear(key, levelString, Material.GOLDEN_HOE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 2);
          }
        });
      }
      case 5 -> {
        return GearUtil.createCustomGear(key, levelString, Material.STONE_HOE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 2);
          }
        });
      }
      case 6 -> {
        return GearUtil.createCustomGear(key, levelString, Material.STONE_HOE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 3);
          }
        });
      }
      case 7 -> {
        return GearUtil.createCustomGear(key, levelString, Material.IRON_HOE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 3);
          }
        });
      }
      case 8 -> {
        return GearUtil.createCustomGear(key, levelString, Material.IRON_HOE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 4);
          }
        });
      }
      case 9 -> {
        return GearUtil.createCustomGear(key, levelString, Material.IRON_HOE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 4);
            put(Enchantment.FORTUNE, 1);
          }
        });
      }
      case 10 -> {
        return GearUtil.createCustomGear(key, levelString, Material.DIAMOND_HOE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 4);
            put(Enchantment.FORTUNE, 1);
          }
        });
      }
      case 11 -> {
        return GearUtil.createCustomGear(key, levelString, Material.DIAMOND_HOE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 5);
            put(Enchantment.FORTUNE, 1);
          }
        });
      }
      case 12 -> {
        return GearUtil.createCustomGear(key, levelString, Material.DIAMOND_HOE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 5);
            put(Enchantment.FORTUNE, 2);
          }
        });
      }
      case 13 -> {
        return GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HOE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 5);
            put(Enchantment.FORTUNE, 2);
          }
        });
      }
      case 14 -> {
        return GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HOE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 5);
            put(Enchantment.FORTUNE, 3);
          }
        });
      }
      default -> {
        return GearUtil.createCustomGear(key, levelString, Material.NETHERITE_HOE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 5);
            put(Enchantment.FORTUNE, 3);
          }
        });
      }
    }
  }
}
