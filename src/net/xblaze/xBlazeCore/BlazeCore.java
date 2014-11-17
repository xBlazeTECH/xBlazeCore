package net.xblaze.xBlazeCore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.xblaze.xBlazeCore.api.nms.v1_7_R2.NmsManager;
import net.xblaze.xBlazeCore.api.util.ConfigurationManager;
import net.xblaze.xBlazeCore.api.util.ConsoleManager;
import net.xblaze.xBlazeCore.api.util.DebugManager;
import net.xblaze.xBlazeCore.api.util.InventoryManager;
import net.xblaze.xBlazeCore.api.util.ItemManager;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.parser.ParseException;

public class BlazeCore extends JavaPlugin implements Listener {
	
	/*
	 * Hook the xBlazeCore API.
	 */
	public ConsoleManager console = new ConsoleManager();
	public DebugManager debugger = new DebugManager(this);
	public InventoryManager invman = new InventoryManager();
	public ItemManager itemman = new ItemManager();
	public ConfigurationManager configman = new ConfigurationManager();
		
	/*
	 * Create Local Instances.
	 */	
    public NmsManager nmsman = new NmsManager();
	public xBlazeOS BlazeOS = new xBlazeOS(this);
		
	@Override
	public void onEnable() {
		configman.onPluginEnable(this);
		Bukkit.getServer().getPluginManager().registerEvents(new EventHandlers(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CommandInterpreter(this), this);
		try {
			configman.getString(this, "/data/config.json", "text");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		console.logInfo(this, " Plugin has been loaded sucessfully!");
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
	
	public void firstRun() {
		
	}
	
}
