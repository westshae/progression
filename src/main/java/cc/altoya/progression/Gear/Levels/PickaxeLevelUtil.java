package cc.altoya.progression.Gear.Levels;

import java.util.HashMap;
import java.util.UUID;

import cc.altoya.progression.Experience.Experience;
import cc.altoya.progression.Experience.SingletonExperienceBank;
import cc.altoya.progression.Gear.GearUtil;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class PickaxeLevelUtil {
  private static int getPickaxeLevelFromXp(int xp) {
    int[] thresholds = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70 }; // 14 levels
    for (int i = 0; i < thresholds.length; i++) {
      if (xp <= thresholds[i]) {
        return i + 1;
      }
    }
    return thresholds.length + 1;
    }

    public static boolean willPlayerUpdatePickaxe(UUID uuid, int xpGain){
    int currentLevel = getPickaxeLevelFromXp(SingletonExperienceBank.getExperience(Experience.PICKAXE, uuid));
    int newLevel = getPickaxeLevelFromXp(SingletonExperienceBank.getExperience(Experience.PICKAXE, uuid) + xpGain);

    return newLevel > currentLevel;
    }

    public static int getExperienceFromBreak(Material material) {
      return switch (material) {
        case STONE -> 1;
        case COAL_ORE -> 2;
        case COPPER_ORE -> 3;
        case IRON_ORE -> 4;
        case LAPIS_ORE -> 5;
        case REDSTONE_ORE -> 6;
        case GOLD_ORE -> 7;
        case DIAMOND_ORE -> 8;
        case EMERALD_ORE -> 9;
        default -> 0;
      };
    }  

    public static ItemStack getPickaxeViaUuid(UUID uuid){
      int experience = SingletonExperienceBank.getExperience(Experience.PICKAXE, uuid);
      int level = getPickaxeLevelFromXp(experience);
  
      return getPickaxeViaLevel(level);
    }

    public static ItemStack getPickaxeViaLevel(int level) {
    String key = "progression_pickaxe";

    switch (level) {
      case 1 -> {
        return GearUtil.createCustomGear(key, Material.WOODEN_PICKAXE, new HashMap<Enchantment, Integer>());
      }
      case 2 -> {
        return GearUtil.createCustomGear(key, Material.WOODEN_PICKAXE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 1);
          }
        });
      }
      case 3 -> {
        return GearUtil.createCustomGear(key, Material.STONE_PICKAXE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 1);
          }
        });
      }
      case 4 -> {
        return GearUtil.createCustomGear(key, Material.STONE_PICKAXE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 2);
          }
        });
      }
      case 5 -> {
        return GearUtil.createCustomGear(key, Material.GOLDEN_PICKAXE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 2);
          }
        });
      }
      case 6-> {
        return GearUtil.createCustomGear(key, Material.GOLDEN_PICKAXE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 3);
          }
        });
      }
      case 7 -> {
        return GearUtil.createCustomGear(key, Material.IRON_PICKAXE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 3);
          }
        });
      }
      case 8 -> {
        return GearUtil.createCustomGear(key, Material.IRON_PICKAXE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 4);
          }
        });
      }
      case 9 -> {
        return GearUtil.createCustomGear(key, Material.IRON_PICKAXE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 4);
            put(Enchantment.FORTUNE, 1);
          }
        });
      }

      case 10 -> {
        return GearUtil.createCustomGear(key, Material.DIAMOND_PICKAXE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 4);
            put(Enchantment.FORTUNE, 1);
          }
        });
      }
      case 11 -> {
        return GearUtil.createCustomGear(key, Material.DIAMOND_PICKAXE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 5);
            put(Enchantment.FORTUNE, 1);
          }
        });
      }
      case 12 -> {
        return GearUtil.createCustomGear(key, Material.DIAMOND_PICKAXE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 5);
            put(Enchantment.FORTUNE, 2);
          }
        });
      }
      case 13 -> {
        return GearUtil.createCustomGear(key, Material.NETHERITE_PICKAXE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 5);
            put(Enchantment.FORTUNE, 2);
          }
        });
      }
      case 14 -> {
        return GearUtil.createCustomGear(key, Material.NETHERITE_PICKAXE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 5);
            put(Enchantment.FORTUNE, 3);
          }
        });
      }

      default -> {
        return GearUtil.createCustomGear(key, Material.NETHERITE_PICKAXE, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.EFFICIENCY, 5);
            put(Enchantment.FORTUNE, 3);
          }
        });
      }
    }
  }
}
