package migrant_matcher.app.domain.catalogos;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import migrant_matcher.app.domain.Ajuda;
import migrant_matcher.app.domain.Alojamento;
import migrant_matcher.app.domain.Item;
import migrant_matcher.app.domain.Regiao;

public class CatalogoAjudas {
    
    private List<Ajuda> catAjudas;
    private static CatalogoAjudas INSTANCE;
    private int idCounter = 0;

    private CatalogoAjudas() {
        catAjudas = new LinkedList<Ajuda>();
    }

    public static CatalogoAjudas getInstance() {  // Singleton
        if (INSTANCE == null) {
            INSTANCE = new CatalogoAjudas();
        }
        return INSTANCE;
    }

    public void adicionarAjuda(Ajuda ajuda) {
        ajuda.setId(idCounter++);
        catAjudas.add(ajuda);
    }

    public List<Ajuda> getItems() {
        //filter only Itens 
        return catAjudas.stream().filter(ajuda -> ajuda instanceof Item).collect(Collectors.toList());
    }

    public List<Ajuda> getAlojamentosByRegion(Regiao reg) {
        //filter only Alojamentos by regiao
        return catAjudas.stream().filter(ajuda -> ajuda instanceof Alojamento && ((Alojamento) ajuda).getRegiao().equals(reg)).collect(Collectors.toList());
    }

    public List<Ajuda> getAjudas(){
        return catAjudas;
    }
}
