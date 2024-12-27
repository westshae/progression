package cc.altoya.progression.Experience;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import cc.altoya.progression.Util.DBUtil;
import cc.altoya.progression.Util.GeneralUtil;

public class ExperienceUtil {
    public static FileConfiguration getExperienceConfig() {
        return GeneralUtil.getPluginConfig("settlements", "experience.yml");
    }

    public static void saveExperienceConfig(FileConfiguration config) {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("progression").getDataFolder(),
                "experience.yml");
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savePlayerMiningExperienceToDB(UUID uuid){
        try {
            int miningXP = SingletonExperienceBank.getMiningExperience(uuid);
            SingletonExperienceBank.removeUuid(uuid);
        
            DBUtil.updatePlayerExperience(uuid, miningXP);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loadPlayerMiningExperienceIntoSingleton(UUID uuid){
        try {
            Integer experience = DBUtil.getPlayerExperience(uuid);
            if(experience == null){
                return;
            }
            SingletonExperienceBank.addMiningExperience(uuid, experience);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveAllPlayerDataToDB(){
        ArrayList<UUID> keys = (ArrayList<UUID>) SingletonExperienceBank.getAllKeys();
        for(UUID key : keys) {
            ExperienceUtil.savePlayerMiningExperienceToDB(key);
        }
    }


    public static HashMap<String, String> getExperienceCommands() {
        HashMap<String, String> commands = new HashMap<>();
        commands.put("/experience help", "The command you're looking at right now.");

        return commands;
    }

}
