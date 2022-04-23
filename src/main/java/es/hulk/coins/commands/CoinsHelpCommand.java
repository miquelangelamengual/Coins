package es.hulk.coins.commands;

import es.hulk.coins.utils.command.BaseCommand;
import es.hulk.coins.utils.command.Command;
import es.hulk.coins.utils.command.CommandArgs;
import me.activated.core.utilities.chat.CC;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 20/03/2022 1:00
 * Project: Coins
 * Class: CoinsHelpCommand
 */

public class CoinsHelpCommand extends BaseCommand {

    @Command(name = "coins.help", aliases = {"gems.help", "coinshelp", "gemshelp"},permission = "coins.command.help", inGameOnly = false)

    @Override
    public void onCommand(CommandArgs command) {
        CommandSender player = command.getSender();

        player.sendMessage(CC.translate("&7&m---------------------------------------------------"));
        player.sendMessage(CC.translate("&a&lGems &7- &fInformation on how to use &AGems"));
        player.sendMessage(CC.translate("&7&m---------------------------------------------------"));
        player.sendMessage(CC.translate("&2&l❄ Staff Commands:"));
        player.sendMessage(CC.translate(" &7- &a/gems add <player> <coins>&7: &7Add gems to a user"));
        player.sendMessage(CC.translate(" &7- &a/gems add <coins>&7: &7Add gems to yourself"));
        player.sendMessage(CC.translate(" &7- &a/gems remove <player> <coins>&7: &7Remove gems to a user"));
        player.sendMessage(CC.translate(" &7- &a/gems remove <coins>&7: &7Remove gems to yourself"));
        player.sendMessage(CC.translate(" &7- &a/gems reset <player>&7: &7Reset all gems of a user"));
        player.sendMessage(CC.translate(" &7- &a/gems set <player>&7: &7Set the number of gems of a user"));
        player.sendMessage(CC.translate(" &7- &a/gems check <player>&7: &7Check the gems of a user"));
        player.sendMessage(CC.translate("&7&m---------------------------------------------------"));
    }
}
