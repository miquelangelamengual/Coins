package net.jungly.coins.commands;

import net.jungly.coins.utils.CoinsUtils;
import net.jungly.coins.utils.command.BaseCommand;
import net.jungly.coins.utils.command.Command;
import net.jungly.coins.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CoinsResetCommand extends BaseCommand {

    @Command(name = "coins.reset", permission = "coins.command.reset")

    @Override
    public void onCommand(CommandArgs command) {
        CommandSender player = command.getSender();
        String[] args = command.getArgs();

        if (command.getSender() instanceof ConsoleCommandSender) {
            if (args.length == 2) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);

                    if (target != null) {
                        CoinsUtils.resetCoins(target);
                        player.sendMessage("§fLe has reseteado los coins a §a" + target.getName() + "&7.");
                    } else {
                        player.sendMessage("§cPlayer not found.");
                    }
                } catch (NumberFormatException e) {
                    player.sendMessage("§cInvalid number.");
                }
            }
        }
    }
}

