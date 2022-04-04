package es.hulk.coins.commands;

import es.hulk.coins.utils.aquacore.CoinsUtils;
import es.hulk.coins.utils.command.BaseCommand;
import es.hulk.coins.utils.command.Command;
import es.hulk.coins.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoinsResetCommand extends BaseCommand {

    @Command(name = "coins.reset", permission = "coins.command.reset", inGameOnly = false)

    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 1) {
            try {
                CoinsUtils.resetCoins(player);
                sender.sendMessage("§cYour coins has been resetted.");
            } catch (NumberFormatException e) {
                sender.sendMessage("§cInvalid number.");
            }
        }

        if (args.length == 2) {
            try {
                OfflinePlayer target = Bukkit.getPlayer(args[0]);

                if (target != null) {
                    CoinsUtils.resetCoins(target);
                    sender.sendMessage("§eYou have reset coins of §c" + target.getName() + "&7.");
                } else {
                    sender.sendMessage("§cPlayer not found.");
                }
            } catch (NumberFormatException e) {
                sender.sendMessage("§cInvalid number.");
            }
        }
    }
}

