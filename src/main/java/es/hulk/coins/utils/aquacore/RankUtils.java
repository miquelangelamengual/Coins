package es.hulk.coins.utils.aquacore;

import me.activated.core.api.player.PlayerData;
import me.activated.core.api.rank.grant.Grant;
import me.activated.core.plugin.AquaCoreAPI;
import me.activated.core.values.Permission;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class RankUtils {

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

    public static boolean hasRank(Player player, String rank) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        for (Grant grant : playerData.getGrants()) {
            if (grant.getRankName().equals(rank)) {
                if (grant.isActive()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void givePermission(Player player, String permission) {
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "setperm " + player.getName() + " " + permission + " true");
    }

    public static String getRankName(Player player) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        return playerData.getHighestGrant().getRankName();
    }

}
