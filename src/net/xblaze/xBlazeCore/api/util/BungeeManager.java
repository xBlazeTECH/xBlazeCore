package net.xblaze.xBlazeCore.api.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.xblaze.xBlazeCore.BlazeCore;

public class BungeeManager {
	
	public BlazeCore plugin;
	
	public BungeeManager(BlazeCore plugin) {
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
		   p.sendMessage(ChatColor.RED + "Looks like there was a problem sending you to the server you wanted to go to! :O");
		  }
	}
	
	
}
