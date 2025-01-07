package cc.altoya.progression.Gear;

import org.bukkit.entity.Player;

import cc.altoya.progression.Util.GeneralUtil;

public class CommandViewLevels {
    public static boolean handle(Player sender, String[] args) {
        if (!GeneralUtil.handlePermissionsAndArguments(sender, "progression", args, 2)) {
            return true;
        }

        String gearType = args[1];

        viewInventory(sender, gearType);
        return true;
    }

    private static void viewInventory(Player player, String gearType) {
        GearUtil.viewGearInventory(player, gearType);
    }
}
