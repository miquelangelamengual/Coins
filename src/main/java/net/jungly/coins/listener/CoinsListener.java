package net.jungly.coins.listener;

import net.jungly.coins.Coins;
import net.jungly.coins.menus.GamemodeSelectorMenu;
import net.jungly.coins.user.User;
import net.jungly.coins.user.UserManager;
import net.jungly.coins.utils.ItemBuilder;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class CoinsListener implements Listener {

    @Getter
    private static ItemStack item;

    private final UserManager userManager;

    public CoinsListener() {
        item = new ItemBuilder(Material.getMaterial(Coins.get().getMainConfig().getString("JOIN_ITEM.MATERIAL")))
                .data(Coins.get().getMainConfig().getInt("JOIN_ITEM.DATA"))
                .lore(Coins.get().getMainConfig().getStringList("JOIN_ITEM.LORE"))
                .amount(Coins.get().getMainConfig().getInt("JOIN_ITEM.AMOUNT"))
                .name(Coins.get().getMainConfig().getString("JOIN_ITEM.DISPLAYNAME")).build();

        userManager = Coins.get().getUserManager();
    }

    @EventHandler
    public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
        String id = event.getUniqueId().toString();
        User user = userManager.getUserObjectRepository().find(id);

        if (user == null) {
            user = new User(id);
        }

        userManager.getUserObjectRepository().save(user);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (Coins.get().getMainConfig().getBoolean("GIVE_JOIN_ITEM")) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.getInventory().setItem(Coins.get().getMainConfig().getInt("JOIN_ITEM.SLOT") - 1, item);
                }
            }.runTaskLaterAsynchronously(Coins.get(), 5L);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getItemInHand().isSimilar(item)) {
                new GamemodeSelectorMenu().openMenu(player);
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String id = event.getPlayer().getUniqueId().toString();
        User user = userManager.getUserObjectRepository().find(id);

        Bukkit.getScheduler().runTaskAsynchronously(Coins.get(), () ->
                userManager.getUserObjectRepository().save(user));
    }

}
