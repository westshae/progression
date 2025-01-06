package cc.altoya.progression.Gear;

import java.util.HashMap;
import java.util.UUID;

import cc.altoya.progression.Experience.Experience;
import cc.altoya.progression.Experience.SingletonExperienceBank;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class LevelsUtil {
  private static int getPickaxeLevelFromXp(int xp) {
    int[] thresholds = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70 }; // 14 levels
    for (int i = 0; i < thresholds.length; i++) {
      if (xp <= thresholds[i]) {
        return i + 1;
      }
    }
    return thresholds.length + 1;
  }

  public static ItemStack getPickaxeViaLevel(UUID uuid) {
    int miningExperience = SingletonExperienceBank.getExperience(Experience.PICKAXE, uuid);
    int miningLevel = getPickaxeLevelFromXp(miningExperience);

    String key = "progression_pickaxe";

    switch (miningLevel) {
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
