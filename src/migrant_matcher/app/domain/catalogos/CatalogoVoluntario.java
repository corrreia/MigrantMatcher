package migrant_matcher.app.domain.catalogos;

import java.util.LinkedList;
import java.util.List;
import migrant_matcher.app.domain.Voluntario;
import migrant_matcher.app.facade.dto.VolDTO;

/**
 * Classe que representa um objeto CatalogoVoluntario.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class CatalogoVoluntario {
    
    List<Voluntario> catVoluntario;
    private static CatalogoVoluntario INSTANCE;
    
    /**
     * Construtor de CatalogoVoluntario.
     */
    private CatalogoVoluntario() {
        catVoluntario = new LinkedList<Voluntario>();
    }

    
    /** 
     * Método que devolve a instancia do catalogo
     * 
     * @return CatalogoVoluntario   instancia do catalogo
     */
    public static CatalogoVoluntario getInstance() {  // Singleton
        if (INSTANCE == null) {
            INSTANCE = new CatalogoVoluntario();
        }
        return INSTANCE;
    }

    
    /** 
     * Método que adiciona um voluntario ao catalogo
     * 
     * @param voluntario    voluntario a adicionar
     * @return Voluntario   voluntario adicionado
     */
    public Voluntario adicionarVoluntario(Voluntario voluntario){
        if(!catVoluntario.contains(voluntario)){
            catVoluntario.add(voluntario);
            return voluntario;
        }
        return null;
    }

    
    /** 
     * Método que retorna uma lista com os voluntarios no
     * catalogo
     * 
     * @return List<Voluntario>  lista de voluntarios do catalogo
     */
    public List<Voluntario> getVoluntarios() {
        return catVoluntario;
    }

    
    /** 
     * Método que verifica se um voluntario já está no catalogo
     * 
     * @param voluntario    voluntario a verificar
     * @return boolean      true se o voluntario estiver no catalogo, false caso contrario
     */
    public boolean voluntarioExistente(VolDTO voluntario) {
        return catVoluntario.stream().anyMatch(v -> v.getNumeroTelefone().equals(voluntario.getNrTelefone()));
    }

	
    /** 
     * Método que retorna um voluntario através do seu DTO
     * 
     * @param voluntario    voluntario a procurar
     * @return Voluntario   voluntario procurado
     */
    public Voluntario getVoluntario(VolDTO voluntario) {
		return catVoluntario.stream().filter(v -> v.getNumeroTelefone().equals(voluntario.getNrTelefone())).findFirst().get();

	}

    /**
     * Método que limpa o catalogo
     * Apenas para Testes
     */
    public void wipeCatalogo(){
        if(catVoluntario.size() > 0){
            catVoluntario.clear();
        }
    }

    
    /** 
     * Método que imprime o catalogo
     * @return String   catalogo
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Voluntario v : catVoluntario) {
            sb.append(v.toString() + "\n");
        }
        return sb.toString();
    }
}