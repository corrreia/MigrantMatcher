package migrant_matcher.app.strategies.ord;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import migrant_matcher.app.domain.Ajuda;
import migrant_matcher.app.domain.Item;

public class OrdAjFstItem implements OrdAjStrat{

    @Override
    public List<Ajuda> ordListAj(List<Ajuda> ajudaList) {
        Collections.sort(ajudaList, new Comparator<Ajuda>() {
            @Override
            public int compare(Ajuda a1, Ajuda a2) {
                if(a2 instanceof Item){
                    return -1;
                }
                return 0;
            }
        });
        return ajudaList;
    }
    
}
