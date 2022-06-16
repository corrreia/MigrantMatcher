package migrant_matcher.app.facade;

import java.util.List;

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
    public CatalogoRegiao catalogoRegiao;  //apenas publico devido ao facto de ter que ser preenchido em Client.java

    public MigrantMatcher() {
        this.catalogoAjudas = CatalogoAjudas.getInstance();
        this.catalogoMigrantes = CatalogoMigrantes.getInstance();
        this.catalogoVoluntario = CatalogoVoluntario.getInstance();
        this.catalogoRegiao = CatalogoRegiao.getInstance();
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

    public String toStringCatalogos() {
        return "Catalogo de Ajudas: \n" + catalogoAjudas.toString() + "\n" +
                "Catalogo de Migrantes: \n" + catalogoMigrantes.toString() + "\n" +
                "Catalogo de Voluntarios: \n" + catalogoVoluntario.toString() + "\n" +
                "Catalogo de Regiao: \n" + catalogoRegiao.toString();
    }


    // Os Getters abaixo são apenas para testes, numa versão final não devem existir
    // pois podem gerar problemas de segurança
    
    public CatalogoAjudas getCatalogoAjudas() {
        return catalogoAjudas;
    }

}
