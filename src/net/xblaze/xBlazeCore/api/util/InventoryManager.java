package net.xblaze.xBlazeCore.api.util;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryManager {
	
	/**
	 * Replace the item in the Players hand with the specified Item Stack
	 * @param p  Player whose inventory to manipulate.
	 * @param item  Item Stack to place in player's hand
	 */
	public void hold(Player p, ItemStack item) {
		try {
			ItemStack last = p.getItemInHand();
			p.setItemInHand(item);
			p.getInventory().addItem(last);
		} catch (NullPointerException ignore) {
			p.setItemInHand(item);
		}
	}
	
	/**
	 * Replace the item in the Player's hand with
	 * @param p  Player whose inventory to manipulate.
	 * @param slot  Slot to put the item in.
	 * @param item  Item to replace.
	 */
	public void replace(Player p, int slot, ItemStack item) {
		try {
			ItemStack last = p.getInventory().getItem(slot);
			p.getInventory().setItem(slot, item);
			if (last.equals(item)) return;
			p.getInventory().addItem(last);
		} catch (NullPointerException ignore) {
			p.getInventory().setItem(slot, item);
		}
		
	}
}
