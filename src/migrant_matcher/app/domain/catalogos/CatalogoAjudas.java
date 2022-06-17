package migrant_matcher.app.domain.catalogos;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import migrant_matcher.app.domain.Ajuda;
import migrant_matcher.app.domain.Alojamento;
import migrant_matcher.app.domain.Item;
import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.facade.dto.AjudaDTO;

/**
 * Classe que representa um objeto CatalogoAjudas.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class CatalogoAjudas {
    
    private static List<Ajuda> catAjudas;
    private static CatalogoAjudas INSTANCE;
    private int idCounter = 0;

    /** 
     * Construtor de CatalogoAjudas.
     */
    private CatalogoAjudas() {
        catAjudas = new LinkedList<Ajuda>();
    }

    
    /** 
     * Método que retorna a instancia do catalogo
     *     
     * @return CatalogoAjudas   instancia do catalogo
     */
    public static CatalogoAjudas getInstance() {  // Singleton
        if (INSTANCE == null) {
            INSTANCE = new CatalogoAjudas();
        }
        return INSTANCE;
    }

    
    /** 
     * Método que adiciona uma ajuda ao catalogo
     * 
     * @param ajuda ajuda a adicionar
     */
    public void adicionarAjuda(Ajuda ajuda) {
        ajuda.setId(idCounter);
        idCounter++;
        catAjudas.add(ajuda);
    }

    
    /** 
     * Método que retorna apenas os items do catalogo de ajudas
     * 
     * @return List<Ajuda>  lista de items
     */
    public List<Ajuda> getItems() {
        //filter only Itens 
        return catAjudas.stream().filter(ajuda -> ajuda instanceof Item).collect(Collectors.toList());
    }

    
    /** 
     * Método que retorna alojamentos numa certa região
     *      
     * @param reg               região a procurar
     * @return List<Ajuda>      lista de alojamentos
     */
    public List<Ajuda> getAlojamentosByRegion(Regiao reg) {
        //filter only Alojamentos by regiao
        return catAjudas.stream().filter(ajuda -> ajuda instanceof Alojamento && ((Alojamento) ajuda).getRegiao().equals(reg)).collect(Collectors.toList());
    }

    
    /** 
     * Método que retorna a lista de todas as ajudas
     * 
     * @return List<Ajuda>  lista de ajudas
     */
    public List<Ajuda> getAjudas(){
        return catAjudas;
    }

    
    /** 
     * Método que retorna uma lista de ajudaDTOs
     * 
     * @return List<AjudaDTO>   lista de ajudaDTOs
     */
    public List<AjudaDTO> getAjudasDTO() {
        return catAjudas.stream().map(AjudaDTO::new).collect(Collectors.toList());
    }

    
    /** 
     * Método que encontra uma ajuda no catalogo pelo seu id
     * 
     * @param id        id da ajuda a procurar
     * @return Ajuda    ajuda encontrada               
     */
    public Ajuda getAjudaById(int id) {
        return catAjudas.stream().filter(ajuda -> ajuda.getId() == id).findFirst().get();
    }

    
    /** 
     * Método que encontra a uma ajuda no catalogo atraves do seu DTO
     * 
     * @param ajuda     ajudaDTO a procurar
     * @return Ajuda    ajuda encontrada
     */
    public Ajuda getAjuda(AjudaDTO ajuda) {
        return catAjudas.stream().filter(aj -> aj.getId() == ajuda.getId()).findFirst().get();
    }

    
    /** 
     * Método que retorna o tamanho do catalogo de ajudas
     * 
     * @return int    tamanho do catalogo
     */
    public int sizeCatalogo() {
        return catAjudas.size();
    }

    /**
     * Método que limpa o Catalogo
     * Apenas para testes
     */
    public void wipeCatalogo(){
        if(catAjudas.size() > 0){
            catAjudas.clear();
        }
        idCounter = 0;
    }

    /**
     * Método que já shuffle a um catalogo
     */
    public void shuffleCatalogo(){
        Collections.shuffle(catAjudas);
    }
    
    /** 
     * Método que imprime o catalogo
     * 
     * @return String
     */
    public String toString(){
        StringBuilder bob = new StringBuilder();
        for(Ajuda ajuda : catAjudas){
            bob.append(ajuda.toString() + "\n");
        }
        return bob.toString();
    }

    
    /** 
     * Método que remove uma ajuda do catalogo
     * 
     * @param a ajuda a remover
     */
    public void removeAjuda(Ajuda a) {
        catAjudas.remove(a);
    }
}
