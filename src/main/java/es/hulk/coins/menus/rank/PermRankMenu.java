package es.hulk.coins.menus.rank;

import es.hulk.coins.utils.menu.Button;
import es.hulk.coins.utils.menu.Menu;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PermRankMenu extends Menu {

    @Override
    public String getTitle(Player player) {
        return "Permanent Ranks";
    }

    @Override
    public int size(Map<Integer, Button> buttons) {
        return 27;
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();
        return buttons;
    }
}
