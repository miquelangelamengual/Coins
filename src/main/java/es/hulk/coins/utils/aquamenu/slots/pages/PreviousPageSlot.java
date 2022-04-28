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
        item.name("&3Previous Page");
        item.addLoreLine(" ");

        if (this.switchableMenu.getPage() != 1) {
            item.addLoreLine("&fClick to head over");
            item.addLoreLine("&fto previous page.");
            item.addLoreLine(" ");
            item.addLoreLine("&bPage: &f" + this.switchableMenu.getPage() + " &7/ &f" + this.switchableMenu.getPages(player));
        } else {
            item.addLoreLine("&fThere is no previous page.");
            item.addLoreLine("&fYou're on the first page.");
            item.addLoreLine(" ");
            item.addLoreLine("&bPage: &f" + this.switchableMenu.getPage() + " &7/ &f" + this.switchableMenu.getPages(player));
        }
        item.addLoreLine(" ");

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
