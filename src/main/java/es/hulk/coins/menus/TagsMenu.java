package es.hulk.coins.menus;

import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.Utils;
import es.hulk.coins.utils.aquacore.CoinsUtils;
import es.hulk.coins.utils.aquacore.PlayerUtils;
import es.hulk.coins.utils.aquacore.RankUtils;
import es.hulk.coins.utils.aquamenu.menu.SwitchableMenu;
import es.hulk.coins.utils.aquamenu.slots.Slot;
import es.hulk.coins.utils.menu.Button;
import es.hulk.coins.utils.menu.Menu;
import es.hulk.coins.utils.menu.pagination.JumpToPageButton;
import es.hulk.coins.utils.menu.pagination.PaginatedMenu;
import me.activated.core.api.tags.Tag;
import me.activated.core.plugin.AquaCore;
import me.activated.core.plugin.AquaCoreAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hulk
 * at 05/03/2022 9:45
 * Project: Coins
 * Class: TagsMenu
 */

public class TagsMenu extends SwitchableMenu {

    @Override
    public String getPagesTitle(Player player) {
        return "polla";
    }

    @Override
    public List<Slot> getSwitchableSlots(Player player) {
        List<Slot> slots = new ArrayList<>();
        for (Tag tag : AquaCore.INSTANCE.getTagManagement().getTags()) {
            slots.add(new Slot() {
                @Override
                public ItemStack getItem(Player player) {
                    return new ItemBuilder(Material.NAME_TAG).name(tag.getName()).build();
                }

                @Override
                public int getSlot() {
                    return 0;
                }

                @Override
                public void onClick(Player player, int slot, ClickType clickType) {
                    if (player.hasPermission("aqua.tags." + tag.getName())) {
                        player.sendMessage(Utils.color("&cYou already have this tag"));
                        return;
                    }

                    if (CoinsUtils.getCoins(player) >= 350) {
                        CoinsUtils.removeCoins(player, 350);
                        RankUtils.givePermission(player, "aqua.tags." + tag.getName());
                        player.sendMessage("§aYou have bought the tag §e" + tag.getName());
                        PlayerUtils.sendGlobalMessage("§a" + player.getName() + " has bought the tag §e" + tag.getName());
                        return;
                    }
                    player.sendMessage("§cYou don't have enough coins");
                }
            });
        }
        return slots;
    }

    @Override
    public List<Slot> getEveryMenuSlots(Player player) {
        return new ArrayList<>();
    }
}
