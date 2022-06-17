package migrant_matcher.app.strategies.ord;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import migrant_matcher.app.domain.Ajuda;


/**
 * A classe {@OrdAjDescDate} que implementa a interface {@OrdAjStrat}
 * representa a estratégia de ordenação de ajudas que dá prioridade
 * às ajudas mais antigas.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class OrdAjDescDate implements OrdAjStrat{

    
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
                return a2.getData().compareTo(a1.getData());
            }
        });
        return ajudaList;
    }
    

    
}
