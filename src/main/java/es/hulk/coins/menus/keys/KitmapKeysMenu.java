package es.hulk.coins.menus.keys;

import es.hulk.coins.Coins;
import es.hulk.coins.menus.CoinsMenu;
import es.hulk.coins.utils.ItemBuilder;
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
 * at 22/02/2022 15:24
 * Project: Coins
 * Class: KitmapKeysMenu
 */

public class KitmapKeysMenu extends Menu {

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
                return new ItemBuilder(Material.INK_SACK).data(11).name("&eReward Key").lore(Arrays.asList("This keys belong to kitmap", "If you buy it on other sites the coins will be removed", "Cost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {

            }
        });

        buttons.put(12, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(1).name("&cBlaze Key").lore(Arrays.asList("This keys belong to kitmap", "If you buy it on other sites the coins will be removed", "Cost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {

            }
        });

        buttons.put(13, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(9).name("&eSpecial Key").lore(Arrays.asList("This keys belong to kitmap", "If you buy it on other sites the coins will be removed", "Cost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {

            }
        });

        buttons.put(14, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(12).name("&bRoyale Key").lore(Arrays.asList("This keys belong to kitmap", "If you buy it on other sites the coins will be removed", "Cost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {

            }
        });

        buttons.put(15, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.GOLD_NUGGET).name("&4Event Key").lore(Arrays.asList("This keys belong to kitmap", "If you buy it on other sites the coins will be removed", "Cost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {

            }
        });

        buttons.put(21, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.ENDER_CHEST).name("&5Special Box").lore(Arrays.asList("This keys belong to kitmap", "If you buy it on other sites the coins will be removed", "Cost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {

            }
        });

        buttons.put(22, new BackButton(new CoinsMenu()));

        buttons.put(23, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.BEACON).name("&4Draco Lootchest").lore(Arrays.asList("This keys belong to kitmap", "If you buy it on other sites the coins will be removed", "Cost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {

            }
        });
        return buttons;
    }
}
