package migrant_matcher.app.strategies.ord;

import java.util.List;

import migrant_matcher.app.domain.Ajuda;

public interface OrdAjStrat {
    
    public void ordCat();

    public List<Ajuda> ordListAj(List<Ajuda> ajudaList);
}