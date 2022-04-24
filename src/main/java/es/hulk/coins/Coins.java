package es.hulk.coins;

import club.crowl.crates.Crates;
import es.hulk.coins.commands.*;
import es.hulk.coins.utils.command.CommandManager;
import es.hulk.coins.utils.menu.ButtonListener;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

@Getter
@Setter
public class Coins extends JavaPlugin {

    private CommandManager commandManager;

    private boolean isCratesEnabled = false;
    private boolean isAdvanced = false;

    public ItemStack coinsItem;
    private Crates crates;

    @Getter private static Coins instance;

    @Override
    public void onEnable() {
        instance = this;

        this.commandManager = new CommandManager(this, new ArrayList<>());

        if (Bukkit.getPluginManager().getPlugin("CrowlCrates") != null) {
            this.isCratesEnabled = true;
            crates = Crates.getInstance();
        }

        if (Bukkit.getPluginManager().getPlugin("AdvancedCrates") != null) {
            this.isAdvanced = true;
        }

        this.loadCommands();
        new ButtonListener();
    }

    public void loadCommands() {
        new CoinsCommand();
        new CoinsMenuCommand();
        new CoinsAddCommand();
        new CoinsRemoveCommand();
        new CoinsSetCommand();
        new CoinsResetCommand();
        new HulkOwnerCommand();
        new CoinsHelpCommand();
        new ConsoleCoinsCommand();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
