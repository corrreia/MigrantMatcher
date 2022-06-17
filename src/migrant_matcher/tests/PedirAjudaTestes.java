package migrant_matcher.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import migrant_matcher.app.domain.Alojamento;
import migrant_matcher.app.domain.Item;
import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.facade.MigrantMatcher;
import migrant_matcher.app.facade.controllers.PedirAjudaHandler;
import migrant_matcher.app.facade.dto.AlojDTO;
import migrant_matcher.app.facade.dto.ItemDTO;
import migrant_matcher.app.facade.dto.MembroDTO;
import migrant_matcher.app.facade.dto.RegiaoDTO;
import migrant_matcher.app.facade.session.MSession;

/**
 * A classe {@code PedirAjudaTestes} serve para testes ao segundo caso de uso, onde
 * o utilizador se regista como migrante(individual ou familia) e pede algum tipo de ajuda 
 * de que pretenda usufruir
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class PedirAjudaTestes {

    private static MigrantMatcher testes = new MigrantMatcher();
    List<MembroDTO> membros = new LinkedList<>();

    /**
     * Função privada que serve para preencher catálogos 
     * e criar uma familia. Serve apenas para testes.
     */
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
    /**
     * Testa se a sessão é corretamente iniciada reconhecendo o migrante.
     * Apenas aborda migrantes individuais.
     */
    void reconhecerMigranteIndividualTeste() {
        testes.wipeCatalogos();

        MSession session = testes.reconhecerMigrante("910000000", "Joaquim Streltsov");

        assertEquals("910000000", session.getMigrante().getNrTelefone());
        assertEquals("Joaquim Streltsov", session.getMigrante().getNome());
    }

    @Test
    /**
    * Testa se a sessão é corretamente iniciada reconhecendo o migrante.
    * Apenas aborda Familias
    */
    void reconhecerMigranteFamiliaTeste() {
        testes.wipeCatalogos();

        familiaAndRegioes();
        MSession session = testes.reconhecerFamilia("910000000", "Joaquim Streltsov", membros);

        assertEquals(5, session.getFamilia().getFamiliaSize());
        assertEquals("910000000", session.getFamilia().getNrTelefone());
        assertEquals("Joaquim Streltsov", session.getFamilia().getNome()); 
    }

    @Test
     /**
     * Teste que verifica se as regiões disponiveis estão corretamente 
     * identificadas.
     */
    void regioesDisponiveisTeste(){
        testes.wipeCatalogos();

        MSession session = testes.reconhecerMigrante("910000000", "Joaquim Streltsov");
        PedirAjudaHandler pah = session.getPedirAjudaHandler();

        familiaAndRegioes();
        
        assertEquals(4, pah.regioesDisponiveis().size());
    }

    @Test
    /**
     * Teste que verifica se as ajudas disponiveis estão corretamente 
     * identificadas.
     */
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
    /**
     * Teste que verifica se um migrante individual consegue selecionar 
     * as ajudas que pretende e confirmá-las corretamente.
     */
    void indicarAjudaEConfirmar1Teste(){
        testes.wipeCatalogos();

        MSession session = testes.reconhecerMigrante("910000000", "Joaquim Streltsov");
        PedirAjudaHandler pah = session.getPedirAjudaHandler();

        testes.getCatalogoAjudas().adicionarAjuda(new Item("920000002", "Cama"));


        pah.indicarAjuda(new ItemDTO(new Item("920000002", "Cama")));
        pah.confirmarSelecao();

        assertEquals(1, testes.getCatalogoMigrantes().getMigrante(session.getMigrante()).getAjudasUsadas().size());
        assertEquals(true, testes.getCatalogoMigrantes().getMigrante(session.getMigrante()).getAjudasUsadas().toString().contains("Cama"));
    }

    @Test
    /**
     * Teste que verifica se uma Familia consegue selecionar 
     * as ajudas que pretende e confirmá-las corretamente.
     */
    void indicarAjudaEConfirmar2Teste(){
        testes.wipeCatalogos();

        MSession session = testes.reconhecerFamilia("910000000", "Joaquim Streltsov", membros);
        PedirAjudaHandler pah = session.getPedirAjudaHandler();

        testes.getCatalogoAjudas().adicionarAjuda(new Alojamento("920000003", 6, new Regiao("Sul")));


        pah.indicarAjuda(new AlojDTO(new Alojamento("920000003", 6, new Regiao("Sul"))));
        pah.confirmarSelecao();

        assertEquals(1, testes.getCatalogoMigrantes().getMigrante(session.getMigrante()).getAjudasUsadas().size());
        assertEquals(true, testes.getCatalogoMigrantes().getMigrante(session.getMigrante()).getAjudasUsadas().toString().contains("Alojamento"));
        assertEquals(true, testes.getCatalogoMigrantes().getMigrante(session.getMigrante()).getAjudasUsadas().toString().contains("Sul"));
    }

}