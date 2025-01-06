package cc.altoya.progression.Gear;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventFirstGear implements Listener {

  @EventHandler
  public void onPlayerFirstJoin(PlayerJoinEvent event) {
    GearUtil.updatePlayerGear(event.getPlayer());
  }
}
