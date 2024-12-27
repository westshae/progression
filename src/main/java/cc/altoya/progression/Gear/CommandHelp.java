package cc.altoya.progression.Gear;

import org.bukkit.entity.Player;

import cc.altoya.progression.Util.ChatUtil;
import cc.altoya.progression.Util.GeneralUtil;

public class CommandHelp {
    public static boolean handle(Player sender, String[] args) {
        if (!GeneralUtil.handlePermissionsAndArguments(sender, "progression", args, 1)) {
            return true;
        }

        help(sender);
        return true;
    }

    private static void help(Player player) {
        ChatUtil.sendCommandHelpMessage(player, "/gear", GearUtil.getGearCommands());
    }
}
