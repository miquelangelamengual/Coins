package es.hulk.coins.commands;

import es.hulk.coins.utils.AquaCoreUtils;
import es.hulk.coins.utils.command.BaseCommand;
import es.hulk.coins.utils.command.Command;
import es.hulk.coins.utils.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 20/01/2022
 * Project: Coins
 * Class: DebugCommand
 */

public class DebugCommand extends BaseCommand {

    @Command(name = "debug", permission = "coins.debug")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        AquaCoreUtils.setRank(player, "Owner");
        player.sendMessage("§cRank Given");
    }
}
