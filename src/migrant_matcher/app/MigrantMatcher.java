package migrant_matcher.app;

import migrant_matcher.app.domain.Alojamento;
import migrant_matcher.app.domain.Item;
import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.domain.catalogos.CatalogoAjudas;

public class MigrantMatcher {
    public static void main(String[] args) {

        CatalogoAjudas catAjudas = CatalogoAjudas.getInstance();
        
        catAjudas.adicionarAjuda(new Item("Ajuda 1"));
        catAjudas.adicionarAjuda(new Item("Ajuda 2"));
        catAjudas.adicionarAjuda(new Alojamento(1, new Regiao("Sul")));

    


        System.out.println(catAjudas.getAjudas());        
    }
}
