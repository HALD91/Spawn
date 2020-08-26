package Spawn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandManager implements CommandExecutor {
    String prefix = "" + ChatColor.GRAY + "[" + ChatColor.DARK_AQUA + "Nxtgen" + ChatColor.LIGHT_PURPLE + "Spawn" + ChatColor.GRAY + "]" + ChatColor.RESET + " ";
    Main main = JavaPlugin.getPlugin(Main.class);

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("spawn")) {
            if (commandSender instanceof Player) {
                Player p1 = (Player) commandSender;
                if (commandSender.hasPermission("spawn.use")) {
                    if (commandSender instanceof ConsoleCommandSender) {
                        commandSender.sendMessage(ChatColor.RED + "This command can't be used in the console");
                    }
                    if (strings.length <= 0) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + p1.getPlayer().getName() + " " + String.valueOf(main.getConfig().getString("SpawnLocationWorld")).replace(",", ""));
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp " + p1.getPlayer().getName() + " " + String.valueOf(main.getConfig().getString("SpawnLocation")).replace(",", ""));
                        commandSender.sendMessage(prefix + ChatColor.YELLOW + "You have been teleported to spawn");
                        return true;
                    }
                    if (strings[0].equalsIgnoreCase("set")) {
                        if (commandSender.hasPermission("spawn.admin")) {

                            String x = String.valueOf(p1.getLocation().getX());
                            String y = String.valueOf(p1.getLocation().getY());
                            String z = String.valueOf(p1.getLocation().getZ());
                            String world = String.valueOf(p1.getWorld().getName());
                            main.coords.add(x);
                            main.coords.add(y);
                            main.coords.add(z);
                            main.world.add(world);
                            main.getConfig();
                            main.getConfig().set("SpawnLocationWorld", main.world.toString().replace("[", "").replace("]", ""));
                            main.getConfig().set("SpawnLocation", main.coords.toString().replace("[", "").replace("]", ""));
                            main.coords.clear();
                            main.world.clear();
                            main.saveConfig();
                            commandSender.sendMessage(prefix + ChatColor.YELLOW + "spawn set at: " + ChatColor.RED + String.valueOf(main.getConfig().getString("SpawnLocation")).replace(",", "") + ChatColor.YELLOW + " at world: " + ChatColor.RED + String.valueOf(main.getConfig().getString("SpawnLocationWorld")).replace(",", ""));
                        }
                    }else {
                        commandSender.sendMessage(prefix + ChatColor.YELLOW + "It seems like you don't have permission to use this command.");
                    }
                }
            }
        }
        return true;
    }
}
