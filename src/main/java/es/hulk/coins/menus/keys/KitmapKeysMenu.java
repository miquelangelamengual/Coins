package es.hulk.coins.menus.keys;

import club.skilled.slade.SladeAbility;
import club.skilled.slade.api.packages.Package;
import es.hulk.coins.Coins;
import es.hulk.coins.menus.CoinsMenu;
import es.hulk.coins.utils.CrateUtils;
import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.Utils;
import es.hulk.coins.utils.aquacore.CoinsUtils;
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
                return new ItemBuilder(Material.INK_SACK).data(11).name("&e&lReward &7Key").lore(Arrays.asList("", "&fThis Keys belong to &eKitMap", "&fIf you buy it on other sites the coins will be &cremoved&7.", "", "&fQuantity&7: &a32 keys", "&fCost: &6⛃50 coins", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (Coins.get().isCratesEnabled()) {
                    if (CoinsUtils.getCoins(player) >= 50) {
                        Coins.get().getCrates().getCrateManager().giveKeyPlayer("Reward", 32, player);
                        CoinsUtils.removeCoins(player, 50);
                        player.sendMessage(Utils.color("&aYou bought &lx12&a Reward Key"));
                        return;
                    }
                    player.sendMessage(Utils.color("&cYou dont have enough coins."));
                    return;
                }
                player.sendMessage(Utils.color("&4To buy this product you have to join Kitmap and open the shop there"));
            }
        });

        buttons.put(12, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(1).name("&c&lBlaze &7Key").lore(Arrays.asList("", "&fThis Keys belong to &eKitMap", "&fIf you buy it on other sites the coins will be &cremoved&7.", "", "&fQuantity&7: &a18 keys", "&fCost: &6⛃75 coins", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (Coins.get().isCratesEnabled()) {
                    if (CoinsUtils.getCoins(player) >= 75) {
                        Coins.get().getCrates().getCrateManager().giveKeyPlayer("Blaze", 18, player);
                        CoinsUtils.removeCoins(player, 75);
                        player.sendMessage(Utils.color("&aYou bought &lx18&a Blaze Key"));
                        return;
                    }
                    player.sendMessage(Utils.color("&cYou dont have enough coins."));
                    return;
                }
                player.sendMessage(Utils.color("&4To buy this product you have to join Kitmap and open the shop there"));
            }
        });

        buttons.put(13, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(9).name("&d&lMagic &7Key").lore(Arrays.asList("", "&fThis Keys belong to &eKitMap", "&fIf you buy it on other sites the coins will be &cremoved&7.", "", "&fQuantity&7: &a12 keys", "&fCost: &6⛃125 coins", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (Coins.get().isCratesEnabled()) {
                    if (CoinsUtils.getCoins(player) >= 125) {
                        Coins.get().getCrates().getCrateManager().giveKeyPlayer("Magic", 12, player);
                        CoinsUtils.removeCoins(player, 125);
                        player.sendMessage(Utils.color("&aYou bought &lx12&a Magic Key"));
                        return;
                    }
                    player.sendMessage(Utils.color("&cYou dont have enough coins."));
                    return;
                }
                player.sendMessage(Utils.color("&4To buy this product you have to join Kitmap and open the shop there"));
            }
        });

        buttons.put(14, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(12).name("&b&lRoyale &7Key").lore(Arrays.asList("", "&fThis Keys belong to &eKitMap", "&fIf you buy it on other sites the coins will be &cremoved&7.", "", "&fQuantity&7: &a8 keys", "&fCost: &6⛃180 coins", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (Coins.get().isCratesEnabled()) {
                    if (CoinsUtils.getCoins(player) >= 180) {
                        Coins.get().getCrates().getCrateManager().giveKeyPlayer("Royale", 8, player);
                        CoinsUtils.removeCoins(player, 180);
                        player.sendMessage(Utils.color("&aYou bought &lx8&a Royale Key"));
                        return;
                    }
                    player.sendMessage(Utils.color("&cYou dont have enough coins."));
                    return;
                }
                player.sendMessage(Utils.color("&4To buy this product you have to join Kitmap and open the shop there"));
            }
        });

        buttons.put(15, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.GOLD_NUGGET).name("&4&lEvent &7Key").lore(Arrays.asList("", "&fThis Keys belong to &eKitMap", "&fIf you buy it on other sites the coins will be &cremoved&7.", "", "&fQuantity&7: &a8 keys", "&fCost: &6⛃240 coins", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (Coins.get().isCratesEnabled()) {
                    if (CoinsUtils.getCoins(player) >= 240) {
                        Coins.get().getCrates().getCrateManager().giveKeyPlayer("Event", 8, player);
                        CoinsUtils.removeCoins(player, 240);
                        player.sendMessage(Utils.color("&aYou bought &lx8&a Event Key"));
                        return;
                    }
                    player.sendMessage(Utils.color("&cYou dont have enough coins."));
                    return;
                }
                player.sendMessage(Utils.color("&4To buy this product you have to join Kitmap and open the shop there"));
            }
        });

        buttons.put(21, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.ENDER_CHEST).name("&3&lSpecial Box").lore(Arrays.asList("", "&fThis Keys belong to &eKitMap", "&fIf you buy it on other sites the coins will be &cremoved&7.", "", "&fQuantity&7: &a14 keys", "&fCost: &6⛃100 coins", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (Coins.get().isCratesEnabled()) {
                    if (CoinsUtils.getCoins(player) >= 100) {
                        Package pack = SladeAbility.get().getPackageManager().getPackageByName("Special");
                        player.getInventory().addItem(pack.getPackageItem(14));
                        CoinsUtils.removeCoins(player, 100);
                        player.sendMessage(Utils.color("&aYou bought &lx14&a Special Box"));
                        return;
                    }
                    player.sendMessage(Utils.color("&cYou dont have enough coins."));
                    return;
                }
                player.sendMessage(Utils.color("&4To buy this product you have to join Kitmap and open the shop there"));
            }
        });

        buttons.put(22, new BackButton(new CoinsMenu()));

        buttons.put(23, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.BEACON).name("&4Draco Lootchest").lore(Arrays.asList("", "&fThis Keys belong to &eKitMap", "&fIf you buy it on other sites the coins will be &cremoved&7.", "", "&fQuantity&7: &a6 keys", "&fCost: &6⛃320 coins", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (Coins.get().isAdvanced()) {
                    if (CoinsUtils.getCoins(player) >= 320) {
                        CrateUtils.giveAdvancedCrate(player, "Draco", 6);
                        CoinsUtils.removeCoins(player, 320);
                        player.sendMessage(Utils.color("&aYou bought &lx1&a Draco Lootchest"));
                        return;
                    }
                    player.sendMessage(Utils.color("&cYou dont have enough coins."));
                    return;
                }
                player.sendMessage(Utils.color("&4To buy this product you have to join Kitmap and open the shop there"));
            }
        });
        return buttons;
    }
}
