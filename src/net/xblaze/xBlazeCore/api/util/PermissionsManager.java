package net.xblaze.xBlazeCore.api.util;

import org.bukkit.entity.Player;

public class PermissionsManager {
	
	/**
	 * Checks to see if the player has the specified permission
	 * @param p  Target Player
	 * @param permission  Permission to check for
	 * @return Returns true if the player has the permission.
	 */
	public boolean hasPermission(Player p, String permission) {
		return p.hasPermission(permission);
	}
}
