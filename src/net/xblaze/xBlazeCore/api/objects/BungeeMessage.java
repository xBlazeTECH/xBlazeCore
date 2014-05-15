package net.xblaze.xBlazeCore.api.objects;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.xblaze.xBlazeCore.api.types.BungeeMessageType;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class BungeeMessage {
	
	ByteArrayOutputStream b;
	DataOutputStream out;
	Plugin providingPlugin;
	
	public BungeeMessage(Plugin plugin, BungeeMessageType type) {
		this.providingPlugin = plugin;
		b = new ByteArrayOutputStream();
		out = new DataOutputStream(b);
	}
	
	public void addArg(String arg) throws IOException {
		out.writeUTF(arg);
	}
	
	public void send() {
		Player p = Bukkit.getOnlinePlayers()[0];
		p.sendPluginMessage(providingPlugin, "BungeeCord", b.toByteArray());
	}
	
	public void send(Player p) {
		p.sendPluginMessage(providingPlugin, "BungeeCord", b.toByteArray());
	}
	
	// If the player is important :
	// OR, if you don't need to send it to a specific player
	Player p = Bukkit.getOnlinePlayers()[0];
	
	
}
