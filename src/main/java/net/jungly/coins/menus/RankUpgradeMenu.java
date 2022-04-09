package net.jungly.coins.menus;

import com.google.common.collect.Maps;
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

public class RankUpgradeMenu extends Menu {

    private String server;

    private Map<Player, String> cheapToMiddleUpgrade = Maps.newHashMap();
    private Map<Player, String> middleToHighUpgrade = Maps.newHashMap();

    public RankUpgradeMenu(Player player, String server) {
        this.cheapToMiddleUpgrade.put(player, "Aguila");
        this.middleToHighUpgrade.put(player, "Camaleon");

        this.server = server;
    }

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
                return cheapToMiddleItem();
            }

            @Override
            public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                if (clickType.isLeftClick()) {
                    for (Map.Entry<Player, String> entry : cheapToMiddleUpgrade.entrySet()) {
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
                    for (Map.Entry<Player, String> entry : cheapToMiddleUpgrade.entrySet()) {
                        if (CoinsUtils.getCoins(player) >= 7) {
                            if (RankUtils.isTempRank(player) == false) {
                                if (RankUtils.hasRank(player, "Tigre") || RankUtils.hasRank(player, "Jaguar") || RankUtils.hasRank(player, "Leon")) {
                                    RankUtils.setPermRank(player, entry.getValue(), server);
                                    CoinsUtils.removeCoins(player, 7);
                                    return;
                                } else {
                                    player.sendMessage(Utils.color("&fNo tienes el &arango &fnecesario para &amejorarlo&f."));
                                }
                            } else {
                                player.sendMessage(Utils.color("&fNecesitas un rango &apermanente &fpara upgradearlo."));
                            }
                        } else {
                            player.sendMessage(Utils.color("&fNo tienes suficientes &ahojas&f!"));
                        }
                    }
                }
            }
        });

        buttons.put(13, new

                Button() {
                    @Override
                    public ItemStack getButtonItem(Player p0) {
                        return middleToHigh();
                    }

                    @Override
                    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                        if (clickType.isLeftClick()) {
                            for (Map.Entry<Player, String> entry : middleToHighUpgrade.entrySet()) {
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
                            for (Map.Entry<Player, String> entry : middleToHighUpgrade.entrySet()) {
                                if (CoinsUtils.getCoins(player) >= 25) {
                                    if (RankUtils.isTempRank(player) == false) {
                                        if (RankUtils.hasRank(player, "Aguila") || RankUtils.hasRank(player, "Colibri") || RankUtils.hasRank(player, "Tucan")) {
                                            RankUtils.setPermRank(player, entry.getValue(), server);
                                            CoinsUtils.removeCoins(player, 25);
                                            return;
                                        } else {
                                            player.sendMessage(Utils.color("&fNo tienes el &arango &fnecesario para &amejorarlo&f."));
                                        }
                                    } else {
                                        player.sendMessage(Utils.color("&fNecesitas un rango &apermanente &fpara upgradearlo."));
                                    }
                                } else {
                                    player.sendMessage(Utils.color("&fNo tienes suficientes &ahojas&f!"));
                                }
                            }
                        }
                    }
                });

        buttons.put(15, new

                Button() {
                    @Override
                    public ItemStack getButtonItem(Player p0) {
                        return superiorToExtreme();
                    }

                    @Override
                    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
                        if (CoinsUtils.getCoins(player) >= 20) {
                            if (RankUtils.isTempRank(player) == false) {
                                if (RankUtils.hasRank(player, "Camaleon") || RankUtils.hasRank(player, "Iguana") || RankUtils.hasRank(player, "Serpiente")) {
                                    RankUtils.setPermRank(player, "Jungle", server);
                                    CoinsUtils.removeCoins(player, 20);
                                    return;
                                } else {
                                    player.sendMessage(Utils.color("&fNo tienes el &arango &fnecesario para &amejorarlo&f."));
                                }
                            } else {
                                player.sendMessage(Utils.color("&fNecesitas un rango &apermanente &fpara upgradearlo."));
                            }
                        } else {
                            player.sendMessage(Utils.color("&fNo tienes suficientes &ahojas&f!"));
                        }
                    }
                });

        buttons.put(22, new BackButton(new CoinsMenuSurvivalOp(server)));

        return buttons;
    }

    public ItemStack cheapToMiddleItem() {
        List<String> lore = new ArrayList<>();
        lore.add("&7&m-------------------------");
        lore.add("&fEsta mejora de &arango &fes permanente");
        lore.add("&f");
        lore.add("&fEsto te permitirá pasar del rango &abarato &fal &amedio");
        lore.add("&fsin necesidad de comprartelo entero!");
        lore.add("&f");
        lore.add("&fCoste del upgrade&7: &a7 hojas");
        lore.add("&f");
        lore.add("&fAquí podrás elegir el nombre de tu rango intermedio&7:");
        for (Map.Entry<Player, String> entry : this.cheapToMiddleUpgrade.entrySet()) {
            if (entry.getValue().equalsIgnoreCase("Aguila")) {
                lore.add(" &7- &a&lAguila");
            } else {
                lore.add(" &7- &fAguila");
            }
            if (entry.getValue().equalsIgnoreCase("Colibri")) {
                lore.add(" &7- &a&lColibri");
            } else {
                lore.add(" &7- &fColibri");
            }
            if (entry.getValue().equalsIgnoreCase("Tucan")) {
                lore.add(" &7- &a&lTucan");
            } else {
                lore.add(" &7- &fTucan");
            }
        }
        lore.add("&f");
        lore.add("&fClick Izquierdo &7- &aCambiar nombre");
        for (Map.Entry<Player, String> entry : this.cheapToMiddleUpgrade.entrySet()) {
            lore.add("&fClick Derecho &7- &aUpradear rango &7(El nombre de tu rango será: " + entry.getValue() + "&7)");
        }
        lore.add("&7&m-------------------------");

        return CustomHeads.create(
                "&cBarato &7» &bMedio",
                Utils.translate(lore),
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODNkODc0ZWI4YzRjNjk3YjNmODMyYmQ4NzQ0MjZmZGY2ZDIxYmFlMzM5ZjMxNzExMDgxZmRlNTk4MzgzODZlMSJ9fX0="
        );
    }

    public ItemStack middleToHigh() {
        List<String> lore = new ArrayList<>();
        lore.add("&7&m-------------------------");
        lore.add("&fEsta mejora de &arango &fes permanente");
        lore.add("&f");
        lore.add("&fEsto te permitirá pasar del rango &bmedio &fal &esuperior");
        lore.add("&fsin necesidad de comprartelo entero!");
        lore.add("&f");
        lore.add("&fCoste del upgrade&7: &a25 hojas");
        lore.add("&f");
        lore.add("&fAquí podrás elegir el nombre de tu rango superior&7:");
        for (Map.Entry<Player, String> entry : this.middleToHighUpgrade.entrySet()) {
            if (entry.getValue().equalsIgnoreCase("Camaleon")) {
                lore.add(" &7- &a&lCamaleon");
            } else {
                lore.add(" &7- &fCamaleon");
            }
            if (entry.getValue().equalsIgnoreCase("Iguana")) {
                lore.add(" &7- &a&lIguana");
            } else {
                lore.add(" &7- &fIguana");
            }
            if (entry.getValue().equalsIgnoreCase("Serpiente")) {
                lore.add(" &7- &a&lSerpiente");
            } else {
                lore.add(" &7- &fSerpiente");
            }
        }
        lore.add("&f");
        lore.add("&fClick Izquierdo &7- &aCambiar nombre");
        for (Map.Entry<Player, String> entry : this.middleToHighUpgrade.entrySet()) {
            lore.add("&fClick Derecho &7- &aUpradear rango &7(El nombre de tu rango será: " + entry.getValue() + "&7)");
        }
        lore.add("&7&m-------------------------");

        return CustomHeads.create(
                "&bMedio &7» &eSuperior",
                Utils.translate(lore),
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODNkODc0ZWI4YzRjNjk3YjNmODMyYmQ4NzQ0MjZmZGY2ZDIxYmFlMzM5ZjMxNzExMDgxZmRlNTk4MzgzODZlMSJ9fX0="
        );
    }

    public ItemStack superiorToExtreme() {
        List<String> lore = new ArrayList<>();
        lore.add("&7&m-------------------------");
        lore.add("&fEsta mejora de &arango &fes permanente");
        lore.add("&f");
        lore.add("&fEsto te permitirá pasar del rango &esuperior &fal &eextremo");
        lore.add("&fsin necesidad de comprartelo entero!");
        lore.add("&f");
        lore.add("&fCoste del upgrade&7: &a20 hojas");
        lore.add("&f");
        lore.add("&fEl rango &aextremo &fno tiene elección de nombres");
        lore.add("&fpara así ser más &aexclusivo&f.");
        lore.add("&f");
        lore.add("&fClick &7- &aComprar upgrade");
        lore.add("&7&m-------------------------");

        return CustomHeads.create(
                "&eSuperior &7» &aExtremo",
                Utils.translate(lore),
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODNkODc0ZWI4YzRjNjk3YjNmODMyYmQ4NzQ0MjZmZGY2ZDIxYmFlMzM5ZjMxNzExMDgxZmRlNTk4MzgzODZlMSJ9fX0="
        );
    }
}
