package migrant_matcher.app.strategies.ord;

import java.util.Collections;
import java.util.List;

import migrant_matcher.app.domain.Ajuda;

public class OrdAjRand implements OrdAjStrat {

    @Override
    public List<Ajuda> ordListAj(List<Ajuda> ajudaList) {
        Collections.shuffle(ajudaList);
        return ajudaList;
    }
}
