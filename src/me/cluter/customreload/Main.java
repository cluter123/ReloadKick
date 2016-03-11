package me.cluter.customreload;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
	}
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("reloadkick")) {
			if (!sender.hasPermission("reloadkick.reload")) {
				sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
				return false;
			}
			String message = ChatColor.translateAlternateColorCodes('&',getConfig().getString("message"));
			for (Player p : Bukkit.getServer().getOnlinePlayers()) {
				p.kickPlayer(message);
			}
			Bukkit.getServer().reload();
			return true;
		}
		return false;
	}

}
