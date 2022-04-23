package es.hulk.coins.commands;

import es.hulk.coins.utils.aquacore.CoinsUtils;
import es.hulk.coins.utils.command.BaseCommand;
import es.hulk.coins.utils.command.Command;
import es.hulk.coins.utils.command.CommandArgs;
import me.activated.core.utilities.chat.CC;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 20/01/2022
 * Project: Coins
 * Class: CoinsCommand
 */

public class CoinsCommand extends BaseCommand {

    @Command(name = "coins", aliases = {"coin", "money", "gems", "gems", "checkgems", "checkcoins", "gems.check", "coins.check"}, usage = "coins", description = "Shows the amount of coins you have.", inGameOnly = false)

    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            sender.sendMessage(CC.translate("§aYou have §2✦" + CoinsUtils.getCoins(player) + " §agems§7."));
            return;
        }

        if (player.hasPermission("coins.command.checkcoins")) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                sender.sendMessage(CC.translate("player " + args[0] + " not online"));
                return;
            }

            sender.sendMessage(CC.translate(target.getName() + " &ahas &2✦" + CoinsUtils.getCoins(target) + " &agems§7."));
        }
    }
}