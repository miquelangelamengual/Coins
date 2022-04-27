package es.hulk.coins.menus;

import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.Utils;
import es.hulk.coins.utils.aquacore.CoinsUtils;
import es.hulk.coins.utils.aquacore.PlayerUtils;
import es.hulk.coins.utils.aquacore.RankUtils;
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

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hulk
 * at 05/03/2022 9:45
 * Project: Coins
 * Class: TagsMenu
 */

public class TagsMenu extends PaginatedMenu {
    @Override
    public String getTitle(Player player) {
        return "Tags";
    }

    @Override
    public int size(Map<Integer, Button> buttons) {
        return 27;
    }

    @Override
    public String getPrePaginatedTitle(Player p0) {
        return "1";
    }

    @Override
    public Map<Integer, Button> getAllPagesButtons(Player p0) {
        Map<Integer, Button> buttons = new HashMap<>();

        for (Tag tag : AquaCore.INSTANCE.getTagManagement().getTags()) {
            buttons.put(buttons.size(), new Button() {
                @Override
                public ItemStack getButtonItem(Player player) {
                    if (player.hasPermission("aqua.tags." + tag.getName())) {
                        return new ItemBuilder(Material.NAME_TAG).name(tag.getColor() + tag.getName()).lore("&aAlredy have this tag").build();
                    } else {
                        return new ItemBuilder(Material.NAME_TAG).name(tag.getColor() + tag.getName()).build();
                    }
                }

                @Override
                public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {

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
        return buttons;
    }
}
