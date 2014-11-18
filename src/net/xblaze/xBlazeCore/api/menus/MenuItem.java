package net.xblaze.xBlazeCore.api.menus;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MenuItem extends ItemStack {
	public MenuItem(String name, Material material, String dothisonclick) {
		this.getItemMeta().setDisplayName(name);
		this.setType(material);
	}
}
