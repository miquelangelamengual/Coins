package es.hulk.coins;

import es.hulk.coins.commands.CoinsCommand;
import es.hulk.coins.commands.CoinsMenuCommand;
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
        this.mainConfig = new FileConfig(this, "config.yml");
        this.commandManager = new CommandManager(this, new ArrayList<>());
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ButtonListener(), this);
        loadCommands();
    }

    public void loadCommands() {
        new CoinsCommand();
        new CoinsMenuCommand();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static Coins get() {
        return Coins.getPlugin(Coins.class);
    }
}
