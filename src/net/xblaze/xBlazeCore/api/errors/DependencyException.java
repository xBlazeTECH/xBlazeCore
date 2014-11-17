package net.xblaze.xBlazeCore.api.errors;

import org.bukkit.Bukkit;
import net.xblaze.xBlazeCore.api.errors.types.DependencyExceptionType;

public class DependencyException extends Throwable {

	private static final long serialVersionUID = 131764943529602262L;
	
	public DependencyException(DependencyExceptionType exception, String message) {
		switch (exception) {
		case NOT_FOUND:
			Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("xBlazeCore"), new DebugMessageRepeater("CRITICALLY REQUIRED PLUGIN NOT FOUND: " + message) , 120, 120);
			break;
		case VERSION_MISMATCH:
			Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("xBlazeCore"), new DebugMessageRepeater("CRITICALLY REQUIRED PLUGIN IN WRONG VERSION: " + message) , 120, 120);
			break;
		default:
			break;
		}
	}
}
