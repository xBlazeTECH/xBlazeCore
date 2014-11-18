package net.xblaze.xBlazeCore.api.errors;

import net.xblaze.xBlazeCore.api.errors.types.BungeeExceptionType;

import org.bukkit.entity.Player;

public class BungeeException extends Throwable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2033986831187732388L;

	public BungeeException(BungeeExceptionType type, Player p, String description) {
		switch(type) {
		case ERROR_SENDING_TO_SERVER: 
			p.sendMessage("There was an error sending you to that server.");
		}
	}
}
