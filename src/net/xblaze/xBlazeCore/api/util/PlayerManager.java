package net.xblaze.xBlazeCore.api.util;

import net.xblaze.xBlazeCore.api.types.MessageType;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PlayerManager {
	public Plugin pl;
	public ChatManager cm;
	public PlayerManager(Plugin p) {
		this.pl = p;
	}
	
	public void message(Player p, String msg, MessageType type, boolean override) {
		cm.sendMessage(p, msg, type, override);
	}
}
