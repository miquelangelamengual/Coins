package net.jungly.coins.commands;

import net.jungly.coins.utils.Utils;
import net.jungly.coins.utils.command.BaseCommand;
import net.jungly.coins.utils.command.Command;
import net.jungly.coins.utils.command.CommandArgs;
import org.bukkit.entity.Player;

public class CoinsHelpCommand extends BaseCommand {

    @Command(name = "coins.help", permission = "coins.command.help")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        player.sendMessage(Utils.color("&7&m---------------------------------------------------"));
        player.sendMessage(Utils.color("&a&lJungly Coins &r&7- &fInformacion de como usar Jungly Coins"));
        player.sendMessage(Utils.color("&7&m---------------------------------------------------"));
        player.sendMessage(Utils.color("&a&l❄ Staff Commands:"));
        player.sendMessage(Utils.color(" &7- &f/coins add <player> <coins>&7: &7Añade coins a un user"));
        player.sendMessage(Utils.color(" &7- &f/coins add <coins>&7: &7Te añades coins a ti mismo"));
        player.sendMessage(Utils.color(" &7- &f/coins remove <player> <coins>&7: &7Remueves coins a un user"));
        player.sendMessage(Utils.color(" &7- &f/coins remove <coins>&7: &7Te remueves coins a ti mismo"));
        player.sendMessage(Utils.color(" &7- &f/coins reset <player>&7: &7Haces reset de los coins de un player"));
        player.sendMessage(Utils.color(" &7- &f/coins set <player>&7: &7Pon el numero de coins que quieres que tenga un user"));
        player.sendMessage(Utils.color("&7&m---------------------------------------------------"));
    }
}
