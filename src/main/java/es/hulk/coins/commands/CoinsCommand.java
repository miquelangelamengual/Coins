package es.hulk.coins.commands;

import es.hulk.coins.utils.aquacore.CoinsUtils;
import es.hulk.coins.utils.command.BaseCommand;
import es.hulk.coins.utils.command.Command;
import es.hulk.coins.utils.command.CommandArgs;
import me.activated.core.utilities.chat.CC;
import org.bukkit.Bukkit;
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
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage(CC.translate("§eYou have §6⛃" + CoinsUtils.getCoins(player) + " §ecoins§7."));
            return;
        }

        if (player.hasPermission("coins.checkcoins")) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(CC.translate("player " + args[0] + " not online"));
                return;
            }

            player.sendMessage(CC.translate(target.getName() + " has " + CoinsUtils.getCoins(target) + " coins"));
        }
    }
}