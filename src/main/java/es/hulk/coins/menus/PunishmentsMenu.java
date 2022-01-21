package es.hulk.coins.menus;

import es.hulk.coins.utils.AquaCoreUtils;
import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.menu.Button;
import es.hulk.coins.utils.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class PunishmentsMenu extends Menu {

    @Override
    public String getTitle(Player player) {
        return "Punishments";
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
                return new ItemBuilder(Material.LAVA_BUCKET).name("&c&lNetwork Unban").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                AquaCoreUtils.setUnMute(player);
            }
        });

        buttons.put(15, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.WATER_BUCKET).name("&c&lNetwork Unmute").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                AquaCoreUtils.setUnBan(player);
            }
        });
        return buttons;
    }
}