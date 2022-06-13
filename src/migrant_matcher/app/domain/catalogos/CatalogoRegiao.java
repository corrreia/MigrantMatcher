package migrant_matcher.app.domain.catalogos;

import java.util.LinkedList;
import java.util.List;

import migrant_matcher.app.domain.Regiao;

public class CatalogoRegiao {
    private List<Regiao> catRegiao;
    private static CatalogoRegiao INSTANCE;

    private CatalogoRegiao() {
        catRegiao = new LinkedList<Regiao>();
    }

    public static CatalogoRegiao getInstance() {  // Singleton
        if (INSTANCE == null) {
            INSTANCE = new CatalogoRegiao();
        }
        return INSTANCE;
    }

    public void adicionarRegiao(Regiao regiao) {
        catRegiao.add(regiao);
    }

    public List<Regiao> getRegioes() {
        return catRegiao;
    }

    public Regiao getRegiao(String nome) {
        return catRegiao.stream().filter(reg -> reg.getNome().equals(nome)).findFirst().get();
    }

    public boolean isValidRegiao(String regiao) {
        return catRegiao.stream().anyMatch(reg -> reg.getNome().equals(regiao));
    }

}
