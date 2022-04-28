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
public class NextPageSlot extends Slot {

    private final SwitchableMenu switchableMenu;

    @Override
    public ItemStack getItem(Player player) {
        ItemBuilder item = new ItemBuilder(Material.CARPET);
        item.name("&3Next page");
        item.addLoreLine(" ");

        if (this.switchableMenu.getPage() < this.switchableMenu.getPages(player)) {
            item.addLoreLine("&fClick to head");
            item.addLoreLine("&fover to next page.");
            item.addLoreLine(" ");
            item.addLoreLine("&bPage: &f" + this.switchableMenu.getPage() + " &7/ &f" + this.switchableMenu.getPages(player));
        } else {
            item.addLoreLine("&fThere is no next page.");
            item.addLoreLine("&fYou're on the last page.");
            item.addLoreLine(" ");
            item.addLoreLine("&bPage: &f" + this.switchableMenu.getPage() + " &7/ &f" + this.switchableMenu.getPages(player));
        }
        item.addLoreLine(" ");

        return item.build();
    }

    @Override
    public void onClick(Player player, int slot, ClickType clickType) {
        if (this.switchableMenu.getPage() >= this.switchableMenu.getPages(player)) {
            player.sendMessage(Utils.color("&cYou're on the last page of the menu!"));
            return;
        }
        this.switchableMenu.changePage(player, 1);
    }

    @Override
    public int getSlot() {
        return 26;
    }

    @Override
    public int[] getSlots() {
        return null;
    }
}
