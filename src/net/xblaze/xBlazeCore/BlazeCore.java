package net.xblaze.xBlazeCore;

import java.util.HashMap;

import net.xblaze.xBlazeCore.events.CommandInterceptor;
import net.xblaze.xBlazeCore.api.nms.v1_7_R2.NmsManager;
import net.xblaze.xBlazeCore.api.util.CommandManager;
import net.xblaze.xBlazeCore.api.util.ConsoleManager;
import net.xblaze.xBlazeCore.api.util.DebugManager;
import net.xblaze.xBlazeCore.api.util.InventoryManager;
import net.xblaze.xBlazeCore.api.util.ItemManager;
import net.xblaze.xBlazeCore.api.util.PlayerMetadataManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class BlazeCore extends JavaPlugin implements Listener {
	
	/*
	 * Hook the xBlazeCore API.
	 */
	public ConsoleManager console = new ConsoleManager();
	public DebugManager debugger = new DebugManager(this);
	public InventoryManager invman = new InventoryManager();
	public PlayerMetadataManager pmetaman = new PlayerMetadataManager();
	public ItemManager itemman = new ItemManager();
	public xBlazeOS BlazeOS = new xBlazeOS(this);
	public HashMap<Player,Boolean> terminalusers = new HashMap<Player,Boolean>();
	
	/*
	 * Create Local Instances.
	 */	
    public NmsManager nmsman = new NmsManager();
		
	@Override
	public void onEnable() {
		console.logInfo(this, " Plugin has been loaded sucessfully!");
		Bukkit.getServer().getPluginManager().registerEvents(new EventHandlers(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CommandInterpreter(this), this);
	}
	
	@Override
	public void onDisable() {
		console.logInfo(this, " Plugin has been disabled sucessfully!");
	}
	
	public void disableSelf() {
		Bukkit.getPluginManager().disablePlugin(this);
	}
	
	public void enableSelf() {
		Bukkit.getPluginManager().enablePlugin(this);
	}
	
}
