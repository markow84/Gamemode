package pl.vatiaz.core;

import org.bukkit.plugin.java.JavaPlugin;
import pl.vatiaz.core.command.GameModeCommand;

public class CorePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin został włączony!");
        this.getCommand("gamemode").setExecutor(new GameModeCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin został wyłączony!");
    }
}
