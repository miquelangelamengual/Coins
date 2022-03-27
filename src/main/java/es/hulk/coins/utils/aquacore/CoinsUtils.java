package es.hulk.coins.utils.aquacore;

import me.activated.core.api.player.PlayerData;
import me.activated.core.plugin.AquaCoreAPI;
import org.bukkit.OfflinePlayer;

public class CoinsUtils {

    public static int getCoins(OfflinePlayer player) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        return playerData.getCoins();
    }

    public static void addCoins(OfflinePlayer player, int coins) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        playerData.addCoins(coins);
    }

    public static void removeCoins(OfflinePlayer player, int coins) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        playerData.removeCoins(coins);
    }

    public static void setCoins(OfflinePlayer player, int coins) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        playerData.setCoins(coins);
    }

    public static void resetCoins(OfflinePlayer player) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        playerData.setCoins(0);
    }

}
