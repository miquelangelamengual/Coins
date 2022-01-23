package es.hulk.coins.utils.aquacore;

import me.activated.core.api.player.PlayerData;
import me.activated.core.api.player.PunishData;
import me.activated.core.plugin.AquaCoreAPI;
import org.bukkit.entity.Player;

public class PunishmentsUtils {

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

    public static boolean isBanned(Player player) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        PunishData punishData = playerData.getPunishData();
        return punishData.isBanned();
    }

    public static boolean isMuted(Player player) {
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        PunishData punishData = playerData.getPunishData();
        return punishData.isMuted();
    }

}
