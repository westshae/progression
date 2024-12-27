package cc.altoya.progression.Experience;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SingletonExperienceBank {
  private static final Map<UUID, Integer> miningExperienceMap = new HashMap<>();

  public static void addMiningExperience(UUID uuid, int amount) {
    miningExperienceMap.put(uuid, miningExperienceMap.getOrDefault(uuid, 0) + amount);
  }

  public static int getMiningExperience(UUID uuid) {
    return miningExperienceMap.getOrDefault(uuid, 0);
  }

  public static void resetExperience(UUID uuid) {
    miningExperienceMap.put(uuid, 0);
  }

  public static void removeUuid(UUID uuid) {
    if(!hasExperience(uuid)){
      return;
    }

    miningExperienceMap.remove(uuid);
  }

  public static boolean hasExperience(UUID uuid) {
    return miningExperienceMap.containsKey(uuid);
  }

  public static List<UUID> getAllKeys() {
    return new ArrayList<>(miningExperienceMap.keySet());
  }

}
