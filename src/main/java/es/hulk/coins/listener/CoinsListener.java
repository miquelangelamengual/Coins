package es.hulk.coins.listener;

import es.hulk.coins.Coins;
import es.hulk.coins.menus.CoinsMenu;
import es.hulk.coins.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class CoinsListener implements Listener {

    @EventHandler
    public void giveItem(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        new BukkitRunnable() {
            @Override
            public void run() {
                player.getInventory().setItem(4, giveItem());
            }
        }.runTaskLaterAsynchronously(Coins.get(), 20L);
    }

    private ItemStack giveItem() {
        return new ItemBuilder(Material.CHEST).name("&6Coins Shop &7(Right Click)").build();
    }

    @EventHandler
    public void interactEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getItem() == null) return;
        if (event.getItem().getType() == Material.CHEST) {
            new CoinsMenu().openMenu(player);
            event.setCancelled(true);
        }
    }

}
