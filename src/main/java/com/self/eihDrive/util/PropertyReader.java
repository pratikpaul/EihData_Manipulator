package com.self.eihDrive.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	public static EihAppConfiguration readFromProperty() {
		Properties props = new Properties();
		InputStream input = null;
		EihAppConfiguration appConf = new EihAppConfiguration();;
		try{
			input = new FileInputStream("eihConf.properties");
			props.load(input);
			
			appConf.setJdbcUrl(props.getProperty("jdbcUrl"));
			appConf.setSchema(props.getProperty("schema"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return appConf;
	}
}
