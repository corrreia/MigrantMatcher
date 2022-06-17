package migrant_matcher.app.strategies.ord;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import migrant_matcher.app.domain.Ajuda;

/**
 * A classe {@code OrdAjById} que implementa a interface {@OrdAjStrat}
 * representa a estratégia de ordenação de ajudas que ordena por ordem
 * crescente de id.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class OrdAjById implements OrdAjStrat{

    
    /** 
     * Ordena uma lista de forma aleatória
     * 
     * @param ajudaList     - Lista de ajudas a ordenar
     * @return List<Ajuda>  - Lista de ajudas ordenada
     */
    @Override
    public List<Ajuda> ordListAj(List<Ajuda> ajudaList) {

        System.out.println("Ordenando ajudas por ID...");
        Collections.sort(ajudaList, new Comparator<Ajuda>() {
            @Override
            public int compare(Ajuda a1, Ajuda a2) {
                if(a1.getId() < (a2.getId()))
                    return -1;
                else if(a1.getId() > (a2.getId()))
                    return 1;
                else
                    return 0;
            }
        });
        return ajudaList;
    }

}
