package es.hulk.coins.menus;

import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.Utils;
import es.hulk.coins.utils.aquacore.CoinsUtils;
import es.hulk.coins.utils.aquacore.PlayerUtils;
import es.hulk.coins.utils.aquacore.RankUtils;
import es.hulk.coins.utils.menu.Button;
import es.hulk.coins.utils.menu.Menu;
import es.hulk.coins.utils.menu.buttons.BackButton;
import me.activated.core.utilities.chat.CC;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankUpgradeMenu extends Menu {


    @Override
    public String getTitle(Player player) {
        return "Rank Upgrades";
    }

    @Override
    public int getSize() {
        return 27;
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        buttons.put(11, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.PAPER).name("&9Etoirir &8» &cBlaze").lore(Arrays.asList("", "&fThis rank upgrade is &cpermanent&7.", "", "&fCost: &2✦250 gems", "", "&7&oSee the advantages of this rank", "&7&oin crowl.club/discord &7-&o ranks channel", "", "&a&lClick to purchase it")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 250) {
                    if (RankUtils.hasRank(player, "Etoirir")) {
                        RankUtils.setPermRank(player, "Blaze");
                        CoinsUtils.removeCoins(player, 250);
                        PlayerUtils.sendMessage(player.getName() + " has bought rank upgrade from Etoirir to Blaze");
                        return;
                    }
                    player.sendMessage(CC.translate("No tienes el rango Etoirir"));
                    return;
                }
                player.sendMessage(Utils.color("You dont have enought coins to buy this."));
            }
        });

        buttons.put(12, new

                Button() {
                    @Override
                    public ItemStack getButtonItem(Player p0) {
                        return new ItemBuilder(Material.PAPER).name("&cBlaze &8» &6Rex").lore(Arrays.asList("", "&fThis rank upgrade is &cpermanent&7.", "", "&fCost: &2✦350 gems", "", "&7&oSee the advantages of this rank", "&7&oin crowl.club/discord &7-&o ranks channel", "", "&a&lClick to purchase it")).build();
                    }

                    @Override
                    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                        if (CoinsUtils.getCoins(player) >= 350) {
                            if (RankUtils.hasRank(player, "Blaze")) {
                                RankUtils.setPermRank(player, "Rex");
                                CoinsUtils.removeCoins(player, 350);
                                PlayerUtils.sendMessage(player.getName() + " has bought rank upgrade from Blaze to Rex");
                                return;
                            }
                            player.sendMessage(CC.translate("No tienes el rango Blaze"));
                            return;
                        }
                        player.sendMessage(Utils.color("You dont have enought coins to buy this."));
                    }
                });

        buttons.put(14, new

                Button() {
                    @Override
                    public ItemStack getButtonItem(Player p0) {
                        return new ItemBuilder(Material.PAPER).name("&6Rex » &4Errier").lore(Arrays.asList("", "&fThis rank upgrade is &cpermanent&7.", "", "&fCost: &2✦620 gems", "", "&7&oSee the advantages of this rank", "&7&oin crowl.club/discord &7-&o ranks channel", "", "&a&lClick to purchase it")).build();
                    }

                    @Override
                    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                        if (CoinsUtils.getCoins(player) >= 620) {
                            if (RankUtils.hasRank(player, "Rex")) {
                                RankUtils.setPermRank(player, "Errier");
                                CoinsUtils.removeCoins(player, 250);
                                PlayerUtils.sendMessage(player.getName() + " has bought rank upgrade from Rex to Errier");
                                return;
                            }
                            player.sendMessage(CC.translate("No tienes el rango Etoirir"));
                            return;
                        }
                        player.sendMessage(Utils.color("You dont have enought coins to buy this."));
                    }
                });

        buttons.put(15, new

                Button() {
                    @Override
                    public ItemStack getButtonItem(Player p0) {
                        return new ItemBuilder(Material.PAPER).name("&4Errier &8» &bCrowl").lore(Arrays.asList("", "&fThis rank upgrade is &cpermanent&7.", "", "&fCost: &2✦850 gems", "", "&7&oSee the advantages of this rank", "&7&oin crowl.club/discord &7-&o ranks channel", "", "&a&lClick to purchase it")).build();
                    }

                    @Override
                    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                        if (CoinsUtils.getCoins(player) >= 850) {
                            if (RankUtils.hasRank(player, "Errier")) {
                                RankUtils.setPermRank(player, "Crowl");
                                CoinsUtils.removeCoins(player, 850);
                                PlayerUtils.sendMessage(player.getName() + " has bought rank upgrade from Errier to Crowl");
                                return;
                            }
                            player.sendMessage(CC.translate("No tienes el rango Etoirir"));
                            return;
                        }
                        player.sendMessage(Utils.color("You dont have enought coins to buy this."));
                    }
                });

        buttons.put(22, new BackButton(new CoinsMenu()));

        return buttons;
    }
}
