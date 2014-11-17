package net.xblaze.xBlazeCore.api.objects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileMaker {
	
	private FileWriter writer;
	private List<String> contents;
	
	public FileMaker newFile(File file) throws IOException {
		this.writer = new FileWriter(file);
		return this;
	}	
	public FileMaker write(String str) throws IOException {
		this.writer.write(str + System.lineSeparator());
		return this;
	}
	
	public void sign() throws IOException {
		this.writer.close();
	}
}
