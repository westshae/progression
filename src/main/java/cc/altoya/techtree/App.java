package cc.altoya.techtree;

import org.bukkit.plugin.java.JavaPlugin;

import cc.altoya.techtree.Tech.MainTech;


public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        MainTech.handleInitialize(this);
    }

    @Override
    public void onDisable() {
        MainTech.handleDisable(this);
    }
}
