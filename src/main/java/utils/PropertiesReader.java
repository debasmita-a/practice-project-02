package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertiesReader {
	
	private PropertiesReader() {}
	
	static Properties prop = new Properties();
	static Map<String, String> CONFIG_MAP = new HashMap<>();
	
	static {
		try {
			FileInputStream inputFile = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(inputFile);
			for(Map.Entry<Object, Object> entry : prop.entrySet()) {
				CONFIG_MAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String key) {
		if(Objects.isNull(key) || Objects.isNull(CONFIG_MAP.get(key))) {
			System.out.println("Value for the key " + key + " is not availble in the config.properties file.");
		}
		return CONFIG_MAP.get(key);
	}
}
