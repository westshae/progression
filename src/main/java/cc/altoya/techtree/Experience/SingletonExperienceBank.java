package cc.altoya.techtree.Experience;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class SingletonExperienceBank {
  private static final Map<UUID, Integer> pickaxeExperienceMap = new HashMap<>();
  private static final Map<UUID, Integer> axeExperienceMap = new HashMap<>();
  private static final Map<UUID, Integer> shovelExperienceMap = new HashMap<>();
  private static final Map<UUID, Integer> hoeExperienceMap = new HashMap<>();
  private static final Map<UUID, Integer> meleeExperienceMap = new HashMap<>();
  private static final Map<UUID, Integer> rangedExperienceMap = new HashMap<>();
  private static final Map<UUID, Integer> armourExperienceMap = new HashMap<>();
  private static final Map<UUID, Integer> fishingExperienceMap = new HashMap<>();

  public static void addExperience(Experience experienceType, UUID uuid, int amount) {
    switch (experienceType) {
      case PICKAXE:
        pickaxeExperienceMap.put(uuid, pickaxeExperienceMap.getOrDefault(uuid, 0) + amount);
        break;
      case AXE:
        axeExperienceMap.put(uuid, axeExperienceMap.getOrDefault(uuid, 0) + amount);
        break;
      case SHOVEL:
        shovelExperienceMap.put(uuid, shovelExperienceMap.getOrDefault(uuid, 0) + amount);
        break;
      case HOE:
        hoeExperienceMap.put(uuid, hoeExperienceMap.getOrDefault(uuid, 0) + amount);
        break;
      case MELEE:
        meleeExperienceMap.put(uuid, meleeExperienceMap.getOrDefault(uuid, 0) + amount);
        break;
      case RANGED:
        rangedExperienceMap.put(uuid, rangedExperienceMap.getOrDefault(uuid, 0) + amount);
        break;
      case ARMOUR:
        armourExperienceMap.put(uuid, armourExperienceMap.getOrDefault(uuid, 0) + amount);
        break;
      case FISHING:
        fishingExperienceMap.put(uuid, fishingExperienceMap.getOrDefault(uuid, 0) + amount);
        break;
      default:
        break;
    }
  }

  public static int getExperience(Experience experienceType, UUID uuid) {
    switch (experienceType) {
      case PICKAXE:
        return pickaxeExperienceMap.getOrDefault(uuid, 0);
      case AXE:
        return axeExperienceMap.getOrDefault(uuid, 0);
      case SHOVEL:
        return shovelExperienceMap.getOrDefault(uuid, 0);
      case HOE:
        return hoeExperienceMap.getOrDefault(uuid, 0);
      case MELEE:
        return meleeExperienceMap.getOrDefault(uuid, 0);
      case RANGED:
        return rangedExperienceMap.getOrDefault(uuid, 0);
      case ARMOUR:
        return armourExperienceMap.getOrDefault(uuid, 0);
      case FISHING:
        return fishingExperienceMap.getOrDefault(uuid, 0);
      default:
        return 0;
    }
  }

  public static void removeUuid(UUID uuid) {
    pickaxeExperienceMap.remove(uuid);
    axeExperienceMap.remove(uuid);
    shovelExperienceMap.remove(uuid);
    hoeExperienceMap.remove(uuid);
    meleeExperienceMap.remove(uuid);
    rangedExperienceMap.remove(uuid);
    armourExperienceMap.remove(uuid);
    fishingExperienceMap.remove(uuid);
  }

  public static List<UUID> getAllKeys() {
    Set<UUID> uniqueKeys = new HashSet<>();
    uniqueKeys.addAll(pickaxeExperienceMap.keySet());
    uniqueKeys.addAll(axeExperienceMap.keySet());
    uniqueKeys.addAll(shovelExperienceMap.keySet());
    uniqueKeys.addAll(hoeExperienceMap.keySet());
    uniqueKeys.addAll(meleeExperienceMap.keySet());
    uniqueKeys.addAll(rangedExperienceMap.keySet());
    uniqueKeys.addAll(armourExperienceMap.keySet());
    uniqueKeys.addAll(fishingExperienceMap.keySet());
    return new ArrayList<>(uniqueKeys);
  }
}
