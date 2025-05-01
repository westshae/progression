package cc.altoya.techtree.Gear;

import java.util.stream.Stream;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import cc.altoya.techtree.Gear.Levels.*;
import net.kyori.adventure.text.Component;

public class GuiUtil {
  public static void viewArmour1Gui(Player player) {
    Inventory gui = Bukkit.createInventory(player, 54, Component.text("Armour #1 Progression GUI"));

    ItemStack[] guiItems = Stream.of(
      ArmourLevelUtil.getArmourViaLevel(1),
      ArmourLevelUtil.getArmourViaLevel(2),
      ArmourLevelUtil.getArmourViaLevel(3),
      ArmourLevelUtil.getArmourViaLevel(4),
      ArmourLevelUtil.getArmourViaLevel(5),
      ArmourLevelUtil.getArmourViaLevel(6),
      ArmourLevelUtil.getArmourViaLevel(7),
      ArmourLevelUtil.getArmourViaLevel(8),
      ArmourLevelUtil.getArmourViaLevel(9),
      ArmourLevelUtil.getArmourViaLevel(10),
      ArmourLevelUtil.getArmourViaLevel(11),
      ArmourLevelUtil.getArmourViaLevel(12),
      ArmourLevelUtil.getArmourViaLevel(13)
      ).flatMap(items -> Stream.of(items)) 
      .toArray(ItemStack[]::new);
      
    addItemsToGui(gui, guiItems);
    player.openInventory(gui);
  }
  public static void viewArmour2Gui(Player player) {
    Inventory gui = Bukkit.createInventory(player, 54, Component.text("Armour #2 Progression GUI"));

    ItemStack[] guiItems = Stream.of(
      ArmourLevelUtil.getArmourViaLevel(14),
      ArmourLevelUtil.getArmourViaLevel(15),
      ArmourLevelUtil.getArmourViaLevel(16),
      ArmourLevelUtil.getArmourViaLevel(17),
      ArmourLevelUtil.getArmourViaLevel(18),
      ArmourLevelUtil.getArmourViaLevel(19),
      ArmourLevelUtil.getArmourViaLevel(20),
      ArmourLevelUtil.getArmourViaLevel(21),
      ArmourLevelUtil.getArmourViaLevel(22),
      ArmourLevelUtil.getArmourViaLevel(23),
      ArmourLevelUtil.getArmourViaLevel(24),
      ArmourLevelUtil.getArmourViaLevel(25),
      ArmourLevelUtil.getArmourViaLevel(26),

      ArmourLevelUtil.getArmourViaLevel(27),
      ArmourLevelUtil.getArmourViaLevel(28),
      ArmourLevelUtil.getArmourViaLevel(29)
      ).flatMap(items -> Stream.of(items)) 
      .toArray(ItemStack[]::new);
      
    addItemsToGui(gui, guiItems);
    player.openInventory(gui);
  }

  public static void viewArmour3Gui(Player player) {
    Inventory gui = Bukkit.createInventory(player, 9, Component.text("Armour #3 Progression GUI"));

    ItemStack[] guiItems = Stream.of(
      ArmourLevelUtil.getArmourViaLevel(27),
      ArmourLevelUtil.getArmourViaLevel(28),
      ArmourLevelUtil.getArmourViaLevel(29)
      ).flatMap(items -> Stream.of(items)) 
      .toArray(ItemStack[]::new);
      
    addItemsToGui(gui, guiItems);
    player.openInventory(gui);
  }

  public static void viewPickaxeGui(Player player) {
    Inventory gui = Bukkit.createInventory(player, 18, Component.text("Pickaxe Progression GUI"));

    ItemStack[] guiItems = {
      PickaxeLevelUtil.getPickaxeViaLevel(1),
      PickaxeLevelUtil.getPickaxeViaLevel(2),
      PickaxeLevelUtil.getPickaxeViaLevel(3),
      PickaxeLevelUtil.getPickaxeViaLevel(4),
      PickaxeLevelUtil.getPickaxeViaLevel(5),
      PickaxeLevelUtil.getPickaxeViaLevel(6),
      PickaxeLevelUtil.getPickaxeViaLevel(7),
      PickaxeLevelUtil.getPickaxeViaLevel(8),
      PickaxeLevelUtil.getPickaxeViaLevel(9),
      PickaxeLevelUtil.getPickaxeViaLevel(10),
      PickaxeLevelUtil.getPickaxeViaLevel(11),
      PickaxeLevelUtil.getPickaxeViaLevel(12),
      PickaxeLevelUtil.getPickaxeViaLevel(13),
      PickaxeLevelUtil.getPickaxeViaLevel(14)
    };

    addItemsToGui(gui, guiItems);
    player.openInventory(gui);
  }

  public static void viewFishingGui(Player player) {
    Inventory gui = Bukkit.createInventory(player, 9, Component.text("Fishing Progression GUI"));

    ItemStack[] guiItems = {
      FishingLevelUtil.getFishingViaLevel(1),
      FishingLevelUtil.getFishingViaLevel(2),
      FishingLevelUtil.getFishingViaLevel(3),
      FishingLevelUtil.getFishingViaLevel(4),
      FishingLevelUtil.getFishingViaLevel(5),
      FishingLevelUtil.getFishingViaLevel(6),
      FishingLevelUtil.getFishingViaLevel(7)
    };

    addItemsToGui(gui, guiItems);
    player.openInventory(gui);
  }

  public static void viewAxeGui(Player player) {
  Inventory gui = Bukkit.createInventory(player, 18, Component.text("Axe Progression GUI"));

  ItemStack[] guiItems = {
    AxeLevelUtil.getAxeViaLevel(1),
    AxeLevelUtil.getAxeViaLevel(2), 
    AxeLevelUtil.getAxeViaLevel(3),
    AxeLevelUtil.getAxeViaLevel(4),
    AxeLevelUtil.getAxeViaLevel(5),
    AxeLevelUtil.getAxeViaLevel(6),
    AxeLevelUtil.getAxeViaLevel(7),
    AxeLevelUtil.getAxeViaLevel(8),
    AxeLevelUtil.getAxeViaLevel(9),
    AxeLevelUtil.getAxeViaLevel(10),
    AxeLevelUtil.getAxeViaLevel(11),
    AxeLevelUtil.getAxeViaLevel(12),
    AxeLevelUtil.getAxeViaLevel(13),
    AxeLevelUtil.getAxeViaLevel(14)
  };

  addItemsToGui(gui, guiItems);
  player.openInventory(gui);
  }


  public static void viewMeleeGui(Player player) {
    Inventory gui = Bukkit.createInventory(player, 18, Component.text("Melee Progression GUI"));

    ItemStack[] guiItems = {
      MeleeLevelUtil.getMeleeViaLevel(1),
      MeleeLevelUtil.getMeleeViaLevel(2),
      MeleeLevelUtil.getMeleeViaLevel(3),
      MeleeLevelUtil.getMeleeViaLevel(4),
      MeleeLevelUtil.getMeleeViaLevel(5),
      MeleeLevelUtil.getMeleeViaLevel(6),
      MeleeLevelUtil.getMeleeViaLevel(7),
      MeleeLevelUtil.getMeleeViaLevel(8),
      MeleeLevelUtil.getMeleeViaLevel(9),
      MeleeLevelUtil.getMeleeViaLevel(10),
      MeleeLevelUtil.getMeleeViaLevel(11),
      MeleeLevelUtil.getMeleeViaLevel(12),
      MeleeLevelUtil.getMeleeViaLevel(13),
      MeleeLevelUtil.getMeleeViaLevel(14),
      MeleeLevelUtil.getMeleeViaLevel(15),
      MeleeLevelUtil.getMeleeViaLevel(16),
      MeleeLevelUtil.getMeleeViaLevel(17),
      MeleeLevelUtil.getMeleeViaLevel(18)
    };

    addItemsToGui(gui, guiItems);
    player.openInventory(gui);
  }

  public static void viewRangedGui(Player player) {
    Inventory gui = Bukkit.createInventory(player, 18, Component.text("Ranged Progression GUI"));

    ItemStack[] guiItems = {
      RangedLevelUtil.getRangedViaLevel(1),
      RangedLevelUtil.getRangedViaLevel(2),
      RangedLevelUtil.getRangedViaLevel(3),
      RangedLevelUtil.getRangedViaLevel(4),
      RangedLevelUtil.getRangedViaLevel(5),
      RangedLevelUtil.getRangedViaLevel(6),
      RangedLevelUtil.getRangedViaLevel(7),
      RangedLevelUtil.getRangedViaLevel(8),
      RangedLevelUtil.getRangedViaLevel(9),
      RangedLevelUtil.getRangedViaLevel(10),
      RangedLevelUtil.getRangedViaLevel(11),
      RangedLevelUtil.getRangedViaLevel(12),
      RangedLevelUtil.getRangedViaLevel(13),
      RangedLevelUtil.getRangedViaLevel(14),
      RangedLevelUtil.getRangedViaLevel(15)

    };

    addItemsToGui(gui, guiItems);
    player.openInventory(gui);
  }

  public static void viewShovelGui(Player player) {
    Inventory gui = Bukkit.createInventory(player, 18, Component.text("Shovel Progression GUI"));

    ItemStack[] guiItems = {
      ShovelLevelUtil.getShovelViaLevel(1),
      ShovelLevelUtil.getShovelViaLevel(2),
      ShovelLevelUtil.getShovelViaLevel(3),
      ShovelLevelUtil.getShovelViaLevel(4),
      ShovelLevelUtil.getShovelViaLevel(5),
      ShovelLevelUtil.getShovelViaLevel(6),
      ShovelLevelUtil.getShovelViaLevel(7),
      ShovelLevelUtil.getShovelViaLevel(8),
      ShovelLevelUtil.getShovelViaLevel(9),
      ShovelLevelUtil.getShovelViaLevel(10),
      ShovelLevelUtil.getShovelViaLevel(11),
      ShovelLevelUtil.getShovelViaLevel(12),
      ShovelLevelUtil.getShovelViaLevel(13),
      ShovelLevelUtil.getShovelViaLevel(14)
    };

    addItemsToGui(gui, guiItems);
    player.openInventory(gui);
  }

  public static void viewHoeGui(Player player) {
    Inventory gui = Bukkit.createInventory(player, 18, Component.text("Hoe Progression GUI"));

    ItemStack[] guiItems = {
      HoeLevelUtil.getHoeViaLevel(1),
      HoeLevelUtil.getHoeViaLevel(2),
      HoeLevelUtil.getHoeViaLevel(3),
      HoeLevelUtil.getHoeViaLevel(4),
      HoeLevelUtil.getHoeViaLevel(5),
      HoeLevelUtil.getHoeViaLevel(6),
      HoeLevelUtil.getHoeViaLevel(7),
      HoeLevelUtil.getHoeViaLevel(8),
      HoeLevelUtil.getHoeViaLevel(9),
      HoeLevelUtil.getHoeViaLevel(10),
      HoeLevelUtil.getHoeViaLevel(11),
      HoeLevelUtil.getHoeViaLevel(12),
      HoeLevelUtil.getHoeViaLevel(13),
      HoeLevelUtil.getHoeViaLevel(14)
    };

    addItemsToGui(gui, guiItems);
    player.openInventory(gui);
  }

  private static void addItemsToGui(Inventory gui, ItemStack[] items) {
    for (ItemStack item : items) {
      if (item != null) {
        gui.addItem(item.clone());
      }
    }
  }
}
