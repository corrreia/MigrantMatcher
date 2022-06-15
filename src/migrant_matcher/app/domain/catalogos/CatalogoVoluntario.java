package migrant_matcher.app.domain.catalogos;

import java.util.LinkedList;
import java.util.List;
import migrant_matcher.app.domain.Voluntario;

public class CatalogoVoluntario {
    
    List<Voluntario> catVoluntario;
    private static CatalogoVoluntario INSTANCE;
    
    private CatalogoVoluntario() {
        catVoluntario = new LinkedList<Voluntario>();
    }

    public static CatalogoVoluntario getInstance() {  // Singleton
        if (INSTANCE == null) {
            INSTANCE = new CatalogoVoluntario();
        }
        return INSTANCE;
    }

    public boolean adicionarVoluntarios(Voluntario voluntario){
        if(!catVoluntario.contains(voluntario)){
            catVoluntario.add(voluntario);
            return true;
        }
        return false;
    }

    public List<Voluntario> getVoluntarios() {
        return catVoluntario;
    }

    public boolean voluntarioExistente(String nTelefone) {
        return catVoluntario.stream().anyMatch(v -> v.getNumeroTelefone().equals(nTelefone));
    }

	public Voluntario getVoluntario(String nTelefone) {
		return catVoluntario.stream().filter(v -> v.getNumeroTelefone().equals(nTelefone)).findFirst().get();
	}
}