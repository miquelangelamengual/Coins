package es.hulk.coins.menus.gkits;

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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hulk
 * at 22/02/2022 15:23
 * Project: Coins
 * Class: KitmapGkitsMenu
 */

public class KitmapGkitsMenu extends Menu {

    @Override
    public String getTitle(Player player) {
        return "Gkits";
    }

    @Override
    public int size(Map<Integer, Button> buttons) {
        return 27;
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        buttons.put(3, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(9).name("&dMonthly GKit").lore(Arrays.asList("&fThis Gkit belong to kitmap", "&fIf you buy it on other sites the coins will be removed", "&fCost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    RankUtils.givePermission(player, "pandagkit.gkit.Monthly");
                    CoinsUtils.removeCoins(player, 2000);
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(5, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(12).name("&bCrowl GKit").lore(Arrays.asList("&fThis Gkit belong to kitmap", "&fIf you buy it on other sites the coins will be removed", "&fCost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    RankUtils.givePermission(player, "pandagkit.gkit.Crowl");
                    CoinsUtils.removeCoins(player, 2000);
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(11, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).name("&7Rogue+ GKit").lore(Arrays.asList("&fThis Gkit belong to kitmap", "&fIf you buy it on other sites the coins will be removed", "&fCost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    RankUtils.givePermission(player, "pandagkit.gkit.Rogue+");
                    CoinsUtils.removeCoins(player, 2000);
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(12, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.DIAMOND_CHESTPLATE).name("&9Diamond+ GKit").lore(Arrays.asList("&fThis Gkit belong to kitmap", "&fIf you buy it on other sites the coins will be removed", "&fCost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    RankUtils.givePermission(player, "pandagkit.gkit.Diamond+");
                    CoinsUtils.removeCoins(player, 2000);
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(13, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.DIAMOND_PICKAXE).name("&fKitting GKit").lore(Arrays.asList("&fThis Gkit belong to kitmap", "&fIf you buy it on other sites the coins will be removed", "&fCost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    RankUtils.givePermission(player, "pandagkit.gkit.Kitting");
                    CoinsUtils.removeCoins(player, 2000);
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(14, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.LEATHER_CHESTPLATE).name("&5Archer+ GKit").lore(Arrays.asList("&fThis Gkit belong to kitmap", "&fIf you buy it on other sites the coins will be removed", "&fCost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    RankUtils.givePermission(player, "pandagkit.gkit.Archer+");
                    CoinsUtils.removeCoins(player, 2000);
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(15, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.GOLD_CHESTPLATE).name("&6Bard+ GKit").lore(Arrays.asList("&fThis Gkit belong to kitmap", "&fIf you buy it on other sites the coins will be removed", "&fCost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    RankUtils.givePermission(player, "pandagkit.gkit.Bard+");
                    CoinsUtils.removeCoins(player, 2000);
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(22, new BackButton(new CoinsMenu()));

        return buttons;
    }
}
