package es.hulk.coins.menus.rank;

import es.hulk.coins.menus.CoinsMenu;
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

import java.util.HashMap;
import java.util.Map;

public class TempRankMenu extends Menu {

    @Override
    public String getTitle(Player player) {
        return "Temporal Ranks";
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
                return new ItemBuilder(Material.PAPER).name("&bEtoirir").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    if (RankUtils.hasRank(player, "Etoirir")) {
                        RankUtils.setTempRank(player, "Etoirir");
                        CoinsUtils.removeCoins(player, 2000);
                        return;
                    }
                    player.sendMessage(Utils.color("&cYou have the same or higher rank!"));
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(12, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.PAPER).name("&bBlaze").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    if (RankUtils.hasRank(player, "Blaze")) {
                        RankUtils.setTempRank(player, "Blaze");
                        CoinsUtils.removeCoins(player, 2000);
                        return;
                    }
                    player.sendMessage(Utils.color("&cYou have the same or higher rank!"));
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(13, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.PAPER).name("&bRex").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    if (RankUtils.hasRank(player, "Rex")) {
                        RankUtils.setTempRank(player, "Rex");
                        CoinsUtils.removeCoins(player, 2000);
                        return;
                    }
                    player.sendMessage(Utils.color("&cYou have the same or higher rank!"));
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(14, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.PAPER).name("&bErrier").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    if (RankUtils.hasRank(player, "Errier")) {
                        RankUtils.setTempRank(player, "Errier");
                        CoinsUtils.removeCoins(player, 2000);
                        return;
                    }
                    player.sendMessage(Utils.color("&cYou have the same or higher rank!"));
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(15, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.PAPER).name("&bCrowl").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    if (RankUtils.hasRank(player, "Crowl")) {
                        RankUtils.setTempRank(player, "Crowl");
                        CoinsUtils.removeCoins(player, 2000);
                        return;
                    }
                    player.sendMessage(Utils.color("&cYou have the same or higher rank!"));
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(22, new BackButton(new CoinsMenu()));

        return buttons;
    }
}
