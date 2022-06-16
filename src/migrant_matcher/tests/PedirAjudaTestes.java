package migrant_matcher.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import migrant_matcher.app.facade.handlers.PedirAjudaHandler;
import migrant_matcher.app.domain.Alojamento;
import migrant_matcher.app.domain.Item;
import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.facade.MigrantMatcher;
import migrant_matcher.app.facade.dto.ItemDTO;
import migrant_matcher.app.facade.dto.MembroDTO;
import migrant_matcher.app.facade.dto.RegiaoDTO;
import migrant_matcher.app.facade.session.MSession;

public class PedirAjudaTestes {

    private static MigrantMatcher testes = new MigrantMatcher();
    List<MembroDTO> membros = new LinkedList<>();


    private void familiaAndRegioes() {
        membros.add(new MembroDTO("João Pedro"));
        membros.add(new MembroDTO("Maria João"));
        membros.add(new MembroDTO("José Maria"));
        membros.add(new MembroDTO("José Pedro"));

        testes.getCatalogoRegiao().adicionarRegiao(new Regiao("Norte"));
        testes.getCatalogoRegiao().adicionarRegiao(new Regiao("Sul"));
        testes.getCatalogoRegiao().adicionarRegiao(new Regiao("Leste"));
        testes.getCatalogoRegiao().adicionarRegiao(new Regiao("Oeste"));
        
        testes.getCatalogoAjudas().adicionarAjuda(new Alojamento("920000000", 4, new Regiao("Norte")));
        testes.getCatalogoAjudas().adicionarAjuda(new Alojamento("920000001", 6, new Regiao("Sul")));

        testes.getCatalogoAjudas().adicionarAjuda(new Item("920000002", "Cama"));
        testes.getCatalogoAjudas().adicionarAjuda(new Item("920000003", "Mesa"));
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

        familiaAndRegioes();
        MSession session = testes.reconhecerFamilia("910000000", "Joaquim Streltsov", membros);

        assertEquals(5, session.getFamilia().getFamiliaSize());
        assertEquals("910000000", session.getFamilia().getNrTelefone());
        assertEquals("Joaquim Streltsov", session.getFamilia().getNome()); 
    }

    @Test
    void regioesDisponiveisTeste(){
        testes.wipeCatalogos();

        MSession session = testes.reconhecerMigrante("910000000", "Joaquim Streltsov");
        PedirAjudaHandler pah = session.getPedirAjudaHandler();

        familiaAndRegioes();
        
        assertEquals(4, pah.regioesDisponiveis().size());
    }

    @Test
    void ajudasPossiveisTeste() {
        testes.wipeCatalogos();

        MSession session = testes.reconhecerMigrante("910000000", "Joaquim Streltsov");
        PedirAjudaHandler pah = session.getPedirAjudaHandler();

        familiaAndRegioes();
        assertEquals(3,pah.indicarRegiao(new RegiaoDTO("Norte")).size()); // um alojamento e 2 items que não são afetados por região
        assertEquals(true, pah.indicarRegiao(new RegiaoDTO("Sul")).toString().contains("Sul"));
        assertEquals(false, pah.indicarRegiao(new RegiaoDTO("Leste")).toString().contains("Leste"));
    }

    @Test
    void indicarAjudaEConfirmarTeste(){
        testes.wipeCatalogos();

        MSession session = testes.reconhecerMigrante("910000000", "Joaquim Streltsov");
        PedirAjudaHandler pah = session.getPedirAjudaHandler();

        familiaAndRegioes();
        assertEquals(4, testes.getCatalogoAjudas().getAjudas().size());

        pah.indicarAjuda(new ItemDTO(new Item("920000000", "Cama")));
        pah.confirmarSelecao();

        assertEquals(1, testes.getCatalogoMigrantes().getMigrantes().size());

        assertEquals(1, testes.getCatalogoMigrantes().getMigrante(session.getMigrante()).getAjudasUsadas().size());
        assertEquals(1, testes.getCatalogoMigrantes().getMigrantes().get(0).getAjudasUsadas().toString().contains("Cama"));
    }
}