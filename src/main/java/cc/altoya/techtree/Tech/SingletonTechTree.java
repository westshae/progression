package cc.altoya.techtree.Tech;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

import cc.altoya.techtree.Util.ChatUtil;

public class SingletonTechTree {
  private static final Map<UUID, Integer> breakStoneTechMap = new HashMap<>();

  public static void handleBreakStone(Player player) {
    breakStoneTechMap.put(player.getUniqueId(), breakStoneTechMap.getOrDefault(player.getUniqueId(), 0) + 1);
    ChatUtil.sendSuccessBar(player, "You have broken " + breakStoneTechMap.get(player.getUniqueId()) + " stone blocks.");
  }

  public static int getBreakStoneTech(UUID uuid) {
    return breakStoneTechMap.getOrDefault(uuid, 0);
  }

  public static void initialize() {
    System.out.println("Initializing map");
    try {
      breakStoneTechMap.putAll(DBTech.getAllBreakStoneTechLevels());
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void saveAndCleanup() {
    for (UUID uuid : breakStoneTechMap.keySet()) {
      try {
        DBTech.updateTechLevel(uuid, "break_stone", getBreakStoneTech(uuid));
        breakStoneTechMap.remove(uuid);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
