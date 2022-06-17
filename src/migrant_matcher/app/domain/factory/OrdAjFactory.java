package migrant_matcher.app.domain.factory;

import java.lang.reflect.Constructor;

import migrant_matcher.app.Configuration;
import migrant_matcher.app.strategies.ord.OrdAjAscDate;
import migrant_matcher.app.strategies.ord.OrdAjStrat;

/**
 * A classe {@code OrdAjFactory} usa o padrão Factory 
 * para criar estratégias de ordenação 
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372 
 */
public class OrdAjFactory {
    //singleton constructor
    private static OrdAjFactory INSTANCE = null;

    /**
     * Construtor privado da classe {@code OrdAjFactory}
     */
    private OrdAjFactory() {
    }

    
    /** 
     * Construtor que retorna uma instancia de OrdAjFactory
     * 
     * @return OrdAjFactory  instância da classe {@code OrdAjFactory}
     */
    public static OrdAjFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OrdAjFactory();
        }
        return INSTANCE;
    }

    
    /** 
     * Construtor que cria uma estratégia de ordenação
     * 
     * @return OrdAjStrat   instância da classe {@code OrdAjStrat}
     */
    public OrdAjStrat getOrdAjStrat() {
        return Configuration.getConfiguration().getInstanceOfClass("help_order_strategy", new OrdAjAscDate()); 
    }

    
    /** 
     * Construtor do objeto do Tipo OrdAjStrat que que recebe um nome de classe
     * 
     * @param null          nome da classe
     * @return OrdAjStrat   instância da classe {@code OrdAjStrat}
     */
    public <T> OrdAjStrat getOrdAjStrat(String klassName) {  //used for tests
		if (klassName == null) {
			return new OrdAjAscDate();
		}
		
		try {
			@SuppressWarnings("unchecked")
			Class<T> klass = (Class<T>) Class.forName(klassName);
			Constructor<T> c = klass.getConstructor();
			return (OrdAjStrat) c.newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new OrdAjAscDate();
	}
}
