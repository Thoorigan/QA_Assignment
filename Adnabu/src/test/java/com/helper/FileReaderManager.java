package com.helper;

import java.io.IOException;

public class FileReaderManager {
	private FileReaderManager() {
		
	}

	public static FileReaderManager getInstance() {
		FileReaderManager frm= new FileReaderManager();
		return frm;
	}
	
	public ConfigurationReader getcrInstance() throws IOException {
		ConfigurationReader cr =  new ConfigurationReader();
		return cr;
	}

}
