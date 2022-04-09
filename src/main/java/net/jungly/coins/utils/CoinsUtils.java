package net.jungly.coins.utils;

import net.jungly.coins.Coins;
import net.jungly.coins.user.User;
import net.jungly.coins.user.UserManager;
import org.bukkit.entity.Player;

public class CoinsUtils {

    public static int getCoins(Player player) {
        String id = player.getUniqueId().toString();

        UserManager userManager = Coins.get().getUserManager();
        User user = userManager.getUserObjectRepository().find(id);

        if (user == null) return -1;

        return user.getCoins();
    }

    public static void removeCoins(Player player, int coins) {
        String id = player.getUniqueId().toString();

        UserManager userManager = Coins.get().getUserManager();
        User user = userManager.getUserObjectRepository().find(id);

        user.setCoins(user.getCoins() - coins);

        userManager.getUserObjectRepository().save(user);
    }

    public static void addCoins(Player player, int coins) {
        String id = player.getUniqueId().toString();

        UserManager userManager = Coins.get().getUserManager();
        User user = userManager.getUserObjectRepository().find(id);

        user.setCoins(user.getCoins() + coins);

        userManager.getUserObjectRepository().save(user);
    }

    public static void setCoins(Player player, int coins) {
        String id = player.getUniqueId().toString();

        UserManager userManager = Coins.get().getUserManager();
        User user = userManager.getUserObjectRepository().find(id);

        user.setCoins(coins);

        userManager.getUserObjectRepository().save(user);
    }

    public static void resetCoins(Player player) {
        String id = player.getUniqueId().toString();

        UserManager userManager = Coins.get().getUserManager();
        User user = userManager.getUserObjectRepository().find(id);

        user.setCoins(0);

        userManager.getUserObjectRepository().save(user);
    }
}
