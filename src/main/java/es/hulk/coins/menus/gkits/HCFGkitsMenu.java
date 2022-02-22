package es.hulk.coins.menus.gkits;

import es.hulk.coins.utils.menu.Button;
import es.hulk.coins.utils.menu.Menu;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hulk
 * at 22/02/2022 15:24
 * Project: Coins
 * Class: HCFGkitsMenu
 */

public class HCFGkitsMenu extends Menu {

    @Override
    public String getTitle(Player player) {
        return "HCF Gkits";
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
