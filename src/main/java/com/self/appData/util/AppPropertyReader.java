package com.self.appData.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class AppPropertyReader {

	public static AppDataConfig readFromProperty() {
		Properties props = new Properties();
		InputStream input = null;
		AppDataConfig appConf = new AppDataConfig();;
		try{
			input = new FileInputStream("appConf.properties");
			props.load(input);
			
			appConf.setJdbcUrl(props.getProperty("jdbcUrl"));
			appConf.setAppSchema(props.getProperty("schema"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return appConf;
	}
}
