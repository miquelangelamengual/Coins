package es.hulk.coins.utils.menu.buttons;

import es.hulk.coins.utils.ItemBuilder;
import es.hulk.coins.utils.menu.Button;
import es.hulk.coins.utils.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class BackButton extends Button
{
    private final Menu back;

    @Override
    public ItemStack getButtonItem(final Player player) {
        return new ItemBuilder(Material.ARROW).name("&cGo back!").build();
    }

    @Override
    public void clicked(final Player player, final int i, final ClickType clickType, final int hb) {
        Button.playNeutral(player);
        this.back.openMenu(player);
    }

    public BackButton(final Menu back) {
        this.back = back;
    }
}
