package net.xblaze.xBlazeCore.api.menus;

import org.bukkit.DyeColor;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;

public interface GenericMenuObject {
		public GenericMenuObject title(final String title);
		
		public GenericMenuObject rows(final int rows);

		public GenericMenuObject additem(final MenuItem... item);
		
		public GenericMenuObject addskull(final SkullType skull);
		
		public GenericMenuObject addwool(final DyeColor dyecolor);
		
		public void openMenu(Player p);
		
}
