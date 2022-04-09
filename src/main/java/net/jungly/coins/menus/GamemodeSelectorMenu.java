package net.jungly.coins.menus;

import com.google.common.collect.Maps;
import net.jungly.coins.Coins;
import net.jungly.coins.menus.coins.CoinsMenuArenaPvP;
import net.jungly.coins.menus.coins.CoinsMenuSurvival;
import net.jungly.coins.menus.coins.CoinsMenuSurvivalOp;
import net.jungly.coins.user.User;
import net.jungly.coins.utils.CustomHeads;
import net.jungly.coins.utils.menu.Button;
import net.jungly.coins.utils.menu.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GamemodeSelectorMenu extends Menu {

    @Override
    public String getTitle(Player player) {
        return "Selecciona la modalidad";
    }

    @Override
    public int size(Map<Integer, Button> buttons) {
        return 9*3;
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        HashMap<Integer, Button> buttons = Maps.newHashMap();

        buttons.put(11, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return CustomHeads.create(
                        "&a&lSurvival 1.18",
                        Arrays.asList(
                                "&8&m--------------------------",
                                "&aClick aquí &fpara entrar a la tienda",
                                "&fde la &amodalidad &fSurvival 1.18",
                                "&8&m--------------------------"
                        ),
                        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjUyY2FlZDM1YTM3MWJhNzI3ZjJhNjE3OWRlY2RiZDFiYjgxMzA1ODRhZGVkOGNhOTFjNTQ5MDBjN2U5ZWUxYyJ9fX0=");

            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                new CoinsMenuSurvival("Survival1").openMenu(player);
            }
        });

        buttons.put(13, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return CustomHeads.create(
                        "&a&lArenaPvP",
                        Arrays.asList(
                                "&8&m--------------------------",
                                "&aClick aquí &fpara entrar a la tienda",
                                "&fde la &amodalidad &fArenaPvP",
                                "&8&m--------------------------"
                        ),
                        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzA1ZWNjYzFmYjc2ZjYwNGY5OTUxZWM4ODk1MzI2NmI3MGMyMDBjZjU3Nzk0OTk0ZGU4ZTVmMWVjYTg2MjY0MCJ9fX0=");
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                new CoinsMenuArenaPvP("ArenaPvP").openMenu(player);
            }
        });

        buttons.put(15, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return CustomHeads.create(
                        "&a&lSurvivalOP",
                        Arrays.asList(
                                "&8&m--------------------------",
                                "&aClick aquí &fpara entrar a la tienda",
                                "&fde la &amodalidad &fSurvivalOP",
                                "&8&m--------------------------"
                        ),
                        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjUyY2FlZDM1YTM3MWJhNzI3ZjJhNjE3OWRlY2RiZDFiYjgxMzA1ODRhZGVkOGNhOTFjNTQ5MDBjN2U5ZWUxYyJ9fX0=");
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                new CoinsMenuSurvivalOp("SurvivalOP").openMenu(player);
            }
        });

        buttons.put(26, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                User user = Coins.get().getUserManager().getUserObjectRepository().find(p0.getUniqueId().toString());
                if (user == null) return null;
                return CustomHeads.create(
                        "&aHojas",
                        Arrays.asList(
                                "&8&m--------------------------",
                                "&fTienes actualmente &a" + user.getCoins() + " &fhojas",
                                "&8&m--------------------------"
                        ),
                        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGVmZjI5ZWE0NzFiMGRiZGIwZjhjZmZlNTIzZmZmZjZhYjAyYTVlZDI5OTBhYmFmMGUyYzYwNGQyMjdmMTA4NCJ9fX0=");
            }
        });

        return buttons;
    }
}
