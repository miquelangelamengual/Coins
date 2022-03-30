package es.hulk.coins.utils.aquacore;

import es.hulk.coins.utils.Utils;
import me.activated.core.api.player.GlobalPlayer;
import me.activated.core.plugin.AquaCoreAPI;

public class PlayerUtils {

    public static void sendMessage(String message) {
        GlobalPlayer globalPlayer = (GlobalPlayer) AquaCoreAPI.INSTANCE.getGlobalPlayers();
        globalPlayer.sendMessage(Utils.color(message));
    }

}
