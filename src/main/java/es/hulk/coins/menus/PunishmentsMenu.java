package es.hulk.coins.menus;

import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.Utils;
import es.hulk.coins.utils.aquacore.PunishmentsUtils;
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
                if (PunishmentsUtils.isBanned(player)) {
                    PunishmentsUtils.setUnBan(player);
                    player.sendMessage(Utils.color("&aYou have been unbanned from the network!"));
                    return;
                }
                player.sendMessage(Utils.color("&cYou are already unbanned!"));
            }
        });

        buttons.put(15, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.WATER_BUCKET).name("&c&lNetwork Unmute").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (PunishmentsUtils.isMuted(player)) {
                    PunishmentsUtils.setUnMute(player);
                    player.sendMessage(Utils.color("&aYou have been unmuted from the network!"));
                    return;
                }
                player.sendMessage(Utils.color("&cYou are already unmuted!"));
            }
        });
        return buttons;
    }
}