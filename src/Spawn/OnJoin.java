package Spawn;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class OnJoin implements Listener {
    Main main = JavaPlugin.getPlugin(Main.class);

    @EventHandler
    public void onjoin (PlayerJoinEvent event){
        if (event.getPlayer().hasPlayedBefore()){
            if (event.getPlayer().getWorld().getName() == "world") {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp " + event.getPlayer().getName() + " " + String.valueOf(main.getConfig().getString("SpawnLocation")).replace(",", ""));
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + event.getPlayer().getName() + " " + String.valueOf(main.getConfig().getString("SpawnLocationWorld")).replace(",", ""));
            }
        }
    }
}
