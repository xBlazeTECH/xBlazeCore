package net.xblaze.xBlazeCore.api.util;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.SpawnEgg;
import org.bukkit.material.Wool;

public class ItemManager {
	
	/**
	 * Get a Skull of the Specified Skull Type
	 * @param type  Skull Type of the Skull
	 * @return  Returns the Skull as an ItemStack
	 */
	public ItemStack getSkull(SkullType type) {
		return new ItemStack(Material.SKULL_ITEM, 1, (short) type.ordinal());
	}
	
	/**
	 * Get a Spawn Egg of the Specified Entity Type.
	 * @param type  Entity Type of the Spawn Egg
	 * @return  Return the Spawn Egg as an Item Stack
	 */
	public ItemStack getSpawnEgg(EntityType type) {
		SpawnEgg i = new SpawnEgg();
		i.setSpawnedType(type);
		return i.toItemStack();	
	}
	
	/**
	 * Get wool of the specified color. 
	 * @param color  The color of wool to get 
	 * @return  Return the Wool as an Item Stack
	 */
	public ItemStack getWool(DyeColor color) {
		Wool i = new Wool();
		i.setColor(color);
		return i.toItemStack();	
	}
	
}
