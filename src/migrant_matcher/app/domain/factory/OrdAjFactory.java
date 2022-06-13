package migrant_matcher.app.domain.factory;

import migrant_matcher.app.Configuration;
import migrant_matcher.app.strategies.OrdAjStrat;

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
        Configuration.getConfiguration().getInstanceOfClass("help_order_strategy", );
        
    }
}
