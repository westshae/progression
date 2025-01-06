package cc.altoya.progression.Gear.Levels;

import java.util.HashMap;
import java.util.UUID;

import cc.altoya.progression.Experience.Experience;
import cc.altoya.progression.Experience.SingletonExperienceBank;
import cc.altoya.progression.Gear.GearUtil;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class FishingLevelUtil {
  private static int getFishingLevelFromXp(int xp) {
    int[] thresholds = { 5, 10, 15, 20, 25, 30 }; // 6 levels
    for (int i = 0; i < thresholds.length; i++) {
      if (xp <= thresholds[i]) {
        return i + 1;
      }
    }
    return thresholds.length + 1;
  }

  public static boolean willPlayerUpdateFishing(UUID uuid, int xpGain){
    int currentLevel = getFishingLevelFromXp(SingletonExperienceBank.getExperience(Experience.FISHING, uuid));
    int newLevel = getFishingLevelFromXp(SingletonExperienceBank.getExperience(Experience.FISHING, uuid) + xpGain);

    return newLevel > currentLevel;
  }

  public static int getExperienceFromCatch(Material material) {
    return switch (material) {
      case COD -> 5;
      case SALMON -> 10;
      case PUFFERFISH -> 20;
      case TROPICAL_FISH -> 20;
      default -> 0;
    };
  }

  public static ItemStack getFishingViaLevel(UUID uuid) {
    int experience = SingletonExperienceBank.getExperience(Experience.FISHING, uuid);
    int level = getFishingLevelFromXp(experience);

    String key = "progression_fishing";

    switch (level) {
      case 1 -> {
        return GearUtil.createCustomGear(key, Material.FISHING_ROD, new HashMap<Enchantment, Integer>());
      }
      case 2 -> {
        return GearUtil.createCustomGear(key, Material.FISHING_ROD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.LUCK_OF_THE_SEA, 1);
          }
        });
      }
      case 3 -> {
        return GearUtil.createCustomGear(key, Material.FISHING_ROD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.LUCK_OF_THE_SEA, 1);
            put(Enchantment.LURE, 1);
          }
        });
      }
      case 4 -> {
        return GearUtil.createCustomGear(key, Material.FISHING_ROD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.LUCK_OF_THE_SEA, 2);
            put(Enchantment.LURE, 1);
          }
        });
      }
      case 5 -> {
        return GearUtil.createCustomGear(key, Material.FISHING_ROD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.LUCK_OF_THE_SEA, 2);
            put(Enchantment.LURE, 2);
          }
        });
      }
      case 6 -> {
        return GearUtil.createCustomGear(key, Material.FISHING_ROD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.LUCK_OF_THE_SEA, 3);
            put(Enchantment.LURE, 2);
          }
        });
      }
      case 7 -> {
        return GearUtil.createCustomGear(key, Material.FISHING_ROD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.LUCK_OF_THE_SEA, 3);
            put(Enchantment.LURE, 3);
          }
        });
      }

      default -> {
        return GearUtil.createCustomGear(key, Material.FISHING_ROD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.LUCK_OF_THE_SEA, 3);
            put(Enchantment.LURE, 3);
          }
        });
      }
    }
  }
}
