package migrant_matcher.tests;

import migrant_matcher.app.domain.Item;
import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.domain.catalogos.CatalogoAjudas;
import migrant_matcher.app.domain.factory.OrdAjFactory;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import migrant_matcher.app.domain.Ajuda;
import migrant_matcher.app.domain.Alojamento;

/**
 * A classe {@code OrdStratTests} serve para testar as Strategies
 * de ordenação de ajudas.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class OrdStratTests {

    Item banana = new Item("920000000", "banana");
    Item pao = new Item("920000000", "pao");
    Item torradeira = new Item("920000000", "torradeira");
    Item geladeira = new Item("920000000", "geladeira");
    Item maca = new Item("920000000", "maca");
    Item tomate = new Item("920000000", "tomate");
    Item abacaxi = new Item("920000000", "abacaxi");
    Item abacate = new Item("920000000", "abacate");

    Alojamento alojamento1 = new Alojamento("920000000", 4, new Regiao("Norte"));
    Alojamento alojamento2 = new Alojamento("920000000", 4, new Regiao("Sul"));
    Alojamento alojamento3 = new Alojamento("920000000", 4, new Regiao("Este"));
    Alojamento alojamento4 = new Alojamento("920000000", 4, new Regiao("Oeste"));

    List<Ajuda> ajudas = new LinkedList<Ajuda>();

    OrdAjFactory ordAjFactory = OrdAjFactory.getInstance();
    CatalogoAjudas catalogoAjudas = CatalogoAjudas.getInstance();

    /**
     * Função privada que preenche o catalogo 
     * de ajudas
     */
    private void fillList() {
        catalogoAjudas.wipeCatalogo();

        catalogoAjudas.adicionarAjuda(banana);
        catalogoAjudas.adicionarAjuda(pao);
        catalogoAjudas.adicionarAjuda(torradeira);
        catalogoAjudas.adicionarAjuda(geladeira);
        catalogoAjudas.adicionarAjuda(maca);
        catalogoAjudas.adicionarAjuda(tomate);
        catalogoAjudas.adicionarAjuda(abacaxi);
        catalogoAjudas.adicionarAjuda(abacate);
        catalogoAjudas.adicionarAjuda(alojamento1);
        catalogoAjudas.adicionarAjuda(alojamento2);
        catalogoAjudas.adicionarAjuda(alojamento3);
        catalogoAjudas.adicionarAjuda(alojamento4);

        catalogoAjudas.shuffleCatalogo();   

    }

    @Test
    /**
     * Testa a ordenação por ID
     */
    void testOrdByID() {
        fillList();

        List<Ajuda> ajudasOrd = new LinkedList<Ajuda>();
        
        ajudasOrd.add(banana);
        ajudasOrd.add(pao);
        ajudasOrd.add(torradeira);
        ajudasOrd.add(geladeira);
        ajudasOrd.add(maca);
        ajudasOrd.add(tomate);
        ajudasOrd.add(abacaxi);
        ajudasOrd.add(abacate);
        ajudasOrd.add(alojamento1);
        ajudasOrd.add(alojamento2);
        ajudasOrd.add(alojamento3);
        ajudasOrd.add(alojamento4);

        ajudas = ordAjFactory.getOrdAjStrat("migrant_matcher.app.strategies.ord.OrdAjById").ordListAj(catalogoAjudas.getAjudas());

        assertEquals(ajudasOrd, ajudas);
    }

    @Test
    /**
     * Testa a ordenação por alojamentos primeiro
     */
    void testOrdFstAloj() {
        fillList();

        ajudas = ordAjFactory.getOrdAjStrat("migrant_matcher.app.strategies.ord.OrdAjFstAloj").ordListAj(catalogoAjudas.getAjudas());

        assertEquals(ajudas.get(0) instanceof Alojamento, true);
        assertEquals(ajudas.get(1) instanceof Alojamento, true);
        assertEquals(ajudas.get(2) instanceof Alojamento, true);
        assertEquals(ajudas.get(3) instanceof Alojamento, true);
        assertEquals(ajudas.get(4) instanceof Alojamento, false);
    }

    @Test
    /**
     * Testa a ordenação por Items primeiro
     */
    void testOrdFstItem() {
        fillList();

        ajudas = ordAjFactory.getOrdAjStrat("migrant_matcher.app.strategies.ord.OrdAjFstItem").ordListAj(catalogoAjudas.getAjudas());

        assertEquals(ajudas.get(11) instanceof Alojamento, true);
        assertEquals(ajudas.get(10) instanceof Alojamento, true);
        assertEquals(ajudas.get(9) instanceof Alojamento, true);
        assertEquals(ajudas.get(8) instanceof Alojamento, true);
        assertEquals(ajudas.get(7) instanceof Alojamento, false);
    }

    //@Test  DEVIDO AO FACTO DE TODOS OS ITENS SEREM ADICIONADOS AO MESMO INSTANTE, O TESTE NÃO FUNCIONA BEM   
    // void testOrdAscDate() {
    //     fillList();

    //     ajudasOrdDate.add(abacaxi);
    //     ajudasOrdDate.add(abacate);
    //     ajudasOrdDate.add(alojamento1);
    //     ajudasOrdDate.add(alojamento2);
    //     ajudasOrdDate.add(alojamento3);
    //     ajudasOrdDate.add(alojamento4);


    //     ajudas = ordAjFactory.getOrdAjStrat("migrant_matcher.app.strategies.ord.OrdAjAscDate").ordListAj(catalogoAjudas.getAjudas());

    //     assertEquals(ajudasOrdDat, ajudas);
    //}

}
