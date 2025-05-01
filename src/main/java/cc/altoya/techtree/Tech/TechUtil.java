package cc.altoya.techtree.Tech;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import cc.altoya.techtree.Util.GeneralUtil;

public class TechUtil {
  public static FileConfiguration getTechConfig() {
    return GeneralUtil.getPluginConfig("techtree", "tech.yml");
  }

  public static void saveTechConfig(FileConfiguration config) {
    File file = new File(Bukkit.getServer().getPluginManager().getPlugin("techtree").getDataFolder(),
        "tech.yml");
    try {
      config.save(file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static HashMap<String, String> getTechCommands() {
    HashMap<String, String> commands = new HashMap<>();
    commands.put("/tech help", "The command you're looking at right now.");

    return commands;
  }

}
