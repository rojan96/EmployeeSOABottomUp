package com.imcs.bu.singleton;

import java.util.ResourceBundle;

public class ApplicationProperties {

	static ApplicationProperties instance = null;
	ResourceBundle props = null;
	
	private ApplicationProperties() {
		props = ResourceBundle.getBundle("AppConfig");
		
	}

	public static ApplicationProperties getInstance() {
		if (instance == null)
			instance = new ApplicationProperties();
		
		return instance;
	}
	
	public String getProperty(String key) {
		return props.getString(key);
	}
}
