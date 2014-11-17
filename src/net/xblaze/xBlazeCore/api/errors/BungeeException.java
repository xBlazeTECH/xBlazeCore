package net.xblaze.xBlazeCore.api.errors;

import org.bukkit.Bukkit;

public class BungeeException extends Throwable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2033986831187732388L;

	public BungeeException(String description) {
		Bukkit.broadcast(description, "xblaze.debug");
	}
}
