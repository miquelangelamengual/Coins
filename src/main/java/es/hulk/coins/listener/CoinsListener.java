package es.hulk.coins.listener;

import es.hulk.coins.Coins;
import es.hulk.coins.menus.CoinsMenu;
import es.hulk.coins.utils.ItemBuilder;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class CoinsListener implements Listener {

    @Getter
    private static ItemStack item;

    @EventHandler
    public void giveItem(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (Coins.get().getMainConfig().getBoolean("GIVE_JOIN_ITEM")) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.getInventory().setItem(Coins.get().getMainConfig().getInt("JOIN_ITEM.SLOT") - 1, item);
                }
            }.runTaskLaterAsynchronously(Coins.get(), 20L);
        }
    }

    public static void giveItem() {
        item = new ItemBuilder(Material.getMaterial(Coins.get().getMainConfig().getString("JOIN_ITEM.MATERIAL")))
                .data(Coins.get().getMainConfig().getInt("JOIN_ITEM.DATA"))
                .lore(Coins.get().getMainConfig().getStringList("JOIN_ITEM.LORE"))
                .amount(Coins.get().getMainConfig().getInt("JOIN_ITEM.AMOUNT"))
                .name(Coins.get().getMainConfig().getString("JOIN_ITEM.DISPLAYNAME")).build();
    }

    @EventHandler
    public void interactEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getItemInHand().isSimilar(item)) {
                new CoinsMenu().openMenu(player);
                event.setCancelled(true);
            }
        }
    }
}
