package cc.altoya.progression.Gear;

import org.bukkit.entity.Player;

import cc.altoya.progression.Util.ChatUtil;
import cc.altoya.progression.Util.GeneralUtil;

public class CommandUpdateGear {
    public static boolean handle(Player sender, String[] args) {
        if (!GeneralUtil.handlePermissionsAndArguments(sender, "progression", args, 1)) {
            return true;
        }

        updateGear(sender);
        return true;
    }

    private static void updateGear(Player player) {
        GearUtil.initPlayerGear(player);
        ChatUtil.sendSuccessMessage(player, "Gear updated");
    }
}
