package es.hulk.coins.menus;

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
                return new ItemBuilder(Material.PAPER).name("Etoirir » Blaze").lore(Arrays.asList("", "", "")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 10) {
                    RankUtils.setPermRank(player, "Blaze");
                    CoinsUtils.removeCoins(player, 10);
                    return;
                }
                player.sendMessage(Utils.color("You dont have enought coins to buy this."));
            }
        });

        buttons.put(12, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.PAPER).name("Blaze » Rex").lore(Arrays.asList("", "", "")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 10) {
                    RankUtils.setPermRank(player, "Rex");
                    CoinsUtils.removeCoins(player, 10);
                    return;
                }
                player.sendMessage(Utils.color("You dont have enought coins to buy this."));
            }
        });

        buttons.put(14, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.PAPER).name("Rex » Errier").lore(Arrays.asList("", "", "")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 10) {
                    RankUtils.setPermRank(player, "Errier");
                    CoinsUtils.removeCoins(player, 10);
                    return;
                }
                player.sendMessage(Utils.color("You dont have enought coins to buy this."));
            }
        });

        buttons.put(15, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.PAPER).name("Errier » Crowl").lore(Arrays.asList("", "", "")).build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 10) {
                    RankUtils.setPermRank(player, "Crowl");
                    CoinsUtils.removeCoins(player, 10);
                    return;
                }
                player.sendMessage(Utils.color("You dont have enought coins to buy this."));
            }
        });

        buttons.put(22, new BackButton(new CoinsMenu()));

        return buttons;
    }
}
