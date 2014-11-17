package net.xblaze.xBlazeCore;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandInterpreter implements Listener {

	private BlazeCore plugin;
	private xBlazeOS BlazeOS;

	public CommandInterpreter(BlazeCore pl) {
		this.plugin = pl;
		this.BlazeOS = pl.BlazeOS;
	}
	@EventHandler
	public void onCommandExecuted(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		String[] args = msg.split(" ");
		String cmd = args[0];
		
		if (cmd.equalsIgnoreCase("/plugin")) {
			if (!p.hasPermission("xblaze.core.dev")) return;
			if (BlazeOS.enabled == false) return;
			if (args[1].equalsIgnoreCase("enable")) {
				String plug = msg.replaceFirst("/plugin enable ", "");
				if (plugin.getServer().getPluginManager().getPlugin(plug)!= null) {
					if (!plugin.getServer().getPluginManager().isPluginEnabled(plug)) {
						Bukkit.getServer().getPluginManager().enablePlugin(plugin.getServer().getPluginManager().getPlugin(plug));
						p.sendMessage(ChatColor.GREEN + "The plugin '" + plug + "', has been " + ChatColor.DARK_GREEN + "enabled" + ChatColor.GREEN + "!");
					} else {
						p.sendMessage(ChatColor.GREEN + "The plugin '" + plug + "', is already " + ChatColor.DARK_GREEN + "enabled" + ChatColor.GREEN + "!");
					}
				} else {
					p.sendMessage(ChatColor.RED + "The plugin '" + plug + "', cannot be found!"  );
				}
			} else if (args[1].equalsIgnoreCase("disable")) {
				String plug = msg.replaceFirst("/plugin disable ", "");
				if (plugin.getServer().getPluginManager().getPlugin(plug) != null) {
					if (plugin.getServer().getPluginManager().isPluginEnabled(plug)) {
						Bukkit.getServer().getPluginManager().disablePlugin(plugin.getServer().getPluginManager().getPlugin(plug));
						p.sendMessage(ChatColor.GREEN + "The plugin '" + plug + "', has been " + ChatColor.RED + "disabled" + ChatColor.GREEN + "!");
					} else {
						p.sendMessage(ChatColor.GREEN + "The plugin '" + plug + "', is already " + ChatColor.RED + "disabled!" + ChatColor.GREEN + "!");
					}
				} else {
					p.sendMessage(ChatColor.RED + "The plugin '" + plug + "', cannot be found!"  );
				}
			} else if (args[1].equalsIgnoreCase("list")) {
				
			} else if (args[1].equalsIgnoreCase("disable")) {
				
			}
		}
		if (cmd.equalsIgnoreCase("/term")) {
			if (!p.hasPermission("xblaze.core.dev")) return;
			if (BlazeOS.enabled == false) return;
			BlazeOS.login(p);
			e.setCancelled(true);
		}
		if (cmd.equalsIgnoreCase("/dlplug")) {
			if (!p.hasPermission("xblaze.core.dev")) return;
			if (BlazeOS.enabled == false) return;
			e.setCancelled(true);
			msg.replaceAll("/dlplug ", "");
			try {
				Process proc;
				proc = Runtime.getRuntime().exec("wget -N --directory-prefix=plugins " + msg);
				proc.waitFor();
				BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				String line = "";
				while ((line = reader.readLine()) != null) {
					p.sendMessage(ChatColor.GRAY + line);
				}
				return;
			} catch (Exception e1) {
				p.sendMessage(e1.getCause().getMessage());
				p.sendMessage("Error Occured While Executing!");
			}
		}
		if (cmd.equalsIgnoreCase("/xdisable")) {
			if (!p.hasPermission("xblaze.core.dev")) return;
			if (BlazeOS.enabled == false) return;
			e.setCancelled(true);
			String targetplugin = msg.replaceAll("/xdisable ", "");
			try {
				p.sendMessage(targetplugin);
				plugin.getServer().getPluginManager().disablePlugin(Bukkit.getServer().getPluginManager().getPlugin(targetplugin));
				p.sendMessage(ChatColor.AQUA + "The plugin '" + targetplugin + "' has been " + ChatColor.RED + "disabled" + ChatColor.AQUA + "!");
			} catch (Exception err) {
				p.sendMessage(ChatColor.RED + "Error: '" + targetplugin + "' not found! Remember, plugin names are case sensitive.");
				p.sendMessage(err.getMessage());
			}
		}
		if (cmd.equalsIgnoreCase("/xenable")) {
			if (!p.hasPermission("xblaze.core.dev")) return;
			if (BlazeOS.enabled == false) return;
			e.setCancelled(true);
			String targetplugin = msg.replaceAll("/xenable ", "");
			try {
				p.sendMessage(targetplugin);
				plugin.getServer().getPluginManager().enablePlugin(Bukkit.getServer().getPluginManager().getPlugin(targetplugin));
				p.sendMessage(ChatColor.AQUA + "The plugin '" + targetplugin + "' has been " + ChatColor.GREEN + "enabled" + ChatColor.AQUA + "!");
			} catch (Exception err) {
				p.sendMessage(ChatColor.RED + "Error: '" + targetplugin + "' not found! Remember, plugin names are case sensitive.");
				p.sendMessage(err.getMessage());
			}
		}
	}
}
