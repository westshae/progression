package cc.altoya.techtree.Gear.Levels;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Entity;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import cc.altoya.techtree.Experience.Experience;
import cc.altoya.techtree.Experience.SingletonExperienceBank;
import cc.altoya.techtree.Gear.GearUtil;

public class MeleeLevelUtil {
  private static int getMeleeLevelFromXp(int xp) {
    int[] thresholds = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90 }; // 18 levels
    for (int i = 0; i < thresholds.length; i++) {
      if (xp <= thresholds[i]) {
        return i + 1;
      }
    }
    return thresholds.length + 1;
  }

  public static boolean willPlayerUpdateMelee(UUID uuid, int xpGain){
    int currentLevel = getMeleeLevelFromXp(SingletonExperienceBank.getExperience(Experience.MELEE, uuid));
    int newLevel = getMeleeLevelFromXp(SingletonExperienceBank.getExperience(Experience.MELEE, uuid) + xpGain);

    return newLevel > currentLevel;
  }

  public static int getExperienceFromKill(Entity entity) {
    return switch (entity.getType()) {
      case ZOMBIE -> 1;
      case SKELETON -> 2;
      case SPIDER -> 3;
      case CREEPER -> 4;
      case ENDERMAN -> 5;
      case WITCH -> 6;
      case PIGLIN -> 7;
      case BLAZE -> 8;
      case GHAST -> 9;
      case MAGMA_CUBE -> 10;
      case WITHER_SKELETON -> 11;
      case STRAY -> 12;
      case HUSK -> 13;
      case DROWNED -> 14;
      case PHANTOM -> 15;
      case PIGLIN_BRUTE -> 16;
      case VINDICATOR -> 17;
      default -> 0;
    };
  }

  public static ItemStack getMeleeViaUuid(UUID uuid){
    int experience = SingletonExperienceBank.getExperience(Experience.MELEE, uuid);
    int level = getMeleeLevelFromXp(experience);

    return getMeleeViaLevel(level);
  }



  public static ItemStack getMeleeViaLevel(int level) {
    String key = "progression_melee";
    String levelString = Integer.toString(level);

    switch (level) {
      case 1 -> {
        return GearUtil.createCustomGear(key, levelString, Material.WOODEN_SWORD, new HashMap<Enchantment, Integer>());
      }
      case 2 -> {
        return GearUtil.createCustomGear(key, levelString, Material.WOODEN_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 1);
          }
        });
      }
      case 3 -> {
        return GearUtil.createCustomGear(key, levelString, Material.STONE_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 1);
          }
        });
      }
      case 4 -> {
        return GearUtil.createCustomGear(key, levelString, Material.STONE_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 2);
          }
        });
      }
      case 5 -> {
        return GearUtil.createCustomGear(key, levelString, Material.GOLDEN_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 2);
          }
        });
      }
      case 6 -> {
        return GearUtil.createCustomGear(key, levelString, Material.GOLDEN_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 3);
          }
        });
      }
      case 7 -> {
        return GearUtil.createCustomGear(key, levelString, Material.IRON_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 3);
          }
        });
      }
      case 8 -> {
        return GearUtil.createCustomGear(key, levelString, Material.IRON_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 4);
          }
        });
      }
      case 9 -> {
        return GearUtil.createCustomGear(key, levelString, Material.IRON_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 4);
            put(Enchantment.LOOTING, 1);
            put(Enchantment.SWEEPING_EDGE, 1);
          }
        });
      }
      case 10 -> {
        return GearUtil.createCustomGear(key, levelString, Material.DIAMOND_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 4);
            put(Enchantment.LOOTING, 1);
            put(Enchantment.SWEEPING_EDGE, 1);
          }
        });
      }
      case 11 -> {
        return GearUtil.createCustomGear(key, levelString, Material.DIAMOND_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 5);
            put(Enchantment.LOOTING, 1);
            put(Enchantment.SWEEPING_EDGE, 1);
          }
        });
      }
      case 12 -> {
        return GearUtil.createCustomGear(key, levelString, Material.DIAMOND_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 5);
            put(Enchantment.LOOTING, 2);
            put(Enchantment.SWEEPING_EDGE, 1);
          }
        });
      }
      case 13 -> {
        return GearUtil.createCustomGear(key, levelString, Material.DIAMOND_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 5);
            put(Enchantment.LOOTING, 2);
            put(Enchantment.SWEEPING_EDGE, 1);
            put(Enchantment.FIRE_ASPECT, 1);
          }
        });
      }
      case 14 -> {
        return GearUtil.createCustomGear(key, levelString, Material.DIAMOND_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 5);
            put(Enchantment.LOOTING, 2);
            put(Enchantment.SWEEPING_EDGE, 2);
            put(Enchantment.FIRE_ASPECT, 1);
          }
        });
      }

      case 15 -> {
        return GearUtil.createCustomGear(key, levelString, Material.NETHERITE_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 5);
            put(Enchantment.LOOTING, 2);
            put(Enchantment.SWEEPING_EDGE, 2);
            put(Enchantment.FIRE_ASPECT, 1);
          }
        });
      }
      case 16 -> {
        return GearUtil.createCustomGear(key, levelString, Material.NETHERITE_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 5);
            put(Enchantment.LOOTING, 3);
            put(Enchantment.SWEEPING_EDGE, 2);
            put(Enchantment.FIRE_ASPECT, 1);
          }
        });
      }
      case 17 -> {
        return GearUtil.createCustomGear(key, levelString, Material.NETHERITE_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 5);
            put(Enchantment.LOOTING, 3);
            put(Enchantment.SWEEPING_EDGE, 2);
            put(Enchantment.FIRE_ASPECT, 2);
          }
        });
      }
      case 18 -> {
        return GearUtil.createCustomGear(key, levelString, Material.NETHERITE_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 5);
            put(Enchantment.LOOTING, 3);
            put(Enchantment.SWEEPING_EDGE, 3);
            put(Enchantment.FIRE_ASPECT, 2);
          }
        });
      }

      default -> {
        return GearUtil.createCustomGear(key, levelString, Material.NETHERITE_SWORD, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.SHARPNESS, 5);
            put(Enchantment.LOOTING, 3);
            put(Enchantment.SWEEPING_EDGE, 3);
            put(Enchantment.FIRE_ASPECT, 2);
          }
        });
      }
    }
  }
}
