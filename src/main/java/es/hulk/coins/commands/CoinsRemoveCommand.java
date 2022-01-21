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
 * Class: CoinsRemoveCommand
 */

public class CoinsRemoveCommand extends BaseCommand {

    @Command(name = "coins.remove", permission = "coins.command.remove")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 1) {
            try {
                int amount = Integer.parseInt(args[0]);
                AquaCoreUtils.removeCoins(player, amount);
                player.sendMessage("§6You have removed §f" + amount + " §6coins to your account.");
            } catch (NumberFormatException e) {
                player.sendMessage("§cInvalid number.");
            }
        }

        if (args.length == 2) {
            try {
                Player target = Bukkit.getPlayer(args[0]);
                int amount = Integer.parseInt(args[1]);

                if (target != null) {
                    AquaCoreUtils.removeCoins(target, amount);
                    player.sendMessage("§6You have removed §f" + amount + " §6coins to §f" + args[0]);
                } else {
                    player.sendMessage("§cPlayer not found.");
                }
            } catch (NumberFormatException e) {
                player.sendMessage("§cInvalid number.");
            }
        }
    }
}
