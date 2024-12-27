package cc.altoya.progression.Gear;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

import cc.altoya.progression.Util.ChatUtil;

public class EventGearObtaining implements Listener {
  @EventHandler
  public void onPickup(EntityPickupItemEvent event) {
    LivingEntity entity = event.getEntity();
    ItemStack item = event.getItem().getItemStack();
    if (entity instanceof Player && isDisabledItem(item)) {
      event.setCancelled(true);
      ChatUtil.sendErrorMessage((Player) entity, "Picking up tools & gear is disabled.");
    }
  }

  @EventHandler
  public void onCraft(PrepareItemCraftEvent event) {
    CraftingInventory inventory = event.getInventory();
    ItemStack result = inventory.getResult();
    if (result != null && isDisabledItem(result)) {
      inventory.setResult(new ItemStack(Material.AIR)); // Cancel the crafting result
      ChatUtil.sendErrorMessage((Player) event.getView().getPlayer(), "Crafting tools & gear is disabled.");
    }
  }

  @EventHandler
  public void onDrop(PlayerDropItemEvent event) {
    ItemStack item = event.getItemDrop().getItemStack();
    if (isDisabledItem(item)) {
      event.setCancelled(true);
      ChatUtil.sendErrorMessage((Player) event.getPlayer(), "Dropping tools & gear is disabled.");
    }
  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    if (event.getClickedInventory() != null && !event.getClickedInventory().getType().name().equals("PLAYER")) {
      ItemStack item = event.getCurrentItem();
      if (item != null && isDisabledItem(item)) {
        event.setCancelled(true);
        ChatUtil.sendErrorMessage((Player) event.getView().getPlayer(), "Collecting tools & gear is disabled.");
      }
    }
  }

  @EventHandler
  public void onInventoryMoveItem(InventoryMoveItemEvent event) {
    ItemStack item = event.getItem();
    if (isDisabledItem(item)) {
      event.setCancelled(true);
      ChatUtil.sendErrorMessage((Player) event.getInitiator().getHolder(), "Collecting tools & gear is disabled.");
    }
  }

  // Disable enchanting via enchantment tables
  @EventHandler
  public void onEnchantItem(EnchantItemEvent event) {
    ItemStack item = event.getItem();
    if (isDisabledItem(item)) {
      event.setCancelled(true);
      ChatUtil.sendErrorMessage((Player) event.getEnchanter(), "Enchanting disabled items is not allowed.");
    }
  }

  // Disable enchanting via anvils
  @EventHandler
  public void onPrepareAnvil(PrepareAnvilEvent event) {
    ItemStack item = event.getResult();
    if (item != null && isDisabledItem(item)) {
      event.setResult(null); // Cancel the anvil result
      ChatUtil.sendErrorMessage((Player) event.getView().getPlayer(), "Enchanting disabled items is not allowed.");
    }
  }

  private boolean isDisabledItem(ItemStack item) {
    if (item == null || item.getType() == Material.AIR) {
      return false;
    }

    switch (item.getType()) {
      case WOODEN_PICKAXE:
      case STONE_PICKAXE:
      case IRON_PICKAXE:
      case GOLDEN_PICKAXE:
      case DIAMOND_PICKAXE:
      case NETHERITE_PICKAXE:
      case WOODEN_AXE:
      case STONE_AXE:
      case IRON_AXE:
      case GOLDEN_AXE:
      case DIAMOND_AXE:
      case NETHERITE_AXE:
      case WOODEN_SHOVEL:
      case STONE_SHOVEL:
      case IRON_SHOVEL:
      case GOLDEN_SHOVEL:
      case DIAMOND_SHOVEL:
      case NETHERITE_SHOVEL:
      case WOODEN_HOE:
      case STONE_HOE:
      case IRON_HOE:
      case GOLDEN_HOE:
      case DIAMOND_HOE:
      case NETHERITE_HOE:
      case WOODEN_SWORD:
      case STONE_SWORD:
      case IRON_SWORD:
      case GOLDEN_SWORD:
      case DIAMOND_SWORD:
      case NETHERITE_SWORD:
      case TRIDENT:
      case CROSSBOW:
      case BOW:
      case FISHING_ROD:
      case LEATHER_HELMET:
      case LEATHER_CHESTPLATE:
      case LEATHER_LEGGINGS:
      case LEATHER_BOOTS:
      case CHAINMAIL_HELMET:
      case CHAINMAIL_CHESTPLATE:
      case CHAINMAIL_LEGGINGS:
      case CHAINMAIL_BOOTS:
      case GOLDEN_HELMET:
      case GOLDEN_CHESTPLATE:
      case GOLDEN_LEGGINGS:
      case GOLDEN_BOOTS:
      case IRON_HELMET:
      case IRON_CHESTPLATE:
      case IRON_LEGGINGS:
      case IRON_BOOTS:
      case DIAMOND_HELMET:
      case DIAMOND_CHESTPLATE:
      case DIAMOND_LEGGINGS:
      case DIAMOND_BOOTS:
      case NETHERITE_HELMET:
      case NETHERITE_CHESTPLATE:
      case NETHERITE_LEGGINGS:
      case NETHERITE_BOOTS:
      case TURTLE_HELMET:
      case ELYTRA:
        return true;
      default:
        return false;
    }
  }

}
