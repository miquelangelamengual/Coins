package net.jungly.coins.commands;

import net.jungly.coins.utils.CoinsUtils;
import net.jungly.coins.utils.command.BaseCommand;
import net.jungly.coins.utils.command.Command;
import net.jungly.coins.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CoinsAddCommand extends BaseCommand {

    @Command(name = "coins.add", aliases = {"coins.give", "coins.givecoins"},  permission = "coins.command.add")

    @Override
    public void onCommand(CommandArgs command) {
        CommandSender player = command.getSender();
        String[] args = command.getArgs();

        if (command.getSender() instanceof ConsoleCommandSender) {
            if (args.length == 2) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);
                    int amount = Integer.parseInt(args[1]);

                    if (target != null) {
                        CoinsUtils.addCoins(target, amount);
                        player.sendMessage("§fHas añadido §a" + amount + " §fhojas a §a" + args[0] + "&7.");
                    } else {
                        player.sendMessage("§cPlayer not found.");
                    }
                } catch (NumberFormatException e) {
                    player.sendMessage("§cInvalid number.");
                }
            }
        } else {
            player.sendMessage("Only console can execute this command.");
            return;
        }
    }
}
