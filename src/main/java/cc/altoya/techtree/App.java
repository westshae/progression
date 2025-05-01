package cc.altoya.techtree;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import cc.altoya.techtree.Experience.EventExperienceGain;
import cc.altoya.techtree.Experience.EventLoadData;
import cc.altoya.techtree.Experience.ExperienceTabCompleter;
import cc.altoya.techtree.Experience.ExperienceUtil;
import cc.altoya.techtree.Experience.MainExperience;
import cc.altoya.techtree.Gear.EventFirstGear;
import cc.altoya.techtree.Gear.EventGearObtaining;
import cc.altoya.techtree.Gear.EventGuiDisableInteraction;
import cc.altoya.techtree.Gear.GearTabCompleter;
import cc.altoya.techtree.Gear.MainGear;

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
        this.getServer().getPluginManager().registerEvents(new EventGuiDisableInteraction(), this);

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
