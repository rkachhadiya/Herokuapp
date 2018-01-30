package Herokuapp.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Baseclass {

	
	public static String getPropertyvalue(String key, String path) throws FileNotFoundException {
		String value = null;
		Properties prop1 = new Properties();
		// String path1 = "./resources/elementsPath.properties";

		try {
			prop1.load(new FileInputStream(path));
			value = prop1.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}
}
