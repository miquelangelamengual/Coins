package es.hulk.coins.utils.aquamenu.slots.pages;

import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.aquamenu.menu.SwitchableMenu;
import es.hulk.coins.utils.aquamenu.slots.Slot;
import lombok.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

@RequiredArgsConstructor
public class PageSlot extends Slot {

    private final SwitchableMenu switchableMenu;
    private final int slot;

    @Override
    public ItemStack getItem(Player player) {
        ItemBuilder item = new ItemBuilder(Material.BOOK);
        item.name(switchableMenu.getPagesTitle(player));

        item.addLoreLine("");
        item.addLoreLine("&bCurrent page&7: &f" + switchableMenu.getPage());
        item.addLoreLine("&bMax pages&7: &f" + switchableMenu.getPages(player));
        item.addLoreLine("");

        return item.build();
    }

    @Override
    public int getSlot() {
        return slot;
    }

    @Override
    public int[] getSlots() {
        return new int[]{40};
    }
}
