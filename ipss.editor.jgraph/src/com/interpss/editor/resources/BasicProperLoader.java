package com.interpss.editor.resources;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasicProperLoader {

	private static Properties appProps = new Properties();

	static {
		try {
			java.io.FileInputStream in = new java.io.FileInputStream(
					"properties/editor.properties");
			appProps.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static String getString (final String sKey){
		return appProps.getProperty(sKey, null);
	}
	
}
