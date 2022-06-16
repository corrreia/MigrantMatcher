package migrant_matcher.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.facade.MigrantMatcher;
import migrant_matcher.app.facade.dto.RegiaoDTO;
import migrant_matcher.app.facade.handlers.OferecerAjudaHandler;
import migrant_matcher.app.facade.session.VSession;

public class OferecerAjudaTestes {

    private static MigrantMatcher testes = new MigrantMatcher();

    @Test
    void reconhecerVoluntarioTeste() {    
        testes.wipeCatalogos(); 
        VSession session = testes.reconhecerVoluntario("920000000");

        assertEquals("920000000", session.getVoluntario().getNrTelefone());
        testes.wipeCatalogos(); 
    }

    @Test
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