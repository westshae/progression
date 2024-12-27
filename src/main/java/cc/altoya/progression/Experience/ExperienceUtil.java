package cc.altoya.progression.Experience;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import cc.altoya.progression.Util.ChatUtil;
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

    public static void savePlayerExperienceToDB(UUID uuid) {
        try {
            int pickaxeExperience = SingletonExperienceBank.getExperience(Experience.PICKAXE, uuid);
            int axeExperience = SingletonExperienceBank.getExperience(Experience.AXE, uuid);
            int shovelExperience = SingletonExperienceBank.getExperience(Experience.SHOVEL, uuid);
            int hoeExperience = SingletonExperienceBank.getExperience(Experience.HOE, uuid);
            int meleeExperience = SingletonExperienceBank.getExperience(Experience.MELEE, uuid);
            int rangedExperience = SingletonExperienceBank.getExperience(Experience.RANGED, uuid);
            int armourExperience = SingletonExperienceBank.getExperience(Experience.ARMOUR, uuid);
            int fishingExperience = SingletonExperienceBank.getExperience(Experience.FISHING, uuid);

            SingletonExperienceBank.removeUuid(uuid);

            DBUtil.updatePlayerExperience(uuid, pickaxeExperience, axeExperience, shovelExperience, hoeExperience,
                    meleeExperience, rangedExperience, armourExperience, fishingExperience);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loadPlayerExperienceIntoSingleton(UUID uuid) {
        try {
            HashMap<Experience, Integer> experience = DBUtil.getPlayerExperience(uuid);
            if (experience == null) {
                return;
            }
            SingletonExperienceBank.addExperience(Experience.PICKAXE, uuid, experience.get(Experience.PICKAXE));
            SingletonExperienceBank.addExperience(Experience.AXE, uuid, experience.get(Experience.AXE));
            SingletonExperienceBank.addExperience(Experience.SHOVEL, uuid, experience.get(Experience.SHOVEL));
            SingletonExperienceBank.addExperience(Experience.HOE, uuid, experience.get(Experience.HOE));
            SingletonExperienceBank.addExperience(Experience.MELEE, uuid, experience.get(Experience.MELEE));
            SingletonExperienceBank.addExperience(Experience.RANGED, uuid, experience.get(Experience.RANGED));
            SingletonExperienceBank.addExperience(Experience.ARMOUR, uuid, experience.get(Experience.ARMOUR));
            SingletonExperienceBank.addExperience(Experience.FISHING, uuid, experience.get(Experience.FISHING));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveAllPlayerDataToDB() {
        ArrayList<UUID> keys = (ArrayList<UUID>) SingletonExperienceBank.getAllKeys();
        for (UUID key : keys) {
            ExperienceUtil.savePlayerExperienceToDB(key);
        }
    }

    public static HashMap<String, String> getExperienceCommands() {
        HashMap<String, String> commands = new HashMap<>();
        commands.put("/experience help", "The command you're looking at right now.");

        return commands;
    }

}
