package migrant_matcher.app.facade;

import java.util.List;

import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.domain.catalogos.CatalogoAjudas;
import migrant_matcher.app.domain.catalogos.CatalogoMigrantes;
import migrant_matcher.app.domain.catalogos.CatalogoRegiao;
import migrant_matcher.app.domain.catalogos.CatalogoVoluntario;
import migrant_matcher.app.facade.dto.FamDTO;
import migrant_matcher.app.facade.dto.MembroDTO;
import migrant_matcher.app.facade.dto.MigDTO;
import migrant_matcher.app.facade.dto.VolDTO;
import migrant_matcher.app.facade.session.MSession;
import migrant_matcher.app.facade.session.VSession;

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

        //temp
        catalogoRegiao.adicionarRegiao(new Regiao("Norte"));
        catalogoRegiao.adicionarRegiao(new Regiao("Sul"));
        catalogoRegiao.adicionarRegiao(new Regiao("Leste"));
        catalogoRegiao.adicionarRegiao(new Regiao("Oeste"));
    }
    
    public VSession reconhecerVoluntario(String nrTelefone) {
        return VSession.reconhecerVoluntario(new VolDTO(nrTelefone));
    }

    public MSession reconhecerMigrante(String nrTelefone, String nome) {
        return MSession.reconhecerMigrante(new MigDTO(nome, nrTelefone));
    }

    public MSession reconhecerFamilia(String nrTelefone, String nome, List<MembroDTO> membros) {
        return MSession.reconhecerMigrante(new FamDTO(nome, nrTelefone, membros));
    }

}
