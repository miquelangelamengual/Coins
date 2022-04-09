package net.jungly.coins.menus.coins;

import com.google.common.collect.Maps;
import net.jungly.coins.menus.GamemodeSelectorMenu;
import net.jungly.coins.menus.RankMenu;
import net.jungly.coins.menus.RankUpgradeMenu;
import net.jungly.coins.utils.CustomHeads;
import net.jungly.coins.utils.ItemBuilder;
import net.jungly.coins.utils.menu.Button;
import net.jungly.coins.utils.menu.Menu;
import net.jungly.coins.utils.menu.buttons.BackButton;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Map;

public class CoinsMenuArenaPvP extends Menu {

    private String server;

    public CoinsMenuArenaPvP(String server) {
        this.server = server;
    }

    @Override
    public String getTitle(Player player) {
        return "Jungly Store";
    }

    @Override
    public int size(Map<Integer, Button> buttons) {
        return 9*3;
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = Maps.newHashMap();

        buttons.put(12, new Button() {

            @Override
            public ItemStack getButtonItem(Player p0) {
                return CustomHeads.create(
                        "&aRangos",
                        Arrays.asList(
                                "&8&m--------------------------",
                                "&aAquí &fpodrás encontrar los &arangos",
                                "&ftanto como &apermanentes &fcomo los &atemporales&f.",
                                "",
                                " &7➤ &aClick para comprar rangos",
                                "&8&m--------------------------"
                        ),
                        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjQyODc1ZjQwYjAyYTUyMzQyNjhjNjg0ZWRiOWQ4ZGRjN2VkYTIzOTI5ODRhZGFiZWFhZmEyMzU0NzA4ZGNmNiJ9fX0="
                );
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                new RankMenu(server).openMenu(player);
            }
        });

        buttons.put(14, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return CustomHeads.create(
                        "&aUpgradear rango",
                        Arrays.asList(
                                "&8&m--------------------------",
                                "&aAquí &fpodrás encontrar los &aupgrades",
                                "&fpara mejorar tu &arango &fal que quieras.",
                                "",
                                " &7➤ &aClick para mejorar tu rangos",
                                "&8&m--------------------------"
                        ),
                        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDFkNjk2MDgwNmZhZjc0M2NmYjkwNzYzODQwZjAxZWRkOTg5YzZhNDFiZDQzZGJjYzUxZjNiMWIwOTQ4YTUyZCJ9fX0="
                );
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                new RankUpgradeMenu(player, server).openMenu(player);
            }
        });

        buttons.put(26, new BackButton(new GamemodeSelectorMenu()));

        return buttons;
    }
}
