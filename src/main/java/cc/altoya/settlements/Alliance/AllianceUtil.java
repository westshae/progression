package cc.altoya.settlements.Alliance;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import cc.altoya.settlements.Util.GeneralUtil;

public class AllianceUtil {
    public static FileConfiguration getAllianceConfig() {
        return GeneralUtil.getPluginConfig("settlements", "alliances.yml");
    }

    public static void saveAllianceConfig(FileConfiguration config) {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("settlements").getDataFolder(),
                "alliances.yml");
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static HashMap<String, String> getAllianceCommands() {
        HashMap<String, String> commands = new HashMap<>();
        commands.put("/alliance create {allianceName}", "The first command to create an alliance.");
        commands.put("/alliance info", "Prints out information about the alliance. Eg players, name, wealth.");
        commands.put("/alliance help", "The command you're looking at right now.");

        return commands;
    }

}
