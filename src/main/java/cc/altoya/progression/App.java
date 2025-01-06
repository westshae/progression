package cc.altoya.progression;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import cc.altoya.progression.Experience.EventExperienceGain;
import cc.altoya.progression.Experience.EventLoadData;
import cc.altoya.progression.Experience.ExperienceTabCompleter;
import cc.altoya.progression.Experience.ExperienceUtil;
import cc.altoya.progression.Experience.MainExperience;
import cc.altoya.progression.Gear.EventFirstGear;
import cc.altoya.progression.Gear.EventGearObtaining;
import cc.altoya.progression.Gear.GearTabCompleter;
import cc.altoya.progression.Gear.MainGear;

public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        initializeConfig();

        // Register commands
        this.getCommand("experience").setExecutor(new MainExperience());
        this.getCommand("gear").setExecutor(new MainGear());

        // Register tab completers
        this.getCommand("experience").setTabCompleter(new ExperienceTabCompleter());
        this.getCommand("gear").setTabCompleter(new GearTabCompleter());

        // Register eventListeners
        this.getServer().getPluginManager().registerEvents(new EventExperienceGain(), this);
        this.getServer().getPluginManager().registerEvents(new EventLoadData(), this);
        this.getServer().getPluginManager().registerEvents(new EventGearObtaining(), this);
        this.getServer().getPluginManager().registerEvents(new EventFirstGear(), this);
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
