package cc.altoya.progression.Experience;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import cc.altoya.progression.Util.ChatUtil;

public class EventExperienceGain implements Listener {
  @EventHandler
  public void handleBreakEvent(BlockBreakEvent event) {
    if(!event.getBlock().getType().equals(Material.GRASS_BLOCK)){
      return;
    }

    Player player = event.getPlayer();
    UUID uuid = player.getUniqueId();

    SingletonExperienceBank.addMiningExperience(uuid, 1);
    ChatUtil.sendSuccessBar(player, "Mining XP: " + SingletonExperienceBank.getMiningExperience(uuid));
  }
}