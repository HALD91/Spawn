package Spawn;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class OnFirstJoin implements Listener {
    Main main = JavaPlugin.getPlugin(Main.class);

    @EventHandler
    public void onfirstjoin (PlayerJoinEvent event){
        if (!event.getPlayer().hasPlayedBefore()) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp " + event.getPlayer().getName() + " " + String.valueOf(main.getConfig().getString("SpawnLocation")).replace(",", ""));
        }
    }
}
