package migrant_matcher.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.facade.MigrantMatcher;
import migrant_matcher.app.facade.controllers.OferecerAjudaHandler;
import migrant_matcher.app.facade.dto.RegiaoDTO;
import migrant_matcher.app.facade.session.VSession;

/**
 * A classe {@code OferecerAjudaTestes} serve para testes ao primeiro caso de uso, onde
 * o utilizador se regista como voluntário e registar algum tipo de ajuda que pretenda oferecer 
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class OferecerAjudaTestes {

    private static MigrantMatcher testes = new MigrantMatcher();

    @Test
    /**
	* Testa se a sessão é corretamente iniciada
	* verificando se o voluntario corrente é o
    * certo
	*/
    void reconhecerVoluntarioTeste() {    
        testes.wipeCatalogos(); 
        VSession session = testes.reconhecerVoluntario("920000000");

        assertEquals("920000000", session.getVoluntario().getNrTelefone());
        testes.wipeCatalogos(); 
    }

    @Test
    /**
	* Testa se um item é corretamente criado
    * e adicionado ao catalogo de ajudas
	*/
    void itemCriadoTeste() {
        testes.wipeCatalogos();
        VSession session = testes.reconhecerVoluntario("920000000");
        OferecerAjudaHandler oah = session.getOferecerAjudaHandler();
        
        oah.oferecerItem("Bananas");
        oah.indicarCodigo(oah.getAuthCode());

        oah.oferecerItem("Papel Higienico");
        oah.indicarCodigo(oah.getAuthCode());

        assertEquals(2, testes.getCatalogoAjudas().sizeCatalogo());

        assertEquals(true, testes.getCatalogoAjudas().getAjudaById(0).toString().contains("contactoProprietario=" + "920000000"));
        assertEquals(true, testes.getCatalogoAjudas().getAjudaById(0).toString().contains("Bananas"));

        assertEquals(true, testes.getCatalogoAjudas().getAjudaById(1).toString().contains("contactoProprietario=" + "920000000"));
        assertEquals(true, testes.getCatalogoAjudas().getAjudaById(1).toString().contains("Papel Higienico"));

    }

    @Test
    /**
	* Testa se um alojamento é corretamente criado
    * e adicionado ao catalogo de ajudas
	*/
    void alojamentoCriadoTeste() {
        testes.wipeCatalogos(); 
        VSession session = testes.reconhecerVoluntario("920000000");
        OferecerAjudaHandler oah = session.getOferecerAjudaHandler();

        testes.getCatalogoRegiao().adicionarRegiao(new Regiao("Porto"));
        testes.getCatalogoRegiao().adicionarRegiao(new Regiao("Lisboa"));


        oah.nPessoasAlberga(10);
        oah.indicarRegiao(new RegiaoDTO("Lisboa"));
        oah.indicarCodigo(oah.getAuthCode());

        oah.nPessoasAlberga(5);
        oah.indicarRegiao(new RegiaoDTO("Porto"));
        oah.indicarCodigo(oah.getAuthCode());


        assertEquals(2, testes.getCatalogoAjudas().sizeCatalogo());
        
        assertEquals(true, testes.getCatalogoAjudas().getAjudaById(0).toString().contains("contactoProprietario=920000000"));
        assertEquals(true, testes.getCatalogoAjudas().getAjudaById(0).toString().contains("nPessoas=10"));
        assertEquals(true, testes.getCatalogoAjudas().getAjudaById(0).toString().contains("Regiao [name=Lisboa]")); 
        
        assertEquals(true, testes.getCatalogoAjudas().getAjudaById(1).toString().contains("contactoProprietario=920000000"));
        assertEquals(true, testes.getCatalogoAjudas().getAjudaById(1).toString().contains("nPessoas=5"));
        assertEquals(true, testes.getCatalogoAjudas().getAjudaById(1).toString().contains("Regiao [name=Porto]")); 

    }

    @Test
    /**
	* Testa a funcionalidade de autenticação 
    * verificando se este consegue submeter a sua 
    * ajuda introduzindo um código de autenticação
    * errado
	*/
    void codigosTeste() {
        testes.wipeCatalogos(); 
        VSession session = testes.reconhecerVoluntario("920000000");
        OferecerAjudaHandler oah = session.getOferecerAjudaHandler();

        oah.oferecerItem("Guarda-Chuva");
        oah.indicarCodigo("123-123");   //codigo errado

        assertEquals(0, testes.getCatalogoAjudas().sizeCatalogo()); //não deve criar ajuda

        oah.indicarCodigo(oah.getAuthCode());

        assertEquals(1, testes.getCatalogoAjudas().sizeCatalogo()); //codigo certo já deve criar a ajuda
    }
}