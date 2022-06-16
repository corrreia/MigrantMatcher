package migrant_matcher.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import migrant_matcher.app.facade.MigrantMatcher;
import migrant_matcher.app.facade.handlers.OferecerAjudaHandler;
import migrant_matcher.app.facade.session.VSession;

class OferecerAjudaTestes {

    private static MigrantMatcher testes = new MigrantMatcher();

    @Test
    void reconhecerVoluntarioTeste() {    
        VSession session = testes.reconhecerVoluntario("927089178");

        assertEquals("927089178", session.getVoluntario().getNrTelefone());
    }

    @Test
    void itemCriadoTeste() {
        VSession session = testes.reconhecerVoluntario("927089178");
        OferecerAjudaHandler ohf = session.getOferecerAjudaHandler();
        
        ohf.oferecerItem("Bananas");
        ohf.indicarCodigo(ohf.getAuthCode());

        assertEquals(1, testes.getCatalogoAjudas().sizeCatalogo());
        assertEquals(true, testes.getCatalogoAjudas().toString().contains(", contactoProprietario=" + "927089178"));
        assertEquals(true, testes.getCatalogoAjudas().getAjudaById(1).toString().contains("Bananas"));
    }
}