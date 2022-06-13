package migrant_matcher.app.strategies;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import migrant_matcher.app.domain.Ajuda;
import migrant_matcher.app.domain.catalogos.CatalogoAjudas;

public class OrdAjAscDate implements OrdAjStrat {

    @Override
    public void ordCat() {
        ordListAj(CatalogoAjudas.getInstance().getAjudas());
    }
    
    @Override
    public List<Ajuda> ordListAj(List<Ajuda> ajudaList) {
        Collections.sort(ajudaList, new Comparator<Ajuda>() {
            @Override
            public int compare(Ajuda a1, Ajuda a2) {
                return a1.getData().compareTo(a2.getData());
            }
        });
        return ajudaList;    
    }
    
    
}
