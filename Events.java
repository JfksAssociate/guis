package me.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Events implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.AQUA + "GUI test")) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {

                case IRON_BLOCK:
                    Player p = (Player) event.getWhoClicked();
                    Inventory internalGui = Bukkit.createInventory(p, 27, ChatColor.AQUA + "GUI test");
                    ItemStack srv1 = new ItemStack(Material.IRON_BLOCK);
                    ItemStack srv2 = new ItemStack(Material.IRON_BLOCK);
                    ItemStack srv3 = new ItemStack(Material.IRON_BLOCK);
                    ItemStack srv4 = new ItemStack(Material.IRON_BLOCK);
                    ItemStack srv5 = new ItemStack(Material.IRON_BLOCK);

                    ItemMeta srv1_meta = srv1.getItemMeta();
                    srv1_meta.setDisplayName(ChatColor.RED + "Server Networks");
                    srv1.setItemMeta(srv1_meta);

                    ItemMeta srv2_meta = srv1.getItemMeta();
                    srv2_meta.setDisplayName(ChatColor.RED + "Lobby");
                    srv1.setItemMeta(srv2_meta);

                    ItemStack[] menu_items = {srv1, srv2, srv3, srv4, srv5};
                    break;

            }
        }

    }
    @EventHandler
    public void eyeClicked(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand().getType() == Material.ENDER_EYE) {
            Inventory gui = Bukkit.createInventory(p, 27, ChatColor.AQUA + "GUI test");
            ItemStack ironcmd = new ItemStack(Material.IRON_BLOCK);
            ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemStack air = new ItemStack(Material.AIR);


            ItemMeta iron_meta = ironcmd.getItemMeta();
            iron_meta.setDisplayName(ChatColor.RED + "Server Networks");
            ironcmd.setItemMeta(iron_meta);


            ItemStack[] menu_items = {glass, glass, glass, glass, ironcmd};

            for (int i=0; i<26; i++){
                if (gui.getStorageContents() == null) {
                    gui.addItem(new ItemStack(Material.IRON_BLOCK));
                }
            }
            gui.setContents(menu_items);
            p.openInventory(gui);
        }
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInMainHand().getType().equals(Material.ENDER_EYE)) {
                event.setCancelled(true);
            }
        }
    }
}
