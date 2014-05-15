package net.xblaze.xBlazeCore.api.util;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import net.xblaze.xBlazeCore.BlazeCore;

public class PlayerMetadataManager {
	private static BlazeCore plugin;
	
	/**
	 * Add the specified Metadata to the Player
	 * @param player  The player that is being manipulated.
	 * @param identifier  The name of the metadata to add.
	 * @param value  The value to set for the metadata
	 */
	public void addMeta(Player player, String identifier, Object value) {
        player.setMetadata(identifier, new FixedMetadataValue(plugin, value));
	}
	
	/**
	 * Removes the specified Metadata from the Player
	 * @param player  The player that is being manipulated.
	 * @param identifier  The name of the metadata to add.
	 */
	public void removeMeta(Player player, String identifier) {
		player.removeMetadata(identifier, plugin);
	}
	
	/**
	 * Checks to see if the player has the specified Metadata
	 * @param player  The player that is being checked.
	 * @param identifier  The name of the metadata to check for.
	 * @return  Returns true if found, and false if not.
	 */
	public boolean hasMeta(Player player, String identifier) {
		if (player.hasMetadata(identifier)) return true;
		return false;
	}
	
	public List<MetadataValue> getMeta(Player player, String identifier) {
		List<MetadataValue> meta = player.getMetadata(identifier);
		return meta;
	}
	
	
	

}
