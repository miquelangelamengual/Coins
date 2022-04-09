package net.jungly.coins.placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.jungly.coins.Coins;
import net.jungly.coins.user.User;
import org.bukkit.OfflinePlayer;

public class HojasPlaceholder extends PlaceholderExpansion {

    public String getIdentifier() {
        return "jungly";
    }
    public String getAuthor() {
        return "harpy";
    }

    public String getVersion() {
        return "1.0";
    }

    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        User user = Coins.get().getUserManager().getUserObjectRepository().find(player.getUniqueId().toString());
        if (params.equalsIgnoreCase("hojas")) {
            return user.getCoins() + "";
        }
        return null;
    }
}
