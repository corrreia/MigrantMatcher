package migrant_matcher.app.strategies.ord;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import migrant_matcher.app.domain.Ajuda;
import migrant_matcher.app.domain.Item;

/**
 * A classe {@code OrdAjFstItem} que implementa a interface {@OrdAjStrat}
 * representa a estratégia de ordenação de ajudas que dá prioridade
 * aos Items.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class OrdAjFstItem implements OrdAjStrat{

    
    /** 
     * Ordena uma lista de forma aleatória
     * 
     * @param ajudaList     - Lista de ajudas a ordenar
     * @return List<Ajuda>  - Lista de ajudas ordenada
     */
    @Override
    public List<Ajuda> ordListAj(List<Ajuda> ajudaList) {
        Collections.sort(ajudaList, new Comparator<Ajuda>() {
            @Override
            public int compare(Ajuda a1, Ajuda a2) {
                if(a1 instanceof Item){
                    return -1;
                }
                return 1;
            }
        });
        return ajudaList;
    }
    
}
