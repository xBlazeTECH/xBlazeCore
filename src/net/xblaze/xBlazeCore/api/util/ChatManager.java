package net.xblaze.xBlazeCore.api.util;

import net.xblaze.xBlazeCore.api.types.MessageType;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatManager {
	
	public Boolean globalmute;
	
	public void broadcast(String message, MessageType type, boolean override) {
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
		}
		return;
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
				player.sendMessage(ChatColor.DARK_BLUE + "[" + ChatColor.GREEN + "x" + ChatColor.DARK_BLUE + "]" + ChatColor.RED + message);
				break;
			case CAUTION:
				player.sendMessage(ChatColor.DARK_BLUE + "[" + ChatColor.GREEN + "x" + ChatColor.DARK_BLUE + "]" + ChatColor.GOLD + message);
				break;
			case INFO:
				player.sendMessage(ChatColor.DARK_BLUE + "[" + ChatColor.GREEN + "x" + ChatColor.DARK_BLUE + "]" + ChatColor.DARK_BLUE + message);
				break;
			case SUCCESS:
				player.sendMessage(ChatColor.DARK_BLUE + "[" + ChatColor.GREEN + "x" + ChatColor.DARK_BLUE + "]" + ChatColor.DARK_GREEN + message);
				break;
			case ABSTRACT:
				player.sendMessage(ChatColor.DARK_BLUE + "[" + ChatColor.GREEN + "x" + ChatColor.DARK_BLUE + "]" + ChatColor.LIGHT_PURPLE + message);
				break;
			case SUBTLE:
				player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GRAY + "x" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + message);
				break;
			default:
				break;
			}
		}
		return;
	}
	public void lineBreak(Player p) { p.sendMessage(ChatColor.RESET + ""); }
}
