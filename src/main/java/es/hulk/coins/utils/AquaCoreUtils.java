package es.hulk.coins.utils;

import me.activated.core.api.player.PlayerData;
import me.activated.core.api.player.PunishData;
import me.activated.core.api.rank.RankData;
import me.activated.core.api.rank.grant.Grant;
import me.activated.core.plugin.AquaCoreAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 20/01/2022
 * Project: Coins
 * Class: AquaCoreUtils
 */

public class AquaCoreUtils {

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

    public static void resetCoins() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
            playerData.setCoins(0);
        }
    }

    public static void setPermRank(Player player, String rank) {
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "setrank " + player.getName() + " " + rank + " perm global Purchased with coins");
    }

    public static void setTempRank(Player player, String rank) {
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "setrank " + player.getName() + " " + rank + " 30d global Purchased with coins");
    }

    public static void rank(Player player, String rank) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        playerData.getHighestGrant().setRankName(rank);
    }

    public static void setUnMute(Player player) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        PunishData punishData = playerData.getPunishData();
        punishData.getActiveMute().delete();
    }

    public static void setUnBan(Player player) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        PunishData punishData = playerData.getPunishData();
        punishData.getActiveBan().delete();
    }
}
