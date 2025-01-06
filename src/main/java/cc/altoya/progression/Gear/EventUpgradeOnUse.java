package cc.altoya.progression.Gear;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class EventUpgradeOnUse implements Listener {
  @EventHandler
  public void handleBreakEvent(BlockBreakEvent event) {
    Player player = event.getPlayer();
    GearUtil.updatePlayerGear(player);
  }
}
