package net.xblaze.xBlazeCore.api.objects;

import java.util.ArrayList;

import net.xblaze.xBlazeCore.api.util.ItemManager;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlazeMenuOption extends ItemStack {
	private static ItemManager itemman = new ItemManager();
	
	public BlazeMenuOption(ItemStack item, String name, String lore) {
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(name);
    	ArrayList<String> Lore = new ArrayList<String>();
    	Lore.add(lore);
    	meta.setLore(Lore);
    	item.setItemMeta(meta);
	}
	
	public BlazeMenuOption(Material mat, String name, String lore) {
		this(new ItemStack(mat), name, lore);
	}
	
	public BlazeMenuOption(DyeColor color, String name, String lore) {
		this(itemman.getWool(color), name, lore);
	}
	
}
