package es.hulk.coins.menus;

import es.hulk.coins.menus.keys.HCFKeysMenu;
import es.hulk.coins.menus.keys.KitmapKeysMenu;
import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.menu.Button;
import es.hulk.coins.utils.menu.Menu;
import es.hulk.coins.utils.menu.buttons.BackButton;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class KeysMenu extends Menu {

    @Override
    public String getTitle(Player player) {
        return "Keys";
    }

    @Override
    public int size(Map<Integer, Button> buttons) {
        return 27;
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        buttons.put(11, new Button() {

            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(13).name("&b&lKingdoms Keys").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                new KitmapKeysMenu().openMenu(player);
            }
        });

        buttons.put(15, new Button() {

            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(9).name("&b&lKitmap Keys").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                new HCFKeysMenu().openMenu(player);
            }
        });

        buttons.put(22, new BackButton(new CoinsMenu()));
        return buttons;
    }

}
