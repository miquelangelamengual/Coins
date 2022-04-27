package es.hulk.coins.menus;

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

public class RankMenu extends Menu {

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
                return new ItemBuilder(Material.INK_SACK).data(4).name("&9&lEtoirir &7Rank").lore(Arrays.asList("", "&fThis rank is &cpermanent&7.", "", "&fCost: &2✦250 gems", "", "&7&oSee the advantages of this rank", "&7&oin crowl.club/discord &7-&o ranks channel", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 250) {
                    RankUtils.setPermRank(player, "Etoirir");
                    CoinsUtils.removeCoins(player, 250);
                    PlayerUtils.sendGlobalMessage(player.getName() + " has bought the rank Etoirir");
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(12, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(1).lore(Arrays.asList("", "&fThis rank is &cpermanent&7.", "", "&fCost: &2✦500 gems", "", "&7&oSee the advantages of this rank", "&7&oin crowl.club/discord &7-&o ranks channel", "", "&a&lClick to purchase it")).name("&c&lBlaze Rank").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 500) {
                    RankUtils.setPermRank(player, "Blaze");
                    CoinsUtils.removeCoins(player, 500);
                    PlayerUtils.sendGlobalMessage(player.getName() + " has bought the rank Blaze");
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(13, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(14).lore(Arrays.asList("", "&fThis rank is &cpermanent&7.", "", "&fCost: &2✦750 gems", "", "&7&oSee the advantages of this rank", "&7&oin crowl.club/discord &7-&o ranks channel", "", "&a&lClick to purchase it")).name("&6&lRex &7Rank").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 750) {
                    RankUtils.setPermRank(player, "Rex");
                    CoinsUtils.removeCoins(player, 750);
                    PlayerUtils.sendGlobalMessage(player.getName() + " has bought the rank Rex");
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(14, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(1).lore(Arrays.asList("", "&fThis rank is &cpermanent&7.", "", "&fCost: &2✦1300 gems", "", "&7&oSee the advantages of this rank", "&7&oin crowl.club/discord &7-&o ranks channel", "", "&a&lClick to purchase it")).name("&4&lErrier &7Rank").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 1300) {
                    RankUtils.setPermRank(player, "Errier");
                    CoinsUtils.removeCoins(player, 1300);
                    PlayerUtils.sendGlobalMessage(player.getName() + " has bought the rank Errier");
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(15, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.INK_SACK).data(12).lore(Arrays.asList("", "&fThis rank is &cpermanent&7.", "", "&fCost: &2✦2000 gems", "", "&7&oSee the advantages of this rank", "&7&oin crowl.club/discord &7-&o ranks channel", "", "&a&lClick to purchase it")).name("&b&lCrowl &7Rank").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 2000) {
                    RankUtils.setPermRank(player, "Crowl");
                    CoinsUtils.removeCoins(player, 2000);
                    PlayerUtils.sendGlobalMessage(player.getName() + " has bought the rank Crowl");
                    return;
                }
                player.sendMessage(Utils.color("&cYou don't have enough coins!"));
            }
        });

        buttons.put(22, new BackButton(new CoinsMenu()));

        return buttons;
    }
}