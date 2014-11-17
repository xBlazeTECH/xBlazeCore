package net.xblaze.xBlazeCore.api.errors;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class DebugMessageRepeater extends BukkitRunnable {
	
	private String message;
	
	public DebugMessageRepeater(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		Bukkit.broadcastMessage(message);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
