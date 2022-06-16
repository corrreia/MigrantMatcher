package migrant_matcher.app.facade.session;

import migrant_matcher.app.domain.Familia;
import migrant_matcher.app.domain.Membro;
import migrant_matcher.app.domain.Migrante;
import migrant_matcher.app.domain.catalogos.CatalogoMigrantes;
import migrant_matcher.app.facade.dto.*;
import migrant_matcher.app.facade.handlers.PedirAjudaHandler;

public class MSession {
    
    private Migrante migrante;

    private MSession(Migrante migrante) {
        this.migrante = migrante;  
    }

    public MigDTO getMigrante() {
        return new MigDTO(migrante);
    }

    public FamDTO getFamilia() {
        return new FamDTO((Familia) migrante);
    }


    public PedirAjudaHandler getPedirAjudaHandler() {
        return new PedirAjudaHandler(migrante);
    }

    public static MSession reconhecerMigrante(MigDTO migrante) {

        if(migrante.getClass().getSimpleName().equals("MigDTO")) {
            if(CatalogoMigrantes.getInstance().migranteExistente(migrante))
                return new MSession(CatalogoMigrantes.getInstance().getMigrante(migrante));
            return new MSession(new Migrante(migrante.getNrTelefone(), migrante.getNome()));
        }else{
            if(CatalogoMigrantes.getInstance().migranteExistente(migrante))
                return new MSession(CatalogoMigrantes.getInstance().getMigrante(migrante));
            Familia familia = new Familia(migrante.getNrTelefone(), migrante.getNome());
            for(MembroDTO m : ((FamDTO) migrante).getMembros())
                familia.addMembro(new Membro(m.getNome()));
            return new MSession(familia);
        }
    }  
}