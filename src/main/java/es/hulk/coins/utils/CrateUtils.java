package es.hulk.coins.utils;

import es.hulk.coins.Coins;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 06/03/2022 12:30
 * Project: Coins
 * Class: CrateUtils
 */

public class CrateUtils {

    public static void giveAdvancedCrate(Player player, String crate, int amount) {
        if (Coins.get().isAdvanced()) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ac give " + player.getName() + " " + crate + " " + amount);
        }
    }

}
