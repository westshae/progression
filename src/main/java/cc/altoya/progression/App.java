package cc.altoya.progression;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import cc.altoya.progression.Experience.EventExperienceGain;
import cc.altoya.progression.Experience.EventLoadData;
import cc.altoya.progression.Experience.ExperienceTabCompleter;
import cc.altoya.progression.Experience.ExperienceUtil;
import cc.altoya.progression.Experience.MainExperience;

public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        initializeConfig();

        // Register commands
        this.getCommand("experience").setExecutor(new MainExperience());

        // Register tab completers
        this.getCommand("experience").setTabCompleter(new ExperienceTabCompleter());

        // Register eventListeners
        this.getServer().getPluginManager().registerEvents(new EventExperienceGain(), this);
        this.getServer().getPluginManager().registerEvents(new EventLoadData(), this);
    }

    @Override
    public void onDisable() {
        ExperienceUtil.saveAllPlayerDataToDB();
    }

    private void initializeConfig() {
        File configFile = new File(getDataFolder(), "config.yml");

        if (!configFile.exists()) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }
}
