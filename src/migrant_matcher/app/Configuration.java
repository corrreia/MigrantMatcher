package migrant_matcher.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Configuration {
    private static Configuration INSTANCE;

    private Properties properties = new Properties();

    public static Configuration getConfiguration() {
        if (INSTANCE == null) 
            INSTANCE = new Configuration();
        return INSTANCE;
    }

    private Configuration() {
        try{
            properties.load(new FileInputStream("/config.properties"));
        }   catch (IOException e) {
            System.out.println("Erro ao carregar arquivo config.properties");
        }
    }

    public int getInt(String key, int defaultValue){
        try{
            return Integer.parseInt(properties.getProperty(key));
        }   catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public String getString(String key, String defaultValue){
        return properties.getProperty(key, defaultValue);
    }

    public <T> T getInstanceOfClass(String key, T defaultValue) {
		String klassName = (String) properties.get(key);
		if (klassName == null) {
			return defaultValue;
		}
		
		try {
			@SuppressWarnings("unchecked")
			Class<T> klass = (Class<T>) Class.forName(klassName);
			Constructor<T> c = klass.getConstructor();
			return c.newInstance();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return defaultValue;
	}

}
