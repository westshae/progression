package cc.altoya.progression.Gear.Levels;

import java.util.HashMap;
import java.util.UUID;

import cc.altoya.progression.Experience.Experience;
import cc.altoya.progression.Experience.SingletonExperienceBank;
import cc.altoya.progression.Gear.GearUtil;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class ShovelLevelUtil {
  private static int getShovelLevelFromXp(int xp) {
    int[] thresholds = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70 }; // 14 levels
    for (int i = 0; i < thresholds.length; i++) {
      if (xp <= thresholds[i]) {
        return i + 1;
      }
    }
    return thresholds.length + 1;
  }

  public static int getExperienceFromBreak(Material material) {
    return switch (material) {
      case DIRT -> 1;
      case GRASS_BLOCK -> 2;
      case SAND -> 3;
      case GRAVEL -> 4;
      case CLAY -> 5;
      case SOUL_SAND -> 6;
      default -> 0;
    };
  }

  public static boolean willPlayerUpdateShovel(UUID uuid, int xpGain) {
    int currentLevel = getShovelLevelFromXp(SingletonExperienceBank.getExperience(Experience.SHOVEL, uuid));
    int newLevel = getShovelLevelFromXp(SingletonExperienceBank.getExperience(Experience.SHOVEL, uuid) + xpGain);

    return newLevel > currentLevel;
  }

  public static ItemStack getShovelViaUuid(UUID uuid){
    int experience = SingletonExperienceBank.getExperience(Experience.SHOVEL, uuid);
    int level = getShovelLevelFromXp(experience);

    return getShovelViaLevel(level);
  }

  public static ItemStack getShovelViaLevel(int level) {

    String key = "progression_shovel";

    String levelString = Integer.toString(level);

    switch (level) {
      case 1 -> {
        return GearUtil.createCustomGear(key, levelString, Material.WOODEN_SHOVEL, new HashMap<Enchantment, Integer>());
      }
      case 2 -> {
        return GearUtil.createCustomGear(key, levelString, Material.WOODEN_SHOVEL, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 1);
          }
        });
      }
      case 3 -> {
        return GearUtil.createCustomGear(key, levelString, Material.GOLDEN_SHOVEL, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 1);
          }
        });
      }
      case 4 -> {
        return GearUtil.createCustomGear(key, levelString, Material.GOLDEN_SHOVEL, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 2);
          }
        });
      }
      case 5 -> {
        return GearUtil.createCustomGear(key, levelString, Material.STONE_SHOVEL, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 2);
          }
        });
      }
      case 6 -> {
        return GearUtil.createCustomGear(key, levelString, Material.STONE_SHOVEL, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 3);
          }
        });
      }
      case 7 -> {
        return GearUtil.createCustomGear(key, levelString, Material.IRON_SHOVEL, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 3);
          }
        });
      }
      case 8 -> {
        return GearUtil.createCustomGear(key, levelString, Material.IRON_SHOVEL, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 4);
          }
        });
      }
      case 9 -> {
        return GearUtil.createCustomGear(key, levelString, Material.IRON_SHOVEL, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 4);
            put(Enchantment.FORTUNE, 1);
          }
        });
      }

      case 10 -> {
        return GearUtil.createCustomGear(key, levelString, Material.DIAMOND_SHOVEL, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 4);
            put(Enchantment.FORTUNE, 1);
          }
        });
      }
      case 11 -> {
        return GearUtil.createCustomGear(key, levelString, Material.DIAMOND_SHOVEL, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 5);
            put(Enchantment.FORTUNE, 1);
          }
        });
      }
      case 12 -> {
        return GearUtil.createCustomGear(key, levelString, Material.DIAMOND_SHOVEL, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 5);
            put(Enchantment.FORTUNE, 2);
          }
        });
      }
      case 13 -> {
        return GearUtil.createCustomGear(key, levelString, Material.NETHERITE_SHOVEL, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 5);
            put(Enchantment.FORTUNE, 2);
          }
        });
      }
      case 14 -> {
        return GearUtil.createCustomGear(key, levelString, Material.NETHERITE_SHOVEL, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 5);
            put(Enchantment.FORTUNE, 3);
          }
        });
      }

      default -> {
        return GearUtil.createCustomGear(key, levelString, Material.NETHERITE_SHOVEL, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 5);
            put(Enchantment.FORTUNE, 3);
          }
        });
      }
    }
  }
}
