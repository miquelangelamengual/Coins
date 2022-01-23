package es.hulk.coins.commands;

import es.hulk.coins.utils.aquacore.CoinsUtils;
import es.hulk.coins.utils.command.BaseCommand;
import es.hulk.coins.utils.command.Command;
import es.hulk.coins.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CoinsResetCommand extends BaseCommand {

    @Command(name = "coins.remove", permission = "coins.command.remove")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 1) {
            try {
                CoinsUtils.resetCoins(player);
                player.sendMessage("§cYour coins has been resetted.");
            } catch (NumberFormatException e) {
                player.sendMessage("§cInvalid number.");
            }
        }

        if (args.length == 2) {
            try {
                Player target = Bukkit.getPlayer(args[0]);

                if (target != null) {
                    CoinsUtils.resetCoins(target);
                    player.sendMessage("§cYou have reset coins of §f" + target.getName() + ".");
                } else {
                    player.sendMessage("§cPlayer not found.");
                }
            } catch (NumberFormatException e) {
                player.sendMessage("§cInvalid number.");
            }
        }
    }
}

