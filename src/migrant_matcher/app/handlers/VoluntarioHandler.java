package migrant_matcher.app.handlers;

import java.util.List;
import java.util.stream.Collectors;

import migrant_matcher.app.domain.Ajuda;
import migrant_matcher.app.domain.Alojamento;
import migrant_matcher.app.domain.Voluntario;
import migrant_matcher.app.domain.catalogos.CatalogoRegiao;

public class VoluntarioHandler { //handler para criar ajudas

    private Voluntario v;
    private Ajuda a;

    public VoluntarioHandler(Voluntario v) {
        this.v = v;
    }

    public List<String> nPessoasAlberga(int n){
        a = new Alojamento(n);
        return CatalogoRegiao.getInstance().getRegioes().stream().map(reg -> reg.getNome()).collect(Collectors.toList());
    }

    



    

    
}
