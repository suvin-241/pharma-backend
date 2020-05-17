package com.pharma.itsmypharma.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class PharmaResourceBundle {

	private PharmaResourceBundle() {
	}

	private static ResourceBundle resource = null;

	static {
		resource = ResourceBundle.getBundle("PharmaLabels");
	}

	public static String getProperty(String key) {
		return resource.getString(key);
	}

	public static String getProperty(String key, Object[] messageParameters) {

		return MessageFormat.format(resource.getString(key), messageParameters);

	}

}
