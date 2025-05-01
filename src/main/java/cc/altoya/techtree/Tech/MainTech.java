package cc.altoya.techtree.Tech;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cc.altoya.techtree.App;
import cc.altoya.techtree.Util.ChatUtil;

public class MainTech implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!command.getName().equalsIgnoreCase("tech")) {
            return true;
        }
        if (!(sender instanceof Player)) {
            return true;
        }

        if (args.length == 0) {
            ChatUtil.sendErrorMessage((Player) sender, "Requires more arguments. Use /tech help");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "help":
                return CommandHelp.handle((Player) sender, args);
        }

        return true;
    }

    public static void handleInitialize(App plugin) {
      //Active events
      plugin.getServer().getPluginManager().registerEvents(new EventBreakStone(), plugin);

      //Register commands
      plugin.getCommand("tech").setExecutor(new MainTech());

      //Register tab completers
      plugin.getCommand("tech").setTabCompleter(new TechTabCompleter());

      DBTech.initialize();
      SingletonTechTree.initialize();
      plugin.getLogger().info("TechTree initialized");
    }

    public static void handleDisable(App plugin) {
      SingletonTechTree.saveAndCleanup();
      plugin.getLogger().info("TechTree saved and cleaned up");
    }

}
