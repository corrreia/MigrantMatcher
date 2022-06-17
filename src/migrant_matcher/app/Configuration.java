package migrant_matcher.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * A classe {@code Configuration} que representa
 * a configuração do sistema.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class Configuration {
    private static Configuration INSTANCE;

    private Properties properties = new Properties();

    
	/** 
	 * Returna a configuração do sistema
	 * 
	 * @return Configuration
	 */
	public static Configuration getConfiguration() {
        if (INSTANCE == null) 
            INSTANCE = new Configuration();
        return INSTANCE;
    }

	/**
	 * Construtor privado da Configuration
	 */
    private Configuration() {
        try{
            properties.load(new FileInputStream("C:\\Users\\tomas\\Desktop\\MigrantMatcher\\src\\migrant_matcher\\app\\config.properties"));
        }   catch (IOException e) {
            System.out.println("Erro ao carregar arquivo config.properties");
        }
    }

    
	/** 
	 * Retorna algum inteiro que esteja presente no ficheiro
	 * de configuração
	 * 
	 * @param key			- Chave do valor a ser retornado
	 * @param defaultValue	- Valor a ser retornado caso não exista a chave
	 * @return int			- Inteiro no ficheiro de configuração
	 */
	public int getInt(String key, int defaultValue){
        try{
            return Integer.parseInt(properties.getProperty(key));
        }   catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    
	/** 
	 * Retorna uma String que esteja presente no ficheiro
	 * 
	 * @param key			- Retirado do ficheiro de configuração
	 * @param defaultValue	- Valor a ser retornado caso não exista a chave
	 * @return String		- String retirada do ficheiro de configuração
	 */
	public String getString(String key, String defaultValue){
        return properties.getProperty(key, defaultValue);
    }

    
	/** 
	 * Retorna a instancia da classe
	 * 
	 * @param key			- Chave do valor a ser retornado
	 * @param defaultValue	- Valor a ser retornado caso não exista a chave
	 * @return T			- Instancia da classe retirada do ficheiro de configuração
	 */
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
