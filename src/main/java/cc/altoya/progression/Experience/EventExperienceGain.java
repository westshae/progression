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
    Player player = event.getPlayer();
    UUID uuid = player.getUniqueId();

    Material blockType = event.getBlock().getType();
    Experience xpType = Experience.PICKAXE;

    switch (blockType) {
      case GRASS_BLOCK:
        xpType = Experience.SHOVEL;
        break;
      case STONE:
        xpType = Experience.PICKAXE;
        break;
      case WHEAT:
        xpType = Experience.HOE;
        break;
      case OAK_LOG:
        xpType = Experience.AXE;
        break;    
      default:
        return;
    }

    SingletonExperienceBank.addExperience(xpType, uuid, 1);
    ChatUtil.sendSuccessBar(player, xpType.toString() + " XP: " + SingletonExperienceBank.getExperience(xpType, uuid));
  }
}