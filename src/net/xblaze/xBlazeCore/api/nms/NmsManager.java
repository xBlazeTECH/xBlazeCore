package net.xblaze.xBlazeCore.api.nms;

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
