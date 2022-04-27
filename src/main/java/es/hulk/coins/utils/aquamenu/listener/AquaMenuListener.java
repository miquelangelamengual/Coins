package es.hulk.coins.utils.aquamenu.listener;

import es.hulk.coins.Coins;
import es.hulk.coins.utils.aquamenu.menu.AquaMenu;
import es.hulk.coins.utils.aquamenu.slots.Slot;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;

public class AquaMenuListener implements Listener {

    private final Coins plugin = Coins.getInstance();

    public AquaMenuListener() {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        AquaMenu menu = plugin.getMenuManager().getOpenedMenus().get(player.getUniqueId());

        if (menu == null) return;

        event.setCancelled(true);

        if (event.getSlot() != event.getRawSlot()) return;

        Slot slot = menu.getSlot(event.getSlot());
        if (slot == null) return;

        slot.onClick(player, event.getSlot(), event.getClick());
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();

        AquaMenu menu = plugin.getMenuManager().getOpenedMenus().get(player.getUniqueId());

        if (menu == null) return;

        menu.onClose(player);
        plugin.getMenuManager().getOpenedMenus().remove(player.getUniqueId());
    }
}
