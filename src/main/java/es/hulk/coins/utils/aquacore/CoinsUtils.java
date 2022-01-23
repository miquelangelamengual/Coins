package es.hulk.coins.utils.aquacore;

import me.activated.core.api.player.PlayerData;
import me.activated.core.plugin.AquaCoreAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CoinsUtils {

    public static int getCoins(Player player) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        return playerData.getCoins();
    }

    public static void addCoins(Player player, int coins) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        playerData.addCoins(coins);
    }

    public static void removeCoins(Player player, int coins) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        playerData.removeCoins(coins);
    }

    public static void setCoins(Player player, int coins) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        playerData.setCoins(coins);
    }

    public static void resetCoins(Player player) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        playerData.setCoins(0);
    }

}
