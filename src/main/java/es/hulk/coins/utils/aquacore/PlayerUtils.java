package es.hulk.coins.utils.aquacore;

import es.hulk.coins.utils.Utils;
import me.activated.core.api.player.GlobalPlayer;
import me.activated.core.plugin.AquaCoreAPI;

import java.util.List;

public class PlayerUtils {

    public static void sendMessage(String message) {
        for (GlobalPlayer player : AquaCoreAPI.INSTANCE.getGlobalPlayers()) {
            player.sendMessage(Utils.color(message));
        }
    }

}
