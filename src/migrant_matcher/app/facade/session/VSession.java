package migrant_matcher.app.facade.session;

import migrant_matcher.app.domain.Voluntario;
import migrant_matcher.app.domain.catalogos.CatalogoVoluntario;
import migrant_matcher.app.facade.dto.VolDTO;
import migrant_matcher.app.facade.handlers.OferecerAjudaHandler;

public class VSession {

    private Voluntario voluntario;

    private VSession(Voluntario voluntario) {
        this.voluntario = voluntario;  
    }

    public OferecerAjudaHandler getOferecerAjudaHandler() {
        return new OferecerAjudaHandler(voluntario);
    }

    public static VSession reconhecerVoluntario(VolDTO voluntario) {
        if(CatalogoVoluntario.getInstance().voluntarioExistente(voluntario)) {
            return new VSession(CatalogoVoluntario.getInstance().getVoluntario(voluntario));
        }
        return new VSession(CatalogoVoluntario.getInstance().adicionarVoluntario(new Voluntario(voluntario.getNrTelefone())));
    }



}