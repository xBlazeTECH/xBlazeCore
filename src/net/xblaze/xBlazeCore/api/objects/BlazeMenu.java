package net.xblaze.xBlazeCore.api.objects;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class BlazeMenu implements Inventory {
	
	public BlazeMenu(int size, String title) {

	}
	
	public void setOption(int slot, BlazeMenuOption option) {
    	this.setItem(slot, option);
	}
	
	public void clearOption(int slot) {
		this.setItem(slot, new ItemStack(Material.AIR));
	}
	
	public void show(Player p) {
		p.openInventory(this);
	}
	
}
