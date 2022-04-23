package es.hulk.coins.commands;

import es.hulk.coins.utils.Utils;
import es.hulk.coins.utils.aquacore.CoinsUtils;
import es.hulk.coins.utils.aquacore.RankUtils;
import es.hulk.coins.utils.command.BaseCommand;
import es.hulk.coins.utils.command.Command;
import es.hulk.coins.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConsoleCoinsCommand extends BaseCommand {

    @Command(name = "ccoins", permission = "ccoins.command", inGameOnly = false)

    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();

        if (sender instanceof Player) {
            sender.sendMessage(Utils.color("&cYou can't use this command from console."));
            return;
        }

        Player target = Bukkit.getPlayer(command.getArgs(0));

        if (target == null) {
            sender.sendMessage(Utils.color("&cPlayer not found."));
            return;
        }

        CoinsUtils.addCoins(target, Integer.parseInt(command.getArgs()[1]));
    }
}