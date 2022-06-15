package migrant_matcher.app.facade;

import migrant_matcher.app.domain.Migrante;
import migrant_matcher.app.handlers.PedirAjudaHandler;

public class MSession {
    
    private Migrante migrante;

    public MSession(Migrante migrante) {
        this.migrante = migrante;  
    }

    public PedirAjudaHandler getPedirAjudaHandler() {
        return new PedirAjudaHandler(migrante);
    }
    
}