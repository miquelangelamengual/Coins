package es.hulk.coins.commands;

import es.hulk.coins.menus.CoinsMenu;
import es.hulk.coins.utils.command.BaseCommand;
import es.hulk.coins.utils.command.Command;
import es.hulk.coins.utils.command.CommandArgs;

public class CoinsMenuCommand extends BaseCommand {

    @Command(name = "shop", aliases = {"menu", "coinsmenu", "coins.menu", "coins.shop", "coins.store", "coinsshop", "coinsstore"})

    @Override
    public void onCommand(CommandArgs command) {
        new CoinsMenu().openMenu(command.getPlayer());
    }
}
