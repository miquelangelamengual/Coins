package es.hulk.coins.menus.rank;

import es.hulk.coins.menus.RankMenu;
import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.Utils;
import es.hulk.coins.utils.aquacore.CoinsUtils;
import es.hulk.coins.utils.aquacore.RankUtils;
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

public class PermRankMenu extends Menu {

    @Override
    public String getTitle(Player player) {
        return "Permanent Ranks";
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
                return new ItemBuilder(Material.INK_SACK).data(4).name("&bEtoirir").lore(Arrays.asList("&eThis rank is permanent", "", "&eCost: 250 coins")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    RankUtils.setPermRank(player, "Etoirir");
                    CoinsUtils.removeCoins(player, 2000);
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(12, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(1).lore(Arrays.asList("&eThis rank is permanent", "", "&eCost: 500 coins")).name("&bBlaze").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    RankUtils.setPermRank(player, "Blaze");
                    CoinsUtils.removeCoins(player, 2000);
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(13, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(14).lore(Arrays.asList("&eThis rank is permanent", "", "&eCost: 750 coins")).name("&bRex").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    RankUtils.setPermRank(player, "Rex");
                    CoinsUtils.removeCoins(player, 2000);
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(14, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(1).lore(Arrays.asList("&eThis rank is permanent", "", "&eCost: 1300 coins")).name("&bErrier").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    RankUtils.setPermRank(player, "Errier");
                    CoinsUtils.removeCoins(player, 2000);
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(15, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(12).lore(Arrays.asList("&eThis rank is permanent", "", "&eCost: 2000 coins")).name("&bCrowl").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    RankUtils.setPermRank(player, "Crowl");
                    CoinsUtils.removeCoins(player, 2000);
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(22, new BackButton(new RankMenu()));

        return buttons;
    }
}
