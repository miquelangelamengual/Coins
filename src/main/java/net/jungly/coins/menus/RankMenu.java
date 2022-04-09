package net.jungly.coins.menus;

import net.jungly.coins.menus.coins.CoinsMenuSurvivalOp;
import net.jungly.coins.menus.rank.PermRankMenu;
import net.jungly.coins.menus.rank.TempRankMenu;
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
import java.util.HashMap;
import java.util.Map;

public class RankMenu extends Menu {

    private String server;

    public RankMenu(String server) {
        this.server = server;
    }

    @Override
    public String getTitle(Player player) {
        return "Ranks";
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
                return CustomHeads.create(
                        "&aRangos permanentes",
                        Arrays.asList(
                                "&8&m--------------------------",
                                "&aAquí &fpodrás encontrar los &arangos",
                                "&fque son &apermanentes &fpor lo tanto nunca expiran.",
                                "",
                                " &7➤ &aClick para comprar rangos permanentes",
                                "&8&m--------------------------"
                        ),
                        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODdkNmFlNDc1NTAwN2E4NmZmYjRlN2NhMWViYTU0MGI1NjNkMmYzNjA4ODhjYWIwYTNjNGY0MDVmYzU5ZTFmMyJ9fX0="
                );
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                new PermRankMenu(player, server).openMenu(player);
            }
        });

        buttons.put(15, new Button() {

            @Override
            public ItemStack getButtonItem(Player p0) {
                return CustomHeads.create(
                        "&aRangos temporales",
                        Arrays.asList(
                                "&8&m--------------------------",
                                "&aAquí &fpodrás encontrar los &arangos",
                                "&fque son &apermanentes &flo que quiere decir que",
                                "&aexpirarán &fa los &a30 &fdías.",
                                "",
                                " &7➤ &aClick para comprar rangos temporales",
                                "&8&m--------------------------"
                        ),
                        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTE0MGFlN2EzZThlNjE1NTdkZjNhYzIxZTNlZmQzMWQ1OTE4MzIyY2JiZTIzZDllZDkyMmUyOTFlNDJiNWFmOSJ9fX0="
                );
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                new TempRankMenu(player, server).openMenu(player);
            }
        });

        buttons.put(22, new BackButton(new CoinsMenuSurvivalOp(server)));


        return buttons;
    }
}
