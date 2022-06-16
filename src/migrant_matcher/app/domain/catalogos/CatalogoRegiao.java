package migrant_matcher.app.domain.catalogos;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.facade.dto.RegiaoDTO;

public class CatalogoRegiao {
    private static List<Regiao> catRegiao;
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

    public static List<Regiao> getRegioes() {
        return catRegiao;
    }

    public static List<RegiaoDTO> getRegioesDTO() {
        return catRegiao.stream().map(RegiaoDTO::new).collect(Collectors.toList());
    }

    public Regiao getRegiao(RegiaoDTO reg) {
        return catRegiao.stream().filter(r -> r.getNome().equals(reg.getNome())).findFirst().get();
    }

    public boolean isValidRegiao(RegiaoDTO reg) {
        return catRegiao.stream().anyMatch(r -> r.getNome().equals(reg.getNome()));
    }

    public void wipeCatalogo(){
        if(catRegiao.size() > 0){
            catRegiao.clear();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Regiao r : catRegiao) {
            sb.append(r.toString() + "\n");
        }
        return sb.toString();
    }

}
