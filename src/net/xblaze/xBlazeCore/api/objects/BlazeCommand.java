package net.xblaze.xBlazeCore.api.objects;

public class BlazeCommand {
	
	private String label;
	private BlazeCommandExecutor exec;
	
	public BlazeCommand(String label, BlazeCommandExecutor exec) {
		this.setLabel(label);
		this.setExec(exec);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public BlazeCommandExecutor getExec() {
		return exec;
	}

	public void setExec(BlazeCommandExecutor exec) {
		this.exec = exec;
	}
	
}
