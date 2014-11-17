package net.xblaze.xBlazeCore.api.menus;

import java.util.ArrayList;

import org.bukkit.DyeColor;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;

public class MenuObject implements GenericMenuObject {
	
	public String title;
	public int rows;
	public ArrayList<MenuItem> items;
	
	public MenuObject() {
		this.items = new ArrayList<MenuItem>();
		return;
	}

	@Override
	public GenericMenuObject title(String title) {
		this.title = title;
		return this;
	}

	@Override
	public GenericMenuObject rows(int rows) {
		this.rows = rows;
		return this;
	}

	@Override
	public GenericMenuObject additem(MenuItem... items) {
		for (MenuItem item : items) this.items.add(item);
		return this;
	}

	@Override
	public GenericMenuObject addskull(SkullType skull) {
		return this;
	}

	@Override
	public GenericMenuObject addwool(DyeColor dyecolor) {
		return this;
	}

	@Override
	public void openMenu(Player p) {
		
	}
	
}
