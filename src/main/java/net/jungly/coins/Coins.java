package net.jungly.coins;

import net.jungly.coins.commands.*;
import net.jungly.coins.listener.CoinsListener;
import net.jungly.coins.mongo.MongoConnector;
import net.jungly.coins.placeholders.HojasPlaceholder;
import net.jungly.coins.user.UserManager;
import net.jungly.coins.utils.FileConfig;
import net.jungly.coins.utils.command.CommandManager;
import net.jungly.coins.utils.menu.ButtonListener;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

@Getter
@Setter
public class Coins extends JavaPlugin {

    private CommandManager commandManager;
    private FileConfig mainConfig;

    public ItemStack coinsItem;

    private MongoConnector mongoConnector;

    private UserManager userManager;

    @Override
    public void onEnable() {
        this.mongoConnector = new MongoConnector();
        this.mongoConnector.setup();

        this.userManager = new UserManager(this.mongoConnector.getMongoDatabase());

        new HojasPlaceholder().register();

        this.mainConfig = new FileConfig(this, "settings.yml");
        this.commandManager = new CommandManager(this, new ArrayList<>());

        this.loadListeners();
        this.loadCommands();
    }

    public void loadCommands() {
        new CoinsCommand();
        new CoinsMenuCommand();
        new CoinsAddCommand();
        new CoinsRemoveCommand();
        new CoinsSetCommand();
        new CoinsResetCommand();
        new CoinsHelpCommand();
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
