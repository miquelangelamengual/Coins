package net.jungly.coins.commands;

import net.jungly.coins.utils.CoinsUtils;
import net.jungly.coins.utils.Utils;
import net.jungly.coins.utils.command.BaseCommand;
import net.jungly.coins.utils.command.Command;
import net.jungly.coins.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CoinsCommand extends BaseCommand {

    @Command(name = "coins", aliases = {"coin", "money"}, usage = "coins")

    @Override
    public void onCommand(CommandArgs command) {
        CommandSender player = command.getSender();
        String[] args = command.getArgs();

        if (command.getSender() instanceof ConsoleCommandSender) {
            if (player.hasPermission("coins.checkcoins")) {
                Player target = Bukkit.getPlayer(args[0]);

                if (target == null) {
                    player.sendMessage(Utils.color("player " + args[0] + " not online"));
                    return;
                }

                player.sendMessage(Utils.color(target.getName() + " has " + CoinsUtils.getCoins(target) + " coins"));
            }
        }
    }
}