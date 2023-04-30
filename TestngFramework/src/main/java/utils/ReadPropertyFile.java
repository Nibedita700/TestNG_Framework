package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	

	
	String filename="C:\\Automation\\Workspace\\TestngFramework\\config.properties";
	private Properties prop;


	public Properties readProperties() {
	prop=new Properties();
	try {
		FileInputStream file=new FileInputStream(filename);
		prop.load(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	return prop;
	}
	}


