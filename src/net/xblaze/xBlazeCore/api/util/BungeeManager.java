package net.xblaze.xBlazeCore.api.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class BungeeManager {
	
	public Plugin plugin;
	public BungeeManager(Plugin plugin) {
		this.plugin = plugin;
	}
	
	public void sendPlayerToServer(Player p, String server) {
		  ByteArrayOutputStream b = new ByteArrayOutputStream();
		  DataOutputStream out = new DataOutputStream(b);
		  try {
			  out.writeUTF("Connect");
			  out.writeUTF(server);
			  p.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
		  } catch (Exception e) {
			  Bukkit.broadcast("Byte Error!", "xblaze.core.debug");
		  }
	}
}
