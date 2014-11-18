package net.xblaze.xBlazeCore;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class EventHandlers implements Listener {

	private BlazeCore plugin;
	private LansingOS LansingOS;
	
	public EventHandlers(BlazeCore plugin) {
		this.plugin = plugin;
		this.LansingOS = plugin.LansingOS;
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		if (p.hasMetadata("term")) {
			e.setCancelled(true);
			if (msg.equalsIgnoreCase("logout")) {
				p.sendMessage(ChatColor.GRAY + "Session in Progress: Terminated!");
				p.removeMetadata("term", plugin);
				return;
			} else {
				LansingOS.command(p, msg);
			}
		}
	}
}
