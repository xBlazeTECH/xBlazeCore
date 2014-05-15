package net.xblaze.xBlazeCore.api.util;

import java.util.ArrayList;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;

public class MenuManager {
	
	public void set(Material material, Inventory menu, int slot, String name, String lore) {
		set(new ItemStack(material), menu, slot, name, lore);
	}
	
	public void set(DyeColor color, Inventory menu, int slot, String name, String lore) {
    	Wool hi = new Wool();
    	hi.setColor(color);
    	set(hi.toItemStack(), menu, slot, name, lore);    	
	}
	
	public void set(ItemStack item, Inventory menu, int slot, String name, String lore) {
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(name);
    	ArrayList<String> Lore = new ArrayList<String>();
    	Lore.add(lore);
    	meta.setLore(Lore);
    	item.setItemMeta(meta);
    	menu.setItem(slot, item);
	}
	
	public void setSlot(Material material, Inventory menu, int slot, String name, String lore) {
		
	}
	
	/**
	 * Clears the specified menu slot.
	 * @param  inv  The menu that contains the slot.
	 * @param  slot The slot of the inventory to clear.
	 */
	public static void clearSlot(Inventory inv, int slot) {
		inv.setItem(slot, new ItemStack(Material.AIR));
	}
}
