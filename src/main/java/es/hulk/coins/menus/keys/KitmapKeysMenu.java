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
                return new ItemBuilder(Material.INK_SACK).data(11).name("&eReward Key").lore(Arrays.asList("&fThis keys belong to kitmap", "&fIf you buy it on other sites the coins will be removed", "&fCost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (Coins.get().isCratesEnabled()) {
                    if (CoinsUtils.getCoins(player) >= 200) {
                        Coins.get().getCrates().getCrateManager().giveKeyPlayer("Reward", 3, player);
                        CoinsUtils.removeCoins(player, 200);
                        player.sendMessage(Utils.color("&aYou bought x3 Reward Key"));
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
                return new ItemBuilder(Material.INK_SACK).data(1).name("&cBlaze Key").lore(Arrays.asList("&fThis keys belong to kitmap", "&fIf you buy it on other sites the coins will be removed", "&fCost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (Coins.get().isCratesEnabled()) {
                    if (CoinsUtils.getCoins(player) >= 200) {
                        Coins.get().getCrates().getCrateManager().giveKeyPlayer("Blaze", 3, player);
                        CoinsUtils.removeCoins(player, 200);
                        player.sendMessage(Utils.color("&aYou bought x3 Blaze Key"));
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
                return new ItemBuilder(Material.INK_SACK).data(9).name("&eSpecial Key").lore(Arrays.asList("&fThis keys belong to kitmap", "&fIf you buy it on other sites the coins will be removed", "&fCost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (Coins.get().isCratesEnabled()) {
                    if (CoinsUtils.getCoins(player) >= 200) {
                        Coins.get().getCrates().getCrateManager().giveKeyPlayer("Special", 3, player);
                        CoinsUtils.removeCoins(player, 200);
                        player.sendMessage(Utils.color("&aYou bought x3 Special Key"));
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
                return new ItemBuilder(Material.INK_SACK).data(12).name("&bRoyale Key").lore(Arrays.asList("&fThis keys belong to kitmap", "&fIf you buy it on other sites the coins will be removed", "&fCost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (Coins.get().isCratesEnabled()) {
                    if (CoinsUtils.getCoins(player) >= 200) {
                        Coins.get().getCrates().getCrateManager().giveKeyPlayer("Royale", 3, player);
                        CoinsUtils.removeCoins(player, 200);
                        player.sendMessage(Utils.color("&aYou bought x3 Royale Key"));
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
                return new ItemBuilder(Material.GOLD_NUGGET).name("&4Event Key").lore(Arrays.asList("&fThis keys belong to kitmap", "&fIf you buy it on other sites the coins will be removed", "&fCost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (Coins.get().isCratesEnabled()) {
                    if (CoinsUtils.getCoins(player) >= 200) {
                        Coins.get().getCrates().getCrateManager().giveKeyPlayer("Event", 3, player);
                        CoinsUtils.removeCoins(player, 200);
                        player.sendMessage(Utils.color("&aYou bought x3 Event Key"));
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
                return new ItemBuilder(Material.ENDER_CHEST).name("&5Special Box").lore(Arrays.asList("&fThis keys belong to kitmap", "&fIf you buy it on other sites the coins will be removed", "&fCost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (Coins.get().isCratesEnabled()) {
                    if (CoinsUtils.getCoins(player) >= 200) {
                        Package pack = SladeAbility.get().getPackageManager().getPackageByName("Special");
                        player.getInventory().addItem(pack.getPackageItem(1));
                        CoinsUtils.removeCoins(player, 200);
                        player.sendMessage(Utils.color("&aYou bought x1 Special Box"));
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
                return new ItemBuilder(Material.BEACON).name("&4Draco Lootchest").lore(Arrays.asList("&fThis keys belong to kitmap", "&fIf you buy it on other sites the coins will be removed", "&fCost: ")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (Coins.get().isAdvanced()) {
                    if (CoinsUtils.getCoins(player) >= 200) {
                        CrateUtils.giveAdvancedCrate(player, "Draco", 1);
                        CoinsUtils.removeCoins(player, 200);
                        player.sendMessage(Utils.color("&aYou bought x1 Draco Lootchest"));
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
