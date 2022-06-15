package migrant_matcher.app;

import migrant_matcher.app.domain.Migrante;
import migrant_matcher.app.domain.Voluntario;
import migrant_matcher.app.domain.catalogos.CatalogoAjudas;
import migrant_matcher.app.domain.catalogos.CatalogoMigrantes;
import migrant_matcher.app.domain.catalogos.CatalogoRegiao;
import migrant_matcher.app.domain.catalogos.CatalogoVoluntario;
import migrant_matcher.app.facade.MSession;
import migrant_matcher.app.facade.VSession;

public class MigrantMatcher {

    private CatalogoAjudas catalogoAjudas;   
    private CatalogoMigrantes catalogoMigrantes;
    private CatalogoVoluntario catalogoVoluntario;  
    private CatalogoRegiao catalogoRegiao;

    public MigrantMatcher() {
        this.catalogoAjudas = CatalogoAjudas.getInstance();
        this.catalogoMigrantes = CatalogoMigrantes.getInstance();
        this.catalogoVoluntario = CatalogoVoluntario.getInstance();
        this.catalogoRegiao = CatalogoRegiao.getInstance();
    }
    
    public VSession reconhecerVoluntario(String nrTelefone) {
        if(catalogoVoluntario.voluntarioExistente(nrTelefone)) {
            return new VSession(CatalogoVoluntario.getInstance().getVoluntario(nrTelefone));
        }
        return new VSession(new Voluntario(nrTelefone));
    }

    public MSession reconhecerMigrante(String nrTelefone, String nome) {
        if(catalogoMigrantes.migranteExistente(nrTelefone, nome)) {
            return new MSession(CatalogoMigrantes.getInstance().getMigrante(nrTelefone));
        }
        return new MSession(new Migrante(nrTelefone, nome));
    }

}
