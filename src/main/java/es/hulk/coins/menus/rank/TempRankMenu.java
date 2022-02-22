package es.hulk.coins.menus.rank;

import es.hulk.coins.menus.CoinsMenu;
import es.hulk.coins.utils.ItemBuilder;
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
                RankUtils.setTempRank(player, "Etoirir");
            }
        });

        buttons.put(12, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.PAPER).name("&bBlaze").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                RankUtils.setTempRank(player, "Blaze");
            }
        });

        buttons.put(13, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.PAPER).name("&bRex").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                RankUtils.setTempRank(player, "Rex");
            }
        });

        buttons.put(14, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.PAPER).name("&bErrier").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                RankUtils.setTempRank(player, "Errier");
            }
        });

        buttons.put(15, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return new ItemBuilder(Material.PAPER).name("&bCrowl").build();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                RankUtils.setTempRank(player, "Crowl");
            }
        });

        buttons.put(22, new BackButton(new CoinsMenu()));

        return buttons;
    }
}
