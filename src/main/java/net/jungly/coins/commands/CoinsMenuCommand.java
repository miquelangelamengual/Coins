package net.jungly.coins.commands;

import net.jungly.coins.menus.GamemodeSelectorMenu;
import net.jungly.coins.utils.command.BaseCommand;
import net.jungly.coins.utils.command.Command;
import net.jungly.coins.utils.command.CommandArgs;

public class CoinsMenuCommand extends BaseCommand {

    @Command(name = "shop", aliases = {"menu", "coinsmenu", "coins.menu", "coins.shop", "coins.store", "coinsshop", "coinsstore"})

    @Override
    public void onCommand(CommandArgs command) {
        new GamemodeSelectorMenu().openMenu(command.getPlayer());
    }
}
