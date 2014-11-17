package net.xblaze.xBlazeCore.api.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import net.xblaze.xBlazeCore.api.objects.FileMaker;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConfigurationManager {

	public ConsoleManager conman = new ConsoleManager();
	private FileMaker filemaker = new FileMaker();

	public void setDefaultConfiguration(JSONObject object) {
		object.getJSONArray("");
	}

	public void onPluginEnable(Plugin plugin) {
		File file = new File(plugin.getDataFolder() + "/data/config.json");
		if (fileExists(file)) {
			conman.logInfo(plugin, "We found the file: " + file);
			conman.logInfo(plugin, "No need to recreate it if it is already there!");
		} else {
			try {
				conman.logInfo(plugin, "We were unable to locate the file: " + file);
				conman.logInfo(plugin, "Lets make one now! :D ");
				Process proc1 = Runtime.getRuntime().exec("mkdir " + plugin.getDataFolder());
				proc1.waitFor();
				Process proc2 = Runtime.getRuntime().exec("mkdir " + plugin.getDataFolder() + "/data/");
				proc2.waitFor();
				FileMaker fm = filemaker.newFile(file);
				fm.write("{");
				fm.write("\"data\":\"hi\"");
				fm.sign();
			} catch (IOException | InterruptedException e) {
				conman.logInfo(plugin, "OH NOES! SOMETHING WENT WRONG! :( ");
				conman.logWarning(plugin, e.getMessage());
			}
		}
	}

	public boolean fileExists(File file) {
		try {
			new FileReader(file);
			return true;
		} catch (FileNotFoundException ex) {
			return false;
		}
	}

	public String getString(Plugin plugin, String file, String key) throws FileNotFoundException, IOException, ParseException {
		JSONObject object = this.loadFile(plugin, plugin.getDataFolder() + file);
		return (String) object.get(key);
	}

	private JSONObject loadFile(Plugin plugin, String file) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		return (JSONObject) parser.parse(new FileReader(file));
	}

}
