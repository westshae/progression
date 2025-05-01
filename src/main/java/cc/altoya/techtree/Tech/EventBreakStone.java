package cc.altoya.techtree.Tech;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class EventBreakStone implements Listener {
  @EventHandler
  public void onBreakStone(BlockBreakEvent event) {
    if(event.getBlock().getType() != Material.STONE) return;
    SingletonTechTree.handleBreakStone(event.getPlayer());
  }
}
