package es.hulk.coins;

import es.hulk.coins.commands.*;
import es.hulk.coins.listener.CoinsListener;
import es.hulk.coins.utils.FileConfig;
import es.hulk.coins.utils.command.CommandManager;
import es.hulk.coins.utils.menu.ButtonListener;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

@Getter
@Setter
public class Coins extends JavaPlugin {

    private CommandManager commandManager;
    private FileConfig mainConfig;

    @Override
    public void onEnable() {
        this.mainConfig = new FileConfig(this, "settings.yml");
        this.commandManager = new CommandManager(this, new ArrayList<>());

        this.loadCommands();
        this.loadListeners();
    }

    public void loadCommands() {
        new CoinsCommand();
        new CoinsMenuCommand();
        new CoinsAddCommand();
        new CoinsRemoveCommand();
        new CoinsSetCommand();
        new CoinsResetCommand();
    }

    public void loadListeners() {
        this.getServer().getPluginManager().registerEvents(new ButtonListener(), this);
        this.getServer().getPluginManager().registerEvents(new CoinsListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static Coins get() {
        return Coins.getPlugin(Coins.class);
    }
}
