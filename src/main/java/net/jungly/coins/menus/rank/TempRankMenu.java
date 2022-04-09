package net.jungly.coins.menus.rank;

import com.google.common.collect.Maps;
import net.jungly.coins.menus.RankMenu;
import net.jungly.coins.menus.coins.CoinsMenuSurvivalOp;
import net.jungly.coins.utils.*;
import net.jungly.coins.utils.menu.Button;
import net.jungly.coins.utils.menu.Menu;
import net.jungly.coins.utils.menu.buttons.BackButton;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class TempRankMenu extends Menu {


    private String server;

    private Map<Player, String> rangoBaratoSelected = Maps.newHashMap();
    private Map<Player, String> rangoIntermedioSelected = Maps.newHashMap();
    private Map<Player, String> rangoAltoSelected = Maps.newHashMap();

    public TempRankMenu(Player player, String server) {
        this.rangoBaratoSelected.put(player, "Tigre");
        this.rangoIntermedioSelected.put(player, "Aguila");
        this.rangoAltoSelected.put(player, "Camaleon");

        this.server = server;
    }

    @Override
    public String getTitle(Player player) {
        return "Rangos Temporales";
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
                return rangoBaratoItem();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (clickType.isLeftClick()) {
                    for (Map.Entry<Player, String> entry : rangoBaratoSelected.entrySet()) {
                        if (entry.getValue().equalsIgnoreCase("Tigre")) {
                            entry.setValue("Jaguar");
                            player.updateInventory();
                        } else if (entry.getValue().equalsIgnoreCase("Jaguar")) {
                            entry.setValue("Leon");
                            player.updateInventory();
                        } else if (entry.getValue().equalsIgnoreCase("Leon")) {
                            entry.setValue("Tigre");
                            player.updateInventory();
                        }
                    }
                } else if (clickType.isRightClick()) {
                    for (Map.Entry<Player, String> entry : rangoBaratoSelected.entrySet()) {
                        if (CoinsUtils.getCoins(player) >= 5) {
                            RankUtils.setTempRank(player, entry.getValue(), server);
                            CoinsUtils.removeCoins(player, 5);
                            return;
                        }
                        player.sendMessage(Utils.color("&fNo tienes suficientes &ahojas&f!"));
                    }
                }
            }
        });

        buttons.put(12, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return rangoIntermedioItem();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (clickType.isLeftClick()) {
                    for (Map.Entry<Player, String> entry : rangoIntermedioSelected.entrySet()) {
                        if (entry.getValue().equalsIgnoreCase("Aguila")) {
                            entry.setValue("Colibri");
                            player.updateInventory();
                        } else if (entry.getValue().equalsIgnoreCase("Colibri")) {
                            entry.setValue("Tucan");
                            player.updateInventory();
                        } else if (entry.getValue().equalsIgnoreCase("Tucan")) {
                            entry.setValue("Aguila");
                            player.updateInventory();
                        }
                    }
                } else if (clickType.isRightClick()) {
                    for (Map.Entry<Player, String> entry : rangoIntermedioSelected.entrySet()) {
                        if (CoinsUtils.getCoins(player) >= 12) {
                            RankUtils.setTempRank(player, entry.getValue(), server);
                            CoinsUtils.removeCoins(player, 12);
                            return;
                        }
                        player.sendMessage(Utils.color("&fNo tienes suficientes &ahojas&f!"));
                    }
                }
            }
        });

        buttons.put(14, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return rangoAltoItem();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (clickType.isLeftClick()) {
                    for (Map.Entry<Player, String> entry : rangoAltoSelected.entrySet()) {
                        if (entry.getValue().equalsIgnoreCase("Camaleon")) {
                            entry.setValue("Iguana");
                            player.updateInventory();
                        } else if (entry.getValue().equalsIgnoreCase("Iguana")) {
                            entry.setValue("Serpiente");
                            player.updateInventory();
                        } else if (entry.getValue().equalsIgnoreCase("Serpiente")) {
                            entry.setValue("Camaleon");
                            player.updateInventory();
                        }
                    }
                } else if (clickType.isRightClick()) {
                    for (Map.Entry<Player, String> entry : rangoAltoSelected.entrySet()) {
                        if (CoinsUtils.getCoins(player) >= 35) {
                            RankUtils.setTempRank(player, entry.getValue(), server);
                            CoinsUtils.removeCoins(player, 35);
                            return;
                        }
                        player.sendMessage(Utils.color("&fNo tienes suficientes &ahojas&f!"));
                    }
                }
            }
        });

        buttons.put(15, new Button() {
            @Override
            public ItemStack getButtonItem(Player p0) {
                return CustomHeads.create(
                        "&aRango extremo",
                        Arrays.asList(
                                "&7&m-------------------------",
                                "&fEste &arango&f es diferente a los demas",
                                "&fal ser el &arango &fmás &aalto &ftiene únicamente 1 nombre",
                                "&fPara así darle más &aexclusividad&f.",
                                "&7&m-------------------------"
                        ),
                        "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzNjY2I0ZGIyYzE5NjkyODM0M2U2YzFjNzlhMjdkNzM3ZTY1NWQwYzlmOTE2OWI3YTg4ZDE3NDQ1NzE0MTcifX19"
                );
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (CoinsUtils.getCoins(player) >= 50) {
                    RankUtils.setTempRank(player, "Jungle", server);
                    CoinsUtils.removeCoins(player, 50);
                    return;
                }
                player.sendMessage(Utils.color("&fNo tienes suficientes &ahojas&f!"));
            }
        });

        buttons.put(22, new BackButton(new RankMenu(server)));

        return buttons;
    }

    public ItemStack rangoBaratoItem() {

        List<String> lore = new ArrayList<>();
        lore.add("&7&m-------------------------");
        lore.add("&fEn todas las fases de rangos tienes");
        lore.add("&fa elegir entre &c3 &fnombres de tu &crango&f, los cuales");
        lore.add("&fsolo cambia el &cnombre&f, las ventajas son las mismas.");
        lore.add("&f");
        lore.add("&fTipo de rango&7: &cPermanente");
        lore.add("&fPrecio&7: &c5 hojas");
        lore.add(" ");
        lore.add("&fPodrás elegir entre:");
        for (Map.Entry<Player, String> entry : this.rangoBaratoSelected.entrySet()) {
            if (entry.getValue().equalsIgnoreCase("Tigre")) {
                lore.add(" &7- &c&lTigre");
            } else {
                lore.add(" &7- &fTigre");
            }
            if (entry.getValue().equalsIgnoreCase("Jaguar")) {
                lore.add(" &7- &c&lJaguar");
            } else {
                lore.add(" &7- &fJaguar");
            }
            if (entry.getValue().equalsIgnoreCase("Leon")) {
                lore.add(" &7- &c&lLeon");
            } else {
                lore.add(" &7- &fLeon");
            }
        }
        lore.add("&f");
        lore.add("&fClick Izquierdo &7- &aCambiar nombre");
        for (Map.Entry<Player, String> entry : this.rangoBaratoSelected.entrySet()) {
            lore.add("&fClick Derecho &7- &aComprar rango &7(El nombre de tu rango será: " + entry.getValue() + "&7)");
        }
        lore.add("&7&m-------------------------");

        return CustomHeads.create(
                "&cRango barato",
                Utils.translate(lore),
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDI5MzJiNjZkZWNhZWZmNmViZGM3YzViZTZiMjQ2N2FhNmYxNGI3NDYzODhhMDZhMmUxZTFhODQ2M2U5ZTEyMiJ9fX0="
        );
    }

    public ItemStack rangoIntermedioItem() {

        List<String> lore = new ArrayList<>();
        lore.add("&7&m-------------------------");
        lore.add("&fEn todas las fases de rangos tienes");
        lore.add("&fa elegir entre &b3 &fnombres de tu &brango&f, los cuales");
        lore.add("&fsolo cambia el &bnombre&f, las ventajas son las mismas.");
        lore.add("");
        lore.add("&fTipo de rango&7: &bPermanente");
        lore.add("&fPrecio&7: &b12 hojas");
        lore.add(" ");
        lore.add("&fPodrás elegir entre:");
        for (Map.Entry<Player, String> entry : this.rangoIntermedioSelected.entrySet()) {
            if (entry.getValue().equalsIgnoreCase("Aguila")) {
                lore.add(" &7- &b&lAguila");
            } else {
                lore.add(" &7- &fAguila");
            }
            if (entry.getValue().equalsIgnoreCase("Colibri")) {
                lore.add(" &7- &b&lColibri");
            } else {
                lore.add(" &7- &fColibri");
            }
            if (entry.getValue().equalsIgnoreCase("Tucan")) {
                lore.add(" &7- &b&lTucan");
            } else {
                lore.add(" &7- &fTucan");
            }
        }
        lore.add("&f");
        lore.add("&fClick Izquierdo &7- &aCambiar nombre");
        for (Map.Entry<Player, String> entry : this.rangoIntermedioSelected.entrySet()) {
            lore.add("&fClick Derecho &7- &aComprar rango &7(El nombre de tu rango será: " + entry.getValue() + "&7)");
        }
        lore.add("&7&m-------------------------");

        return CustomHeads.create(
                "&bRango intermedio",
                Utils.translate(lore),
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMDdjNzhmM2VlNzgzZmVlY2QyNjkyZWJhNTQ4NTFkYTVjNDMyMzA1NWViZDJmNjgzY2QzZTgzMDJmZWE3YyJ9fX0="
        );
    }

    public ItemStack rangoAltoItem() {
        List<String> lore = new ArrayList<>();
        lore.add("&7&m-------------------------");
        lore.add("&fEn todas las fases de rangos tienes");
        lore.add("&fa elegir entre &e3 &fnombres de tu &erango&f, los cuales");
        lore.add("&fsolo cambia el &enombre&f, las ventajas son las mismas.");
        lore.add("&f");
        lore.add("&fTipo de rango&7: &ePermanente");
        lore.add("&fPrecio&7: &e35 hojas");
        lore.add(" ");
        lore.add("&fPodrás elegir entre:");
        for (Map.Entry<Player, String> entry : this.rangoAltoSelected.entrySet()) {
            if (entry.getValue().equalsIgnoreCase("Camaleon")) {
                lore.add(" &7- &e&lCamaleon");
            } else {
                lore.add(" &7- &fCamaleon");
            }
            if (entry.getValue().equalsIgnoreCase("Iguana")) {
                lore.add(" &7- &e&lIguana");
            } else {
                lore.add(" &7- &fIguana");
            }
            if (entry.getValue().equalsIgnoreCase("Serpiente")) {
                lore.add(" &7- &e&lSerpiente");
            } else {
                lore.add(" &7- &fSerpiente");
            }
        }
        lore.add("&f");
        lore.add("&fClick Izquierdo &7- &aCambiar nombre");
        for (Map.Entry<Player, String> entry : this.rangoAltoSelected.entrySet()) {
            lore.add("&fClick Derecho &7- &aComprar rango &7(El nombre de tu rango será: " + entry.getValue() + "&7)");
        }
        lore.add("&7&m-------------------------");

        return CustomHeads.create(
                "&eRango superior",
                Utils.translate(lore),
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzY0MTY4MmY0MzYwNmM1YzlhZDI2YmM3ZWE4YTMwZWU0NzU0N2M5ZGZkM2M2Y2RhNDllMWMxYTI4MTZjZjBiYSJ9fX0="
        );
    }
}
