package migrant_matcher.app.domain.catalogos;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import migrant_matcher.app.domain.Ajuda;
import migrant_matcher.app.domain.Alojamento;
import migrant_matcher.app.domain.Item;
import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.facade.dto.AjudaDTO;
import migrant_matcher.app.facade.dto.AlojDTO;
import migrant_matcher.app.facade.dto.ItemDTO;

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

    // public boolean isValidAjuda(AjudaDTO ajuda) {  //FIXME: completamente broken
    //     boolean valid = false;
    //     if(ajuda instanceof ItemDTO && getAjudaById(ajuda.getId()) instanceof Item) {
    //         valid = ((Item) getAjudaById(ajuda.getId())).getDescricao().equals(((ItemDTO) ajuda).getDescricao());
    //     } else if(ajuda instanceof AlojDTO && getAjudaById(ajuda.getId()) instanceof Alojamento) {
    //         valid = ((Alojamento) getAjudaById(ajuda.getId())).getRegiao().equals(((AlojDTO) ajuda).getRegiao());  
    //     }
    //     return valid;
    // }

    public int sizeCatalogo() {
        return catAjudas.size();
    }

    public String toString(){
        StringBuilder bob = new StringBuilder();
        for(Ajuda ajuda : catAjudas){
            bob.append(ajuda.toString() + "\n");
        }
        return bob.toString();
    }
}
