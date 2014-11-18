package net.xblaze.xBlazeCore;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class LansingOS {
	private BlazeCore plugin;
	private String version;
	public boolean enabled = true;

	public LansingOS (BlazeCore plugin) {
		this.plugin = plugin;
		this.version = "1.0.0";
	}

	public String getVersion() {
		return version;
	}
	
	public void login(Player p) {
		p.sendMessage(ChatColor.GRAY + "===== LansingOS " + this.getVersion() + " =====");
		p.sendMessage(ChatColor.GRAY + "Welcome to LansingOS " + p.getName() + "!");
		p.sendMessage(ChatColor.GRAY + " * Documentation: https://github.com/xBlazeTECH/xBlazeCore");
		p.sendMessage(ChatColor.GRAY + "** LansingOS currently only works on Debian hosted servers.");
		// Release Check Goes here! "New Release '1.0.1' is available. \n Run /term to upgrade to it."
		p.sendMessage(ChatColor.GRAY + "Host: " + p.getAddress().getHostName());
		p.sendMessage(ChatColor.GRAY + "To Logout and reenable chat, please type 'logout'");
		p.sendMessage(ChatColor.GRAY + p.getName() + "@LansingOS:/# ");
		p.setMetadata("term", new FixedMetadataValue(plugin, true));
	}

	public void command(Player p, String command) {
		p.sendMessage(ChatColor.GRAY + p.getName() + "@xBlazeOS:/# ");
		if(command.equalsIgnoreCase("help")) {
			p.sendMessage(ChatColor.GRAY + "Commands: dlplug,logout");
			return;
		} else {
			for (String str : executeCmd(command)) {
				p.sendMessage(ChatColor.GRAY + str);
			}
		}
	}
	
	public List<String> executeCmd(String command) {
		List<String> reply = new ArrayList<String>();
		try {
			Process proc;
			proc = Runtime.getRuntime().exec(command);
			proc.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line = "";
			while ((line = reader.readLine()) != null) { 
				reply.add(line); 
			}
		} catch (Exception e) {
			reply.add(e.getCause().getMessage());
			reply.add("Error Occured While Executing!");
		}
		return reply;
	}
}
