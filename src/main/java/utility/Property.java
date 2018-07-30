package utility;

import java.io.IOException;
import java.util.Properties;

public class Property {

    public static String getProperty(String file, String key) {
        Properties property = new Properties();
        try {
            property.load(ClassLoader.getSystemResourceAsStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return property.getProperty(key);
    }
}