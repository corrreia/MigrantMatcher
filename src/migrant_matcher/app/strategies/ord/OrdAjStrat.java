package migrant_matcher.app.strategies.ord;

import java.util.List;

import migrant_matcher.app.domain.Ajuda;

/**
 * Interface que irá definir as estratégias de ordenação
 * de ajudas.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public interface OrdAjStrat {
    
    /**
    * Ordena uma lista de ajudas de acordo com a estratégia.
    * 
    * @param ajds - Lista de ajudas a ordenar
    */
    public List<Ajuda> ordListAj(List<Ajuda> ajudaList);
}
