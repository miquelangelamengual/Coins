package es.hulk.coins.commands;

import es.hulk.coins.utils.AquaCoreUtils;
import es.hulk.coins.utils.command.BaseCommand;
import es.hulk.coins.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CoinsSetCommand extends BaseCommand {
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 1) {
            try {
                int amount = Integer.parseInt(args[0]);
                AquaCoreUtils.setCoins(player, amount);
                player.sendMessage("§aYou have set §f" + amount + " §acoins to your account.");
            } catch (NumberFormatException e) {
                player.sendMessage("§cInvalid number.");
            }
        }

        if (args.length == 2) {
            try {
                Player target = Bukkit.getPlayer(args[0]);
                int amount = Integer.parseInt(args[1]);

                if (target != null) {
                    AquaCoreUtils.setCoins(target, amount);
                    player.sendMessage("You have set " + amount + " coins to " + args[0]);
                } else {
                    player.sendMessage("§cPlayer not found.");
                }
            } catch (NumberFormatException e) {
                player.sendMessage("§cInvalid number.");
            }
        }
    }
}
