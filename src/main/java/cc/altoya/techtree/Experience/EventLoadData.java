package cc.altoya.techtree.Experience;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventLoadData implements Listener {
  @EventHandler
  public void handlePlayerLeave(PlayerQuitEvent event) {
    Player player = event.getPlayer();
    UUID uuid = player.getUniqueId();

    ExperienceUtil.savePlayerExperienceToDB(uuid);
  }

  @EventHandler
  public void handlePlayerJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    UUID uuid = player.getUniqueId();

    ExperienceUtil.loadPlayerExperienceIntoSingleton(uuid);
  }
}