package cc.altoya.techtree.Tech;

import org.bukkit.entity.Player;

import cc.altoya.techtree.Util.ChatUtil;
import cc.altoya.techtree.Util.GeneralUtil;

public class CommandHelp {
    public static boolean handle(Player sender, String[] args) {
        if (!GeneralUtil.handlePermissionsAndArguments(sender, "techtree", args, 1)) {
            return true;
        }

        help(sender);
        return true;
    }

    private static void help(Player player) {
        ChatUtil.sendCommandHelpMessage(player, "/tech", TechUtil.getTechCommands());
    }
}
