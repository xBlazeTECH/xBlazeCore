package net.xblaze.xBlazeCore.api.nms.v1_7_R3;

import net.xblaze.xBlazeCore.api.nms.GenericFancyMessage;
import net.xblaze.xBlazeCore.api.nms.GenericNmsManager;

public class NmsManager implements GenericNmsManager {

	@Override
	public GenericFancyMessage newFancyMessage(String text) {
		return new FancyMessage(text);
	}

	@Override
	public boolean hasChatHoverFeature() {
		return true;
	}
	
}
