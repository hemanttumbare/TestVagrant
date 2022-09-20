package com.testvagrant.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utilities {

	public Properties loadPropertiesFile(String filePath) {

		FileReader reader;
		Properties prop = new Properties();

		try {
			reader = new FileReader(filePath);
			prop.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

}
