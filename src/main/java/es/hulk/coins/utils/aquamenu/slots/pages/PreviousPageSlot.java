package es.hulk.coins.utils.aquamenu.slots.pages;

import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.Utils;
import es.hulk.coins.utils.aquamenu.menu.SwitchableMenu;
import es.hulk.coins.utils.aquamenu.slots.Slot;
import lombok.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.*;

@RequiredArgsConstructor
public class PreviousPageSlot extends Slot {

    private final SwitchableMenu switchableMenu;

    @Override
    public ItemStack getItem(Player player) {
        ItemBuilder item = new ItemBuilder(Material.CARPET);
        item.name("&6Previous Page");
        item.addLoreLine(" ");

        if (this.switchableMenu.getPage() != 1) {
            item.addLoreLine("&7Click to head over");
            item.addLoreLine("&7to previous page.");
            item.addLoreLine(" ");
            item.addLoreLine("&6Page: &7(&e" + this.switchableMenu.getPage() + "&7/&e" + this.switchableMenu.getPages(player) + "&7)");
        } else {
            item.addLoreLine("&eThere is no previous page.");
            item.addLoreLine("&eYou're on the first page.");
            item.addLoreLine(" ");
            item.addLoreLine("&6Page: &7(&e" + this.switchableMenu.getPage() + "&7/&e" + this.switchableMenu.getPages(player) + "&7)");
        }
        item.lore(" ");

        return item.build();
    }

    @Override
    public void onClick(Player player, int slot, ClickType clickType) {
        if (this.switchableMenu.getPage() == 1) {
            player.sendMessage(Utils.color("&cYou're on the first page of the menu!"));
            return;
        }
        this.switchableMenu.changePage(player, -1);
    }

    @Override
    public int getSlot() {
        return 18;
    }

    @Override
    public int[] getSlots() {
        return null;
    }
}
