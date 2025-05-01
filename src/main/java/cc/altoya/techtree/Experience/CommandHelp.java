package cc.altoya.techtree.Experience;

import org.bukkit.entity.Player;

import cc.altoya.techtree.Util.ChatUtil;
import cc.altoya.techtree.Util.GeneralUtil;

public class CommandHelp {
    public static boolean handle(Player sender, String[] args) {
        if (!GeneralUtil.handlePermissionsAndArguments(sender, "progression", args, 1)) {
            return true;
        }

        help(sender);
        return true;
    }

    private static void help(Player player) {
        ChatUtil.sendCommandHelpMessage(player, "/experience", ExperienceUtil.getExperienceCommands());
    }
}
