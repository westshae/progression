package cc.altoya.settlements;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import cc.altoya.settlements.Alliance.AllianceTabCompleter;
import cc.altoya.settlements.Alliance.MainAlliance;


public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        initializeConfig();

        // Register commands
        this.getCommand("alliance").setExecutor(new MainAlliance());

        //Register tab completers
        this.getCommand("alliance").setTabCompleter(new AllianceTabCompleter());
    }

    private void initializeConfig() {
        File configFile = new File(getDataFolder(), "config.yml");

        if (!configFile.exists()) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }
}
