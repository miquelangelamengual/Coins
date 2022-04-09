package net.jungly.coins.menus;

import net.jungly.coins.utils.menu.Button;
import net.jungly.coins.utils.menu.Menu;
import org.bukkit.entity.Player;

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

        /*buttons.put(11, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.LAVA_BUCKET).name("&c&lNetwork Unban").lore(Arrays.asList("", "&fCost: &6⛃1250 coins", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 1250) {
                    if (PunishmentsUtils.isBanned(player)) {
                        PunishmentsUtils.setUnBan(player);
                        CoinsUtils.removeCoins(player, 1250);
                        player.sendMessage(Utils.color("&aYou have been unbanned from the network!"));
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
                return new ItemBuilder(Material.WATER_BUCKET).name("&c&lNetwork Unmute").lore(Arrays.asList("", "&fCost: &6⛃750 coins", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 750) {
                    if (PunishmentsUtils.isMuted(player)) {
                        PunishmentsUtils.setUnMute(player);
                        CoinsUtils.removeCoins(player, 750);
                        player.sendMessage(Utils.color("&aYou have been unmuted from the network!"));
                        return;
                    }
                    player.sendMessage(Utils.color("&cYou are already unmuted!"));
                } else {
                    player.sendMessage(Utils.color("&cYou don't have enough coins!"));
                }
            }
        });

        buttons.put(22, new BackButton(new CoinsMenu()));*/

        return buttons;
    }
}