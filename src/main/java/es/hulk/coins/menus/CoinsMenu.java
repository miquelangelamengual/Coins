package es.hulk.coins.menus;

import es.hulk.coins.menus.gkits.KitmapGkitsMenu;
import es.hulk.coins.menus.keys.KitmapKeysMenu;
import es.hulk.coins.menus.rank.PermRankMenu;
import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.Utils;
import es.hulk.coins.utils.aquacore.CoinsUtils;
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
                        return new ItemBuilder(Material.ANVIL).name("&aPunishments").build();
                    }

                    @Override
                    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                        new PunishmentsMenu().openMenu(player);
                    }
                }
        );

        buttons.put(3, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.DIAMOND_CHESTPLATE).name("&aKits").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                new KitmapGkitsMenu().openMenu(player);
            }
        });

        buttons.put(5, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.EMERALD).name("&aKeys").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                new KitmapKeysMenu().openMenu(player);
            }
        });

        buttons.put(13, new Button() {

            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.DIAMOND).name("&aRanks").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                new PermRankMenu().openMenu(player);
            }
        });

        buttons.put(21, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.ENDER_PEARL).name("&aRank Upgrades").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                new RankUpgradeMenu().openMenu(player);
            }
        });

        buttons.put(22, new Button() {

            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.NETHER_STAR).name("&aYour Coins").lore(Collections.singletonList("&7You have&a &a⛃" + CoinsUtils.getCoins(player) + " coins")).build();
            }
        });

        buttons.put(23, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.NAME_TAG).name("&bTags").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                player.sendMessage(Utils.color("&4&lUNDER CONSTRUCTION"));
                //new TagsMenu().openMenu(player);
            }
        });

        return buttons;
    }
}
