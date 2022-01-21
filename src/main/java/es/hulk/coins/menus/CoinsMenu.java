package es.hulk.coins.menus;

import es.hulk.coins.utils.AquaCoreUtils;
import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.menu.Button;
import es.hulk.coins.utils.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hulk
 * at 20/01/2022
 * Project: Coins
 * Class: CoinsMenu
 */

public class CoinsMenu extends Menu {

    @Override
    public String getTitle(Player player) {
        return "Title";
    }

    @Override
    public int size(Map<Integer, Button> buttons) {
        return 27;
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        buttons.put(0, new Button() {

                    @Override
                    public ItemStack getButtonItem(Player p0) {
                        return new ItemBuilder(Material.DIAMOND_SWORD).name("&a&lOwner").lore(Collections.singletonList("&aCost: 1500 coins")).build();
                    }

                    @Override
                    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                        if (AquaCoreUtils.getCoins(player) >= 1500) {
                            AquaCoreUtils.setPermRank(player, "Owner");
                            AquaCoreUtils.removeCoins(player, 1500);
                            player.sendMessage("§aYou have bought the rank §fOwner §afor §f1500 coins");
                        } else {
                            player.sendMessage("§cYou don't have enough coins");
                        }
                    }
                }
        );
        return buttons;
    }
}
