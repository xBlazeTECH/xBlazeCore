package net.xblaze.xBlazeCore.api.util;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class PluginManager {
	
	public PluginManager() {
		
	}
	public void disablePlugin(Plugin plugin) {
		Bukkit.getServer().getPluginManager().disablePlugin(plugin);
		}

}
