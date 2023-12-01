package com.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	
	private static final String PROPERTY_FILE_PATH = "C:\\\\Users\\\\RAM\\\\Desktop\\\\Adnabu\\\\src\\\\test\\\\java\\\\com\\\\helper\\\\Adnabu.property"; // Update this path
	static Properties ps;
	
	  public ConfigurationReader() throws IOException {
	        File f = new File(PROPERTY_FILE_PATH);
	        FileInputStream fis = new FileInputStream(f);
	        ps = new Properties();
	        ps.load(fis);
	    }

	public String getBrowser() {
		String browser = ps.getProperty("Browser");
		return browser;
	}

	public String getAddress() {
		String url = ps.getProperty("Url");
		return url;
	}


	public String getKeyWord() {
		String keyWord = ps.getProperty("KeyWord");
		return keyWord;
	}
	
	public String getFiterOption() {
		String fiterOption = ps.getProperty("FiterOption");
		return fiterOption;
	}

}
