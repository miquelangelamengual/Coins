package es.hulk.coins;

import es.hulk.coins.commands.*;
import es.hulk.coins.listener.CoinsListener;
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

    @Override
    public void onEnable() {
        this.commandManager = new CommandManager(this, new ArrayList<>());
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ButtonListener(), this);
        pm.registerEvents(new CoinsListener(), this);
        loadCommands();
    }

    public void loadCommands() {
        new CoinsCommand();
        new CoinsMenuCommand();
        new CoinsAddCommand();
        new CoinsRemoveCommand();
        new CoinsSetCommand();
        new CoinsResetCommand();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static Coins get() {
        return Coins.getPlugin(Coins.class);
    }
}
