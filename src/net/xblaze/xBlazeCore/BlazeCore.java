package net.xblaze.xBlazeCore;

import net.xblaze.xBlazeCore.api.nms.NmsManager;
import net.xblaze.xBlazeCore.api.types.ConsoleMessageType;
import net.xblaze.xBlazeCore.api.util.BungeeManager;
import net.xblaze.xBlazeCore.api.util.ConsoleManager;
import net.xblaze.xBlazeCore.api.util.DebugManager;
import net.xblaze.xBlazeCore.api.util.InventoryManager;
import net.xblaze.xBlazeCore.api.util.ItemManager;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class BlazeCore extends JavaPlugin implements Listener {
	
	/* Hook the xBlazeCore API. */
	public ConsoleManager console = new ConsoleManager(this);
	public DebugManager debugger = new DebugManager(this);
	public InventoryManager invman = new InventoryManager();
	public ItemManager itemman = new ItemManager();
	public BungeeManager bungeemanager = new BungeeManager(this);
		
	/*
	 * Create Local Instances.
	 */	
    public NmsManager nmsman = new NmsManager();
	public LansingOS LansingOS = new LansingOS(this);
		
	@Override
	public void onEnable() {
		Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		Bukkit.getServer().getPluginManager().registerEvents(new EventHandlers(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new CommandInterpreter(this), this);
		/*
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
		*/
		console.log(ConsoleMessageType.INFO, "Enabled Successfully...");
	}
	
	@Override
	public void onDisable() { console.log(ConsoleMessageType.INFO, "Disabled Successfully...");	}
	
}
