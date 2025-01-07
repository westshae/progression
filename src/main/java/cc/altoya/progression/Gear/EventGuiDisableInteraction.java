package cc.altoya.progression.Gear;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class EventGuiDisableInteraction implements Listener {
  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    if (event.getView().title().toString().toLowerCase().contains("gui")) {
      event.setCancelled(true);
    }
  }
}
