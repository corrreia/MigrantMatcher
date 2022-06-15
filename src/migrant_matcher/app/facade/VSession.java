package migrant_matcher.app.facade;

import migrant_matcher.app.domain.Voluntario;
import migrant_matcher.app.handlers.OferecerAjudaHandler;

public class VSession {

    private Voluntario voluntario;

    public VSession(Voluntario voluntario) {
        this.voluntario = voluntario;  
    }

    public OferecerAjudaHandler getOferecerAjudaHandler() {
        return new OferecerAjudaHandler(voluntario);
    }

}