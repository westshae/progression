package cc.altoya.progression.Gear;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import cc.altoya.progression.Util.GeneralUtil;

public class GearUtil {
    public static FileConfiguration getGearConfig() {
        return GeneralUtil.getPluginConfig("gear", "gear.yml");
    }

    public static void saveGearConfig(FileConfiguration config) {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("gear").getDataFolder(),
                "gear.yml");
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> getGearCommands() {
        HashMap<String, String> commands = new HashMap<>();
        commands.put("/gear help", "The command you're looking at right now.");

        return commands;
    }

}
