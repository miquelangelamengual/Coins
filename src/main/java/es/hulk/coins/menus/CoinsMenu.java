package es.hulk.coins.menus;

import es.hulk.coins.utils.AquaCoreUtils;
import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.menu.Button;
import es.hulk.coins.utils.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

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
        return "Shop";
    }

    @Override
    public int size(Map<Integer, Button> buttons) {
        return 27;
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        buttons.put(4, new Button() {

                    @Override
                    public ItemStack getButtonItem(Player p0) {
                        return new ItemBuilder(Material.ANVIL).name("&6&lPunishments").build();
                    }

                    @Override
                    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                        new PunishmentsMenu().openMenu(player);
                    }
                }
        );

        buttons.put(13, new Button() {

                    @Override
                    public ItemStack getButtonItem(Player p0) {
                        return new ItemBuilder(Material.DIAMOND).name("&6&lRanks").build();
                    }

                    @Override
                    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                        new RankMenu().openMenu(player);
                    }
                }
        );

        buttons.put(22, new Button() {

            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.NETHER_STAR).name("&6&lYour Coins").lore(Collections.singletonList("&7You have&a &a" + AquaCoreUtils.getCoins(player) + " coins")).build();
            }
        });

        return buttons;
    }
}
