package net.xblaze.xBlazeCore.events;

import net.xblaze.xBlazeCore.BlazeCore;
import net.xblaze.xBlazeCore.api.nms.v1_7_R2.NmsManager;
import net.xblaze.xBlazeCore.api.util.DebugManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandInterceptor implements Listener {
	
	private NmsManager nmsman;
	private DebugManager debugger;
	
	public CommandInterceptor(BlazeCore pl) {
		this.nmsman = pl.nmsman;
		this.debugger = pl.debugger;
	}
	
	public void sendHelp(Player p, String command, String usage, String desc) {
		if (usage != null) {
			usage = " " + usage;
			nmsman.newFancyMessage("")
			.then(command + ChatColor.GRAY + " " + usage)
				.color(ChatColor.GOLD)
				.suggest(command + usage)
				.tooltip("§bClick for Example!")
			.then(ChatColor.DARK_GRAY + " - " + ChatColor.GREEN + desc)
			.send(p);
		} else {
			nmsman.newFancyMessage(ChatColor.GOLD + command + ChatColor.GRAY + " - " + ChatColor.GREEN + desc)
			.command(command)
			.tooltip("§bClick to Execute!")
			.send(p);
		}
    }
	
	@EventHandler
	public void onCommandExecuted(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		String[] args = msg.split(" ");
		String cmd = args[0];
		
		if (cmd.equalsIgnoreCase("/debug")) {
			if (p.hasPermission("xblaze.core.dev")) {
				if (debugger.isDebugging(p)) debugger.startDebugging(p);
				if (!debugger.isDebugging(p)) debugger.stopDebugging(p);
			} else {
				p.sendMessage("You are not allowed to debug");
			}
			e.setCancelled(true);
			return;
		}
	}
	
}
