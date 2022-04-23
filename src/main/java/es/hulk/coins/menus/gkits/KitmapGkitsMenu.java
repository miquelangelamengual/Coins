package es.hulk.coins.menus.gkits;

import es.hulk.coins.menus.CoinsMenu;
import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.Utils;
import es.hulk.coins.utils.aquacore.CoinsUtils;
import es.hulk.coins.utils.aquacore.PlayerUtils;
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
                return new ItemBuilder(Material.INK_SACK).data(9).name("&d&lMonthly &7GKit").lore(Arrays.asList("", "&fThis Gkit belong to &eKitMap", "&fIf you buy it on other sites the coins will be &cremoved&7.", "", "&fCost: &2✦500 gems", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 500) {
                    RankUtils.givePermission(player, "gkit.Monthly");
                    CoinsUtils.removeCoins(player, 500);
                    player.sendMessage(Utils.color("&aYou have bought Monthly GKit"));
                    PlayerUtils.sendMessage(player.getName() + " has bought the Monthly GKit");
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(5, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(12).name("&3&lCrowl &7GKit").lore(Arrays.asList("", "&fThis Gkit belong to &eKitMap", "&fIf you buy it on other sites the coins will be &cremoved&7.", "", "&fCost: &2✦500 gems", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 500) {
                    RankUtils.givePermission(player, "gkit.Crowl");
                    CoinsUtils.removeCoins(player, 500);
                    player.sendMessage(Utils.color("&aYou have bought Crowl GKit"));
                    PlayerUtils.sendMessage(player.getName() + " has bought the Crowl GKit");
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(11, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).name("&8&lRogue+ &7GKit").lore(Arrays.asList("", "&fThis Gkit belong to &eKitMap", "&fIf you buy it on other sites the coins will be &cremoved&7.", "", "&fCost: &2✦250 gems", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 250) {
                    RankUtils.givePermission(player, "gkit.Rogue+");
                    CoinsUtils.removeCoins(player, 250);
                    player.sendMessage(Utils.color("&aYou have bought Rogue+ GKit"));
                    PlayerUtils.sendMessage(player.getName() + " has bought the Rogue+ GKit");
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(12, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.DIAMOND_CHESTPLATE).name("&b&lDiamond+ &9&LGKit").lore(Arrays.asList("", "&fThis Gkit belong to &eKitMap", "&fIf you buy it on other sites the coins will be &cremoved&7.", "", "&fCost: &2✦250 gems", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    RankUtils.givePermission(player, "gkit.Diamond+");
                    CoinsUtils.removeCoins(player, 2000);
                    player.sendMessage(Utils.color("&aYou have bought Diamond+ GKit"));
                    PlayerUtils.sendMessage(player.getName() + " has bought the Diamond+ GKit");
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(13, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.DIAMOND_PICKAXE).name("&fKitting GKit").lore(Arrays.asList("", "&fThis Gkit belong to &eKitMap", "&fIf you buy it on other sites the coins will be &cremoved&7.", "", "&fCost: &2✦150 gems", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 150) {
                    RankUtils.givePermission(player, "gkit.Kitting");
                    CoinsUtils.removeCoins(player, 150);
                    player.sendMessage(Utils.color("&aYou have bought Kitting GKit"));
                    PlayerUtils.sendMessage(player.getName() + " has bought the Kitting GKit");
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(14, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.LEATHER_CHESTPLATE).name("&5&lArcher+ &7GKit").lore(Arrays.asList("", "&fThis Gkit belong to &eKitMap", "&fIf you buy it on other sites the coins will be &cremoved&7.", "", "&fCost: &2⛃250 gems", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 250) {
                    RankUtils.givePermission(player, "gkit.Archer+");
                    CoinsUtils.removeCoins(player, 250);
                    player.sendMessage(Utils.color("&aYou have bought Archer+ GKit"));
                    PlayerUtils.sendMessage(player.getName() + " has bought the Archer+ GKit");
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(15, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.GOLD_CHESTPLATE).name("&6&lBard+ &7GKit").lore(Arrays.asList("", "&fThis Gkit belong to &eKitMap", "&fIf you buy it on other sites the coins will be &cremoved&7.", "", "&fCost: &2✦250 gems", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    RankUtils.givePermission(player, "gkit.Bard+");
                    CoinsUtils.removeCoins(player, 2000);
                    player.sendMessage(Utils.color("&aYou have bought Bard+ GKit"));
                    PlayerUtils.sendMessage(player.getName() + " has bought the Bard+ GKit");
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(22, new BackButton(new CoinsMenu()));

        return buttons;
    }
}
