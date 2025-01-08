package cc.altoya.progression.Gear.Levels;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Entity;

import cc.altoya.progression.Experience.Experience;
import cc.altoya.progression.Experience.SingletonExperienceBank;
import cc.altoya.progression.Gear.GearUtil;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class RangedLevelUtil {
  private static int getRangedLevelFromXp(int xp) {
    int[] thresholds = { 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75 }; // 15 levels
    for (int i = 0; i < thresholds.length; i++) {
      if (xp <= thresholds[i]) {
        return i + 1;
      }
    }
    return thresholds.length + 1;
  }

  public static boolean willPlayerUpdateRanged(UUID uuid, int xpGain){
    int currentLevel = getRangedLevelFromXp(SingletonExperienceBank.getExperience(Experience.RANGED, uuid));
    int newLevel = getRangedLevelFromXp(SingletonExperienceBank.getExperience(Experience.RANGED, uuid) + xpGain);

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

  public static ItemStack getRangedViaUuid(UUID uuid){
    int experience = SingletonExperienceBank.getExperience(Experience.RANGED, uuid);
    int level = getRangedLevelFromXp(experience);

    return getRangedViaLevel(level);
  }


  public static ItemStack getRangedViaLevel(int level) {
    String key = "progression_ranged";
    String levelString = Integer.toString(level);

    switch (level) {
      case 1 -> {
        return GearUtil.createCustomGear(key, levelString, Material.BOW, new HashMap<Enchantment, Integer>());
      }
      case 2 -> {
        return GearUtil.createCustomGear(key, levelString, Material.BOW, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.POWER, 1);
          }
        });
      }
      case 3 -> {
        return GearUtil.createCustomGear(key, levelString, Material.BOW, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.POWER, 2);
          }
        });
      }
      case 4 -> {
        return GearUtil.createCustomGear(key, levelString, Material.BOW, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.POWER, 3);
          }
        });
      }
      case 5 -> {
        return GearUtil.createCustomGear(key, levelString, Material.BOW, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.POWER, 3);
            put(Enchantment.FLAME, 1);
          }
        });
      }
      case 6 -> {
        return GearUtil.createCustomGear(key, levelString, Material.BOW, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.POWER, 4);
            put(Enchantment.FLAME, 1);
          }
        });
      }
      case 7 -> {
        return GearUtil.createCustomGear(key, levelString, Material.BOW, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.POWER, 4);
            put(Enchantment.FLAME, 1);
            put(Enchantment.INFINITY, 1);
          }
        });
      }
      case 8 -> {
        return GearUtil.createCustomGear(key, levelString, Material.BOW, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.POWER, 5);
            put(Enchantment.FLAME, 1);
            put(Enchantment.INFINITY, 1);
          }
        });
      }
      case 9 -> {
        return GearUtil.createCustomGear(key, levelString, Material.CROSSBOW, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PIERCING, 1);
            
          }
        });
      }
      case 10 -> {
        return GearUtil.createCustomGear(key, levelString, Material.CROSSBOW, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PIERCING, 1);
            put(Enchantment.QUICK_CHARGE, 1);
          }
        });
      }
      case 11 -> {
        return GearUtil.createCustomGear(key, levelString, Material.CROSSBOW, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PIERCING, 2);
            put(Enchantment.QUICK_CHARGE, 1);
          }
        });
      }
      case 12 -> {
        return GearUtil.createCustomGear(key, levelString, Material.CROSSBOW, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PIERCING, 2);
            put(Enchantment.QUICK_CHARGE, 2);
          }
        });
      }
      case 13 -> {
        return GearUtil.createCustomGear(key, levelString, Material.CROSSBOW, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PIERCING, 3);
            put(Enchantment.QUICK_CHARGE, 2);
          }
        });
      }
      case 14 -> {
        return GearUtil.createCustomGear(key, levelString, Material.CROSSBOW, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PIERCING, 3);
            put(Enchantment.QUICK_CHARGE, 3);
          }
        });
      }
      case 15 -> {
        return GearUtil.createCustomGear(key, levelString, Material.CROSSBOW, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PIERCING, 3);
            put(Enchantment.QUICK_CHARGE, 3);
            put(Enchantment.MULTISHOT, 1);
          }
        });
      }
      default -> {
        return GearUtil.createCustomGear(key, levelString, Material.CROSSBOW, new HashMap<Enchantment, Integer>() {
          {
            put(Enchantment.PIERCING, 3);
            put(Enchantment.QUICK_CHARGE, 3);
            put(Enchantment.MULTISHOT, 1);
          }
        });
      }
    }
  }
}
