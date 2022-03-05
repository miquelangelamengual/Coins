package es.hulk.coins.menus;

import es.hulk.coins.utils.menu.Button;
import es.hulk.coins.utils.menu.Menu;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hulk
 * at 05/03/2022 9:45
 * Project: Coins
 * Class: TagsMenu
 */

public class TagsMenu extends Menu {
    @Override
    public String getTitle(Player player) {
        return "Tags";
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
