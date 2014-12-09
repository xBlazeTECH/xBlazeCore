package net.xblaze.xBlazeCore.api.util;

import net.xblaze.xBlazeCore.api.types.ConsoleMessageType;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class ConsoleManager {
	
	private Plugin pl;
	
	public ConsoleManager(Plugin provider) {
		this.pl = provider;
	}
	
	public void log(ConsoleMessageType type, String msg) {
		switch (type) {
		case INFO:
			Bukkit.getLogger().info("==" + pl.getName() + "==" + msg);
		case WARNING:
			Bukkit.getLogger().warning("==" + pl.getName() + "==" + msg);			
		case SEVERE:
			Bukkit.getLogger().severe("==" + pl.getName() + "==" + msg);
		}
	}		
}
