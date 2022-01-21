package es.hulk.coins.commands;

import es.hulk.coins.utils.AquaCoreUtils;
import es.hulk.coins.utils.command.BaseCommand;
import es.hulk.coins.utils.command.Command;
import es.hulk.coins.utils.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 20/01/2022
 * Project: Coins
 * Class: CoinsCommand
 */

public class CoinsCommand extends BaseCommand {

    @Command(name = "coins", aliases = {"coin", "money"}, usage = "coins", description = "Shows the amount of coins you have.")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        player.sendMessage("§aYou have §e" + AquaCoreUtils.getCoins(player) + " §acoins.");
    }
}
