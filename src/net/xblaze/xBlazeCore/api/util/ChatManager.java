package net.xblaze.xBlazeCore.api.util;

import net.xblaze.xBlazeCore.api.types.BroadcastType;
import net.xblaze.xBlazeCore.api.types.MessageType;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatManager {
	
	public Boolean globalmute;
	
	/**
	 * Broadcast a message to all users in the format of the BroadcastType
	 * @param message  Message to be broadcasted
	 * @param type  BroadcastType Format
	 * @param override  Still broadcast even if global chat is disabled?
	 */
	public void broadcast(String message, BroadcastType type, boolean override) {
		if (override || (!globalmute)) {
			switch (type) {
			case WARNING:
				for (Player p : Bukkit.getOnlinePlayers()) sendMessage(p, message, MessageType.WARNING, override);
				break;
			case CAUTION:
				for (Player p : Bukkit.getOnlinePlayers()) sendMessage(p, message, MessageType.CAUTION, override);
				break;
			case INFO:
				for (Player p : Bukkit.getOnlinePlayers()) sendMessage(p, message, MessageType.INFO, override);
				break;
			case SUCCESS:
				for (Player p : Bukkit.getOnlinePlayers()) sendMessage(p, message, MessageType.SUCCESS, override);
				break;
			case ABSTRACT:
				for (Player p : Bukkit.getOnlinePlayers()) sendMessage(p, message, MessageType.ABSTRACT, override);
				break;
			case SUBTLE:
				for (Player p : Bukkit.getOnlinePlayers()) sendMessage(p, message, MessageType.SUBTLE, override);
			default:
				break;
			}
		} else {
			return;
		}
	}
	
	/**
	 * Send a Chat Message to the Specified Player.
	 * @param player    Player to send the message to.
	 * @param message   Message to be sent.
	 * @param type      Type of message to be sent.
	 * @param override  Should this be sent even if user is isolated?
	 */
	public void sendMessage(Player player, String message, MessageType type, boolean override) {
		if (override || (!globalmute)) {
			switch (type) {
			case WARNING:
				player.sendMessage(ChatColor.DARK_RED + "!!! " + ChatColor.RED + message + ChatColor.DARK_RED + " !!!");
				break;
			case CAUTION:
				player.sendMessage(ChatColor.GOLD + "!!! " + ChatColor.RED + message + ChatColor.GOLD + " !!!");
				break;
			case INFO:
				player.sendMessage(ChatColor.DARK_BLUE + "!!! " + ChatColor.BLUE + message + ChatColor.DARK_BLUE + " !!!");
				break;
			case SUCCESS:
				player.sendMessage(ChatColor.DARK_GREEN + "!!! " + ChatColor.GREEN + message + ChatColor.DARK_GREEN + " !!!");
				break;
			case ABSTRACT:
				player.sendMessage(ChatColor.DARK_PURPLE + "!!! " + ChatColor.LIGHT_PURPLE + message + ChatColor.DARK_PURPLE + " !!!");
				break;
			case SUBTLE:
				player.sendMessage(ChatColor.DARK_GRAY + "!!! " + ChatColor.GRAY + message + ChatColor.DARK_GRAY + " !!!");
			default:
				break;
			}
		} else {
			return;
		}
	}
	
	public void lineBreak(Player p) {
		p.sendMessage(ChatColor.RESET + "");
	}
	
}
