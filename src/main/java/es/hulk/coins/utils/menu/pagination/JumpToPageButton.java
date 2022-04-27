package es.hulk.coins.utils.menu.pagination;

import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.Utils;
import es.hulk.coins.utils.menu.Button;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class JumpToPageButton extends Button {
    private final int page;
    private final PaginatedMenu menu;
    private final boolean current;

    @Override
    public ItemStack getButtonItem(Player player) {
        ItemBuilder itemBuilder = new ItemBuilder(this.current ? Material.ENCHANTED_BOOK : Material.BOOK).amount(this.page);
        itemBuilder.name(Utils.color("&cPage " + this.page));
        if (this.current) {
            itemBuilder.lore("", Utils.color("&aCurrent page"));
        }
        return itemBuilder.build();
    }

    @Override
    public void clicked(Player player, int i, ClickType clickType, int hb) {
        this.menu.modPage(player, this.page - this.menu.getPage());
        Button.playNeutral(player);
    }

    public JumpToPageButton(int page, PaginatedMenu menu, boolean current) {
        this.page = page;
        this.menu = menu;
        this.current = current;
    }
}