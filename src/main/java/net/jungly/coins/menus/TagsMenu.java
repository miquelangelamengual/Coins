package net.jungly.coins.menus;

import net.jungly.coins.utils.menu.Button;
import net.jungly.coins.utils.menu.Menu;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

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
