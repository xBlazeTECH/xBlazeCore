package net.xblaze.xBlazeCore.api.errors;

public class CommandNotFoundException extends Throwable {
	private static final long serialVersionUID = -2144988919498606464L;
	
	public CommandNotFoundException(String command) {
		super("Cannot find the command: " + command);
	}

}
