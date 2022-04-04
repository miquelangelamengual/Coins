package es.hulk.coins.commands;

import es.hulk.coins.utils.aquacore.CoinsUtils;
import es.hulk.coins.utils.command.BaseCommand;
import es.hulk.coins.utils.command.Command;
import es.hulk.coins.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 20/01/2022
 * Project: Coins
 * Class: CoinsRemoveCommand
 */

public class CoinsRemoveCommand extends BaseCommand {

    @Command(name = "coins.remove", permission = "coins.command.remove", inGameOnly = false)

    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 1) {
            try {
                int amount = Integer.parseInt(args[0]);
                CoinsUtils.removeCoins(player, amount);
                sender.sendMessage("§eYou have removed §6⛃" + amount + " §ecoins to your account&7.");
            } catch (NumberFormatException e) {
                sender.sendMessage("§cInvalid number.");
            }
        }

        if (args.length == 2) {
            try {
                OfflinePlayer target = Bukkit.getPlayer(args[0]);
                int amount = Integer.parseInt(args[1]);

                if (target != null) {
                    CoinsUtils.removeCoins(target, amount);
                    sender.sendMessage("§eYou have removed §6⛃" + amount + " §ecoins to §f" + args[0] +"&7.");
                } else {
                    sender.sendMessage("§cPlayer not found.");
                }
            } catch (NumberFormatException e) {
                sender.sendMessage("§cInvalid number.");
            }
        }
    }
}
