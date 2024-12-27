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
        return GeneralUtil.getPluginConfig("progression", "experience.yml");
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
            // Use containsKey to ensure the key exists in the map before accessing the value
            if (experience.containsKey(Experience.PICKAXE)) {
                SingletonExperienceBank.addExperience(Experience.PICKAXE, uuid, experience.get(Experience.PICKAXE));
            }
            if (experience.containsKey(Experience.AXE)) {
                SingletonExperienceBank.addExperience(Experience.AXE, uuid, experience.get(Experience.AXE));
            }
            if (experience.containsKey(Experience.SHOVEL)) {
                SingletonExperienceBank.addExperience(Experience.SHOVEL, uuid, experience.get(Experience.SHOVEL));
            }
            if (experience.containsKey(Experience.HOE)) {
                SingletonExperienceBank.addExperience(Experience.HOE, uuid, experience.get(Experience.HOE));
            }
            if (experience.containsKey(Experience.MELEE)) {
                SingletonExperienceBank.addExperience(Experience.MELEE, uuid, experience.get(Experience.MELEE));
            }
            if (experience.containsKey(Experience.RANGED)) {
                SingletonExperienceBank.addExperience(Experience.RANGED, uuid, experience.get(Experience.RANGED));
            }
            if (experience.containsKey(Experience.ARMOUR)) {
                SingletonExperienceBank.addExperience(Experience.ARMOUR, uuid, experience.get(Experience.ARMOUR));
            }
            if (experience.containsKey(Experience.FISHING)) {
                SingletonExperienceBank.addExperience(Experience.FISHING, uuid, experience.get(Experience.FISHING));
            }

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
