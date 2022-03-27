package es.hulk.coins.commands;

import es.hulk.coins.utils.aquacore.CoinsUtils;
import es.hulk.coins.utils.command.BaseCommand;
import es.hulk.coins.utils.command.Command;
import es.hulk.coins.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class CoinsSetCommand extends BaseCommand {

    @Command(name = "coins.set", permission = "coins.command.set", inGameOnly = false)

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 1) {
            try {
                int amount = Integer.parseInt(args[0]);
                CoinsUtils.setCoins(player, amount);
                player.sendMessage("§eYou have set §6⛃" + amount + " §ecoins to your account&7.");
            } catch (NumberFormatException e) {
                player.sendMessage("§cInvalid number.");
            }
        }

        if (args.length == 2) {
            try {
                OfflinePlayer target = Bukkit.getPlayer(args[0]);
                int amount = Integer.parseInt(args[1]);

                if (target != null) {
                    CoinsUtils.setCoins(target, amount);
                    player.sendMessage("§eYou have set §6⛃" + amount + " §ecoins to §f" + args[0] + "&7.");
                } else {
                    player.sendMessage("§cPlayer not found.");
                }
            } catch (NumberFormatException e) {
                player.sendMessage("§cInvalid number.");
            }
        }
    }
}
