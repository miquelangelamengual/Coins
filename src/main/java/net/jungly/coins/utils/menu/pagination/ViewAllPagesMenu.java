package net.jungly.coins.utils.menu.pagination;

import net.jungly.coins.utils.menu.Button;
import net.jungly.coins.utils.menu.Menu;
import net.jungly.coins.utils.menu.buttons.BackButton;
import lombok.NonNull;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class ViewAllPagesMenu extends Menu {
    @NonNull
    PaginatedMenu menu;

    @Override
    public String getTitle(final Player player) {
        return "Jump to page";
    }

    @Override
    public Map<Integer, Button> getButtons(final Player player) {
        final HashMap<Integer, Button> buttons = new HashMap<Integer, Button>();
        buttons.put(0, new BackButton(this.menu));
        int index = 10;
        for (int i = 1; i <= this.menu.getPages(player); ++i) {
            buttons.put(index++, new JumpToPageButton(i, this.menu, this.menu.getPage() == i));
            if ((index - 8) % 9 == 0) {
                index += 2;
            }
        }
        return buttons;
    }

    @Override
    public boolean isAutoUpdate() {
        return true;
    }

    @NonNull
    public PaginatedMenu getMenu() {
        return this.menu;
    }
}
