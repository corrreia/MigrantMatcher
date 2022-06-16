package migrant_matcher.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;


import migrant_matcher.app.facade.MigrantMatcher;
import migrant_matcher.app.facade.dto.MembroDTO;
import migrant_matcher.app.facade.session.MSession;

public class PedirAjudaTestes {

    private static MigrantMatcher testes = new MigrantMatcher();
    List<MembroDTO> membros = new LinkedList<>();


    private void Familia() {
        membros.add(new MembroDTO("João Pedro"));
        membros.add(new MembroDTO("Maria João"));
        membros.add(new MembroDTO("José Maria"));
        membros.add(new MembroDTO("José Pedro"));
    }

    @Test
    void reconhecerMigranteIndividualTeste() {
        testes.wipeCatalogos();

        MSession session = testes.reconhecerMigrante("910000000", "Joaquim Streltsov");

        assertEquals("910000000", session.getMigrante().getNrTelefone());
        assertEquals("Joaquim Streltsov", session.getMigrante().getNome());
    }

    @Test
    void reconhecerMigranteFamiliaTeste() {
        testes.wipeCatalogos();

        Familia();
        MSession session = testes.reconhecerFamilia("910000000", "Joaquim Streltsov", membros);

        assertEquals(5, session.getFamilia().getFamiliaSize());
        assertEquals("910000000", session.getFamilia().getNrTelefone());
        assertEquals("Joaquim Streltsov", session.getFamilia().getNome()); 
    }

    @Test
    void regioesDisponiveisTeste(){
        testes.wipeCatalogos();
    }


}