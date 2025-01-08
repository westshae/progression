package cc.altoya.progression.Gear;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class EventFirstGear implements Listener {

  @EventHandler
  public void onPlayerFirstJoin(PlayerJoinEvent event) {
    if(event.getPlayer().hasPlayedBefore()) return;
    GearUtil.initPlayerGear(event.getPlayer());
  }

  @EventHandler
  public void onPlayerRespawn(PlayerRespawnEvent event) {
    GearUtil.initPlayerGear(event.getPlayer());
  }
}
