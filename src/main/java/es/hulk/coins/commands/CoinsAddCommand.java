package es.hulk.coins.commands;

import es.hulk.coins.utils.AquaCoreUtils;
import es.hulk.coins.utils.command.BaseCommand;
import es.hulk.coins.utils.command.Command;
import es.hulk.coins.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 20/01/2022
 * Project: Coins
 * Class: CoinsAddCommand
 */

public class CoinsAddCommand extends BaseCommand {

    @Command(name = "coins.add", aliases = {"coins.give", "coins.givecoins"},  permission = "coins.command.add")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 1) {
            try {
                int amount = Integer.parseInt(args[0]);
                AquaCoreUtils.addCoins(player, amount);
                player.sendMessage("§aYou have added §f" + amount + " §acoins to your account.");
            } catch (NumberFormatException e) {
                player.sendMessage("§cInvalid number.");
            }
        }

        if (args.length == 2) {
            try {
                Player target = Bukkit.getPlayer(args[0]);
                int amount = Integer.parseInt(args[1]);

                if (target != null) {
                    AquaCoreUtils.addCoins(target, amount);
                    player.sendMessage("§aYou have added §f" + amount + " §acoins to §f" + args[0]);
                } else {
                    player.sendMessage("§cPlayer not found.");
                }
            } catch (NumberFormatException e) {
                player.sendMessage("§cInvalid number.");
            }
        }
    }
}
