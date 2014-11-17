package net.xblaze.xBlazeCore;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class xBlazeOS {
	private BlazeCore plugin;
	private String version;

	public xBlazeOS (BlazeCore plugin) {
		this.plugin = plugin;
		this.version = "0.1.1";
	}

	public String getVersion() {
		return version;
	}
	
	public void login(Player p) {
		p.sendMessage(ChatColor.GRAY + "======== Now Entering xBlazeOS ========");
		p.sendMessage(ChatColor.GRAY + "Using Username '" + p.getName() + "'");
		p.sendMessage(ChatColor.GRAY + p.getName() + " has permission to login!");
		p.sendMessage(ChatColor.GRAY + "Welcome to xBlazeOS " + this.getVersion() + "!");
		p.sendMessage(ChatColor.GRAY + " * Documentation: https://xblaze.net/xBlazeOS");
		// Release Check Goes here! "New Release '1.0' is availible. \n Run /term to upgrade to it."
		p.sendMessage(ChatColor.GRAY + "Host: " + p.getAddress().getHostString());
		p.sendMessage(ChatColor.GRAY + "To Logout, please type 'logout'");
		p.sendMessage(ChatColor.GRAY + p.getName() + "@xBlazeOS:/# ");
		p.setMetadata("term", new FixedMetadataValue(plugin, true));
	}

	public void command(Player p, String command) {
		if (command.startsWith("dlplug")) {
			command.replaceAll("dlplug ", "");
			try {
				Process proc;
				proc = Runtime.getRuntime().exec("wget -N --directory-prefix=plugins " + command);
				proc.waitFor();
				BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				String line = "";
				while ((line = reader.readLine()) != null) {
					p.sendMessage(ChatColor.GRAY + line);
				}
				p.sendMessage(ChatColor.GRAY + p.getName() + "@xBlazeOS:/# ");
				return;
			} catch (Exception e) {
				p.sendMessage(e.getCause().getMessage());
				p.sendMessage("Error Occured While Executing!");
			}
		} else if (command.startsWith("help")) {
			p.sendMessage(ChatColor.GRAY + "Commands: dlplug,logout");
		} else {
			Process proc;
			try {
				proc = Runtime.getRuntime().exec(command);
				proc.waitFor();
				BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				String line = "";
				while ((line = reader.readLine()) != null) {
					p.sendMessage(ChatColor.GRAY + line);
				}
				p.sendMessage(ChatColor.GRAY + p.getName() + "@xBlazeOS:/# ");
				return;
			} catch (Exception e) {
				p.sendMessage(e.getCause().getMessage());
				p.sendMessage("Error Occured While Executing!");
			}
		}

	}

}
