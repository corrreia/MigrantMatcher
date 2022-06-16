package migrant_matcher.app.domain.catalogos;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import migrant_matcher.app.domain.Ajuda;
import migrant_matcher.app.domain.Alojamento;
import migrant_matcher.app.domain.Item;
import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.facade.dto.AjudaDTO;

public class CatalogoAjudas {
    
    private static List<Ajuda> catAjudas;
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
        ajuda.setId(idCounter);
        idCounter++;
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

    public List<AjudaDTO> getAjudasDTO() {
        return catAjudas.stream().map(AjudaDTO::new).collect(Collectors.toList());
    }

    public Ajuda getAjudaById(int id) {
        return catAjudas.stream().filter(ajuda -> ajuda.getId() == id).findFirst().get();
    }

    public Ajuda getAjuda(AjudaDTO ajuda) {
        return catAjudas.stream().filter(aj -> aj.getId() == ajuda.getId()).findFirst().get();
    }

    public int sizeCatalogo() {
        return catAjudas.size();
    }

    public void wipeCatalogo(){
        if(catAjudas.size() > 0){
            catAjudas.clear();
        }
        idCounter = 0;
    }

    public void shuffleCatalogo(){
        Collections.shuffle(catAjudas);
    }

    public String toString(){
        StringBuilder bob = new StringBuilder();
        for(Ajuda ajuda : catAjudas){
            bob.append(ajuda.toString() + "\n");
        }
        return bob.toString();
    }
}
