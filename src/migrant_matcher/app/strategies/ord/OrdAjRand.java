package migrant_matcher.app.strategies.ord;

import java.util.Collections;
import java.util.List;

import migrant_matcher.app.domain.Ajuda;

/**
 * A classe {@ codeOrdAjRand} que implementa a interface {@OrdAjStrat}
 * representa a estratégia de ordenação de ajudas aleatória.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class OrdAjRand implements OrdAjStrat {

    
    /** 
     * Ordena uma lista de forma aleatória
     * 
     * @param ajudaList     - Lista de ajudas a ordenar
     * @return List<Ajuda>  - Lista de ajudas ordenada
     */
    @Override
    public List<Ajuda> ordListAj(List<Ajuda> ajudaList) {
        Collections.shuffle(ajudaList);
        return ajudaList;
    }
}
