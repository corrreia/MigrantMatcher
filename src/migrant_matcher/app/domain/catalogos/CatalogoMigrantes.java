package migrant_matcher.app.domain.catalogos;

import java.util.LinkedList;
import java.util.List;

import migrant_matcher.app.domain.Migrante;
import migrant_matcher.app.facade.dto.MigDTO;

/**
 * Classe que representa um objeto CatalogoMigrantes.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class CatalogoMigrantes {
    
    private List<Migrante> catMigrante;
	private static CatalogoMigrantes INSTANCE;

    /**
     * Construtor de CatalogoMigrantes.
     */
    private CatalogoMigrantes() {
        catMigrante = new LinkedList<Migrante>();
    }

    
    /** 
     * Método que retorna a instancia do catalogo
     * 
     * @return CatalogoMigrantes    instancia do catalogo
     */
    public static CatalogoMigrantes getInstance() {  // Singleton
        if (INSTANCE == null) {
            INSTANCE = new CatalogoMigrantes();
        }
        return INSTANCE;
    }

    
    /** 
     * Método que adiciona um migrante ao catalog
     * 
     * @param migrante  migrante a adicionar
     */
    public void adicionarMigrante(Migrante migrante) {
        catMigrante.add(migrante);
    }

    
    /** 
     * Método que retorna uma lista de migrantes do catalogo
     *  
     * @return List<Migrante>   lista de migrantes do catalogo
     */
    public List<Migrante> getMigrantes() {
        return catMigrante;
    }

    /** 
     * Método que verifica se um migrante se encontra no catalogo
     * 
     * @param migrante  migrante a verificar
     * @return boolean  true se o migrante se encontra no catalogo, false caso contrário
     */
    public boolean migranteExistente(MigDTO migrante) {
        return catMigrante.stream().anyMatch(m -> m.getNTelefone().equals(migrante.getNrTelefone()) && m.getNome().equals(migrante.getNome()));
    }

    
    /** 
     * Método que devolve o migrante através do seu DTO
     * 
     * @param migrante  DTO do migrante
     * @return Migrante migrante
     */
    public Migrante getMigrante(MigDTO migrante) {
        return catMigrante.stream().filter(m -> m.getNTelefone().equals(migrante.getNrTelefone()) && m.getNome().equals(migrante.getNome())).findFirst().get();
    }

    /** 
     * Método que limpa o catálogo de migrantes
     * Apenas para Testes.
    */
    public void wipeCatalogo(){
        if(catMigrante.size() > 0){
            catMigrante.clear();
        }
    }

    
    /**
     * Método que imprime um catalogo de migrantes
     * 
     * @return String   string com o catalogo de migrantes
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Migrante migrante : catMigrante) {
            sb.append(migrante.toString() + "\n");
        }
        return sb.toString();
    }
}
