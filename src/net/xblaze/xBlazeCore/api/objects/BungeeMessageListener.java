package net.xblaze.xBlazeCore.api.objects;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
 
public class BungeeMessageListener implements PluginMessageListener  {
	
	   @Override
	    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
	        if (!channel.equals("BungeeCord")) {
	            return;
	        }

	        DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));

	        try {
	            String subchannel = in.readUTF();
	            if (subchannel.equals("SomeSubChannel")) {
	                // Use the code sample in the 'Response' sections below to read
	                // the data.
	            } else if (subchannel.equals("SomeOtherSubChannel")) {
	                // Read the data for a different subchannel.
	            }
	        } catch (IOException e) {
	            // There was an issue in creating the subchannel string
	        }
	    }

}