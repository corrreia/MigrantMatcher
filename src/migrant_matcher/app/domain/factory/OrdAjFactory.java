package migrant_matcher.app.domain.factory;

import java.lang.reflect.Constructor;

import migrant_matcher.app.Configuration;
import migrant_matcher.app.strategies.ord.OrdAjAscDate;
import migrant_matcher.app.strategies.ord.OrdAjStrat;

public class OrdAjFactory {
    //singleton constructor
    private static OrdAjFactory INSTANCE = null;

    private OrdAjFactory() {
    }

    public static OrdAjFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OrdAjFactory();
        }
        return INSTANCE;
    }

    public OrdAjStrat getOrdAjStrat() {
        return Configuration.getConfiguration().getInstanceOfClass("help_order_strategy", new OrdAjAscDate()); 
    }

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
