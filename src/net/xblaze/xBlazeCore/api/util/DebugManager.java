package net.xblaze.xBlazeCore.api.util;

import net.xblaze.xBlazeCore.BlazeCore;
import net.xblaze.xBlazeCore.api.types.DebugType;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class DebugManager {	
	
	private BlazeCore plugin;
	
	public DebugManager(BlazeCore plugin) {
		this.plugin = plugin;
	}
	
	/**
	 * Turns on Debugging messages for the specified player.
	 * @param p  Target Player
	 */
	public void startDebugging(Player p) {
		p.sendMessage(ChatColor.LIGHT_PURPLE + "Debugging mode Activated. All xBlaze plugins will now spit up on you!");
		p.setMetadata("xbdbg", new FixedMetadataValue(plugin,true));
	}
	
	/**
	 * Turns off Debugging messages for the specified player.
	 * @param p  Target Player
	 */
	public void stopDebugging(Player p) {
		p.sendMessage(ChatColor.LIGHT_PURPLE + "Debugging mode Deactivated. All xBlaze plugin will now stop spitting up on you!");
		p.removeMetadata("xbdbg", plugin);
	}
	
	/**
	 * Checks to see if the specified player is debugging.
	 * @param p  Target Player
	 * @return  True if the player is, and False if the player is not.
	 */
	public boolean isDebugging(Player p) {
		return p.hasMetadata("xbdbg");
	}
	
	/**
	 * Sends the specified message to the debuggers.
	 * @param msg  Message to send
	 * @param type  Type of Debugging Message (For formatting purposes)
	 */
	public void message(String msg, DebugType type) {
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (isDebugging(p))	p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "xBlaze" + ChatColor.DARK_GRAY + "]" + ChatColor.DARK_RED + "Debug: " + msg);
		}
	}
	
}
