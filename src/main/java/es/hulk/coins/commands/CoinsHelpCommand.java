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

        player.sendMessage(CC.translate(""));
        player.sendMessage(CC.translate("/coins add <player> <coins>"));
        player.sendMessage(CC.translate("/coins add <coins>"));
        player.sendMessage(CC.translate(""));
        player.sendMessage(CC.translate("/coins remove <player> <coins>"));
        player.sendMessage(CC.translate("/coins remove <coins>"));
        player.sendMessage(CC.translate(""));
        player.sendMessage(CC.translate("/coins reset <player>"));
        player.sendMessage(CC.translate("/coins set <player>"));
        player.sendMessage(CC.translate(""));
    }
}
