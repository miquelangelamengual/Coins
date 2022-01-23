package es.hulk.coins.utils.aquacore;

import me.activated.core.api.player.PlayerData;
import me.activated.core.plugin.AquaCoreAPI;
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

}
