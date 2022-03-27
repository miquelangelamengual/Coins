package es.hulk.coins;

import es.hulk.coins.listener.CoinsListener;
import es.hulk.coins.menus.CoinsMenu;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 05/03/2022 10:11
 * Project: Coins
 * Class: CoinsAPI
 */

public class CoinsAPI {

    public static void getItem(Player player) {
        player.getInventory().setItem(Coins.get().getMainConfig().getInt("JOIN_ITEM.SLOT") - 1, CoinsListener.getItem());
    }

    public static void openMenu(Player player) {
        new CoinsMenu().openMenu(player);
    }

}
