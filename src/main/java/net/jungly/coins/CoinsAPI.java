package net.jungly.coins;

import net.jungly.coins.listener.CoinsListener;
import net.jungly.coins.menus.GamemodeSelectorMenu;
import org.bukkit.entity.Player;

public class CoinsAPI {

    public static void getItem(Player player) {
        player.getInventory().setItem(Coins.get().getMainConfig().getInt("JOIN_ITEM.SLOT") - 1, CoinsListener.getItem());
    }

    public static void openMenu(Player player) {
        new GamemodeSelectorMenu().openMenu(player);
    }

}
