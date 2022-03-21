package es.hulk.coins.commands;

import es.hulk.coins.utils.command.BaseCommand;
import es.hulk.coins.utils.command.Command;
import es.hulk.coins.utils.command.CommandArgs;
import me.activated.core.utilities.chat.CC;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 20/03/2022 1:00
 * Project: Coins
 * Class: CoinsHelpCommand
 */

public class CoinsHelpCommand extends BaseCommand {

    @Command(name = "coins.help", permission = "coins.command.help")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        player.sendMessage(CC.translate("&7&m---------------------------------------------------"));
        player.sendMessage(CC.translate("&b&lCrowl Coins &7- &fInformation on how to use Crowl Coins"));
        player.sendMessage(CC.translate("&7&m---------------------------------------------------"));
        player.sendMessage(CC.translate("&b&l❄ Staff Commands:"));
        player.sendMessage(CC.translate(" &7- &f/coins add <player> <coins>&7: &7Add coins to a user"));
        player.sendMessage(CC.translate(" &7- &f/coins add <coins>&7: &7Add coins to yourself"));
        player.sendMessage(CC.translate(" &7- &f/coins remove <player> <coins>&7: &7Remove coins to a user"));
        player.sendMessage(CC.translate(" &7- &f/coins remove <coins>&7: &7Remove coins to yourself"));
        player.sendMessage(CC.translate(" &7- &f/coins reset <player>&7: &7Reset all coins of a user"));
        player.sendMessage(CC.translate(" &7- &f/coins set <player>&7: &7Set the number of coins of a user"));
        player.sendMessage(CC.translate("&7&m---------------------------------------------------"));
    }
}
