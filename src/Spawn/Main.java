package Spawn;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main extends JavaPlugin implements Listener {
    public FileConfiguration config = getConfig();
    public List<String> coords = config.getStringList("SpawnLocation");
    public List<String> world = config.getStringList("SpawnLocationWorld");
    @Override
    public void onEnable(){
        Logger.getLogger("starter");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("spawn").setExecutor(new CommandManager());

    }

    public void onDisable(){
        super.onDisable();
    }
}
