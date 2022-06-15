package migrant_matcher.client;

import java.util.Scanner;

import migrant_matcher.app.MigrantMatcher;
import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.domain.catalogos.CatalogoAjudas;
import migrant_matcher.app.domain.catalogos.CatalogoRegiao;
import migrant_matcher.app.facade.VSession;
import migrant_matcher.app.handlers.OferecerAjudaHandler;

public class VoluntarioUseCase {
    public static void main(String[] args) {
        MigrantMatcher app = new MigrantMatcher();

        CatalogoRegiao.getInstance().adicionarRegiao(new Regiao("lisboa"));
        CatalogoRegiao.getInstance().adicionarRegiao(new Regiao("porto"));
        //System.out.println(CatalogoRegiao.getInstance().getRegioes());

        VSession sess = app.reconhecerVoluntario("87345635");

        OferecerAjudaHandler oh = sess.getOferecerAjudaHandler();

        System.out.println(oh.nPessoasAlberga(2));

        System.out.println(oh.indicarRegiao("lisboa"));

        System.out.println(oh.indicarCodigo(new Scanner(System.in).nextLine()));

        System.out.println(CatalogoAjudas.getInstance().getAjudas());
    }

    
}
