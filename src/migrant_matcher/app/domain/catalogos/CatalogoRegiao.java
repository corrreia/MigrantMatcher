package migrant_matcher.app.domain.catalogos;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.facade.dto.RegiaoDTO;

/**
 * Classe que representa um objeto CatalogoRegiao.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class CatalogoRegiao {
    private static List<Regiao> catRegiao;
    private static CatalogoRegiao INSTANCE;

    /**
     * Construtor de CatalogoRegiao.
     */
    private CatalogoRegiao() {
        catRegiao = new LinkedList<Regiao>();
    }

    
    /** 
     * Método que retorna a instancia do catalogo
     * 
     * @return CatalogoRegiao   instancia do catalogo
     */
    public static CatalogoRegiao getInstance() {  // Singleton
        if (INSTANCE == null) {
            INSTANCE = new CatalogoRegiao();
        }
        return INSTANCE;
    }

    
    /** 
     * Método que adiciona uma regiao ao catalogo
     * 
     * @param regiao    regiao a adicionar
     */
    public void adicionarRegiao(Regiao regiao) {
        catRegiao.add(regiao);
    }

    
    /** 
     * Método que retorna uma lista de regiões
     * 
     * @return List<Regiao>  lista de regiões
     */
    public static List<Regiao> getRegioes() {
        return catRegiao;
    }

    
    /** 
     * Método que retorna uma lista de regiõesDTO
     * 
     * @return List<RegiaoDTO>  lista de regiõesDTO
     */
    public static List<RegiaoDTO> getRegioesDTO() {
        return catRegiao.stream().map(RegiaoDTO::new).collect(Collectors.toList());
    }

    
    /** 
     * Método que retorna uma região apartir do seu DTO
     * 
     * @param reg       regiaoDTO
     * @return Regiao   região      
     */
    public Regiao getRegiao(RegiaoDTO reg) {
        return catRegiao.stream().filter(r -> r.getNome().equals(reg.getNome())).findFirst().get();
    }

    
    /**
     * Verifica se um certoDTO é uma região valida
     * 
     * @param reg       regiaoDTO
     * @return boolean  true se for valida, false se não for
     */
    public boolean isValidRegiao(RegiaoDTO reg) {
        return catRegiao.stream().anyMatch(r -> r.getNome().equals(reg.getNome()));
    }

    /**
     * Método que limpa o catalogo
     * Apenas para testes
     */
    public void wipeCatalogo(){
        if(catRegiao.size() > 0){
            catRegiao.clear();
        }
    }

    
    /** 
     * Método que imprime o catalogo
     * 
     * @return String   catalogo
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Regiao r : catRegiao) {
            sb.append(r.toString() + "\n");
        }
        return sb.toString();
    }

}
