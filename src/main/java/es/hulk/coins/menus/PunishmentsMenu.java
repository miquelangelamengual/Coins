package es.hulk.coins.menus;

import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.Utils;
import es.hulk.coins.utils.aquacore.CoinsUtils;
import es.hulk.coins.utils.aquacore.PlayerUtils;
import es.hulk.coins.utils.aquacore.PunishmentsUtils;
import es.hulk.coins.utils.menu.Button;
import es.hulk.coins.utils.menu.Menu;
import es.hulk.coins.utils.menu.buttons.BackButton;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
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
                return new ItemBuilder(Material.LAVA_BUCKET).name("&c&lNetwork Unban").lore(Arrays.asList("", "&fCost: &2✦1250 gems", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 1250) {
                    if (PunishmentsUtils.isBanned(player)) {
                        PunishmentsUtils.setUnBan(player);
                        CoinsUtils.removeCoins(player, 1250);
                        player.sendMessage(Utils.color("&aYou have been unbanned from the network!"));
                        PlayerUtils.sendGlobalMessage(player.getName() + " has bought the network unban");
                        return;
                    }
                    player.sendMessage(Utils.color("&cYou are already unbanned!"));
                } else {
                    player.sendMessage(Utils.color("&cYou don't have enough coins!"));
                }
            }
        });

        buttons.put(15, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.WATER_BUCKET).name("&c&lNetwork Unmute").lore(Arrays.asList("", "&fCost: &2✦750 gems", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 750) {
                    if (PunishmentsUtils.isMuted(player)) {
                        PunishmentsUtils.setUnMute(player);
                        CoinsUtils.removeCoins(player, 750);
                        player.sendMessage(Utils.color("&aYou have been unmuted from the network!"));
                        PlayerUtils.sendGlobalMessage(player.getName() + " has bought the network unmute");
                        return;
                    }
                    player.sendMessage(Utils.color("&cYou are already unmuted!"));
                } else {
                    player.sendMessage(Utils.color("&cYou don't have enough coins!"));
                }
            }
        });

        buttons.put(22, new BackButton(new CoinsMenu()));

        return buttons;
    }
}