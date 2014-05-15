package net.xblaze.xBlazeCore.api.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public class ConsoleManager {
	
	/**
	 * Send an Informational Message to the Console.
	 * @param p  Plugin that is sending the message
	 * @param msg  Message to send
	 */
	public void logInfo(Plugin p, String msg) {
		Bukkit.getLogger().info("==" + p.getName() + "==" + msg);
	}
	
	/**
	 * Send a Warning Message to the Console.
	 * @param p  Plugin that is sending message
	 * @param msg  Message to send
	 */
	public void logWarning(Plugin p, String msg) {
		Bukkit.getLogger().info("==" + p.getName() + " == " + msg);
	}
	
	/**
	 * Send a Fatal Error message to the Console.
	 * @param p  Plugin that is sending message
	 * @param msg  Message to send
	 */
	public void logSevere(Plugin p, String msg) {
		Bukkit.getLogger().warning(" = " + p.getName() + " = Encountered an Unrecoverable Error and is shutting down!");
		Bukkit.getLogger().severe(ChatColor.RED + " = " + p.getName() + " = " + msg);
	}
		
}
