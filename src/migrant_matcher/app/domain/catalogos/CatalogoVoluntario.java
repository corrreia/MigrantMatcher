package migrant_matcher.app.domain.catalogos;

import java.util.LinkedList;
import java.util.List;
import migrant_matcher.app.domain.Voluntario;
import migrant_matcher.app.facade.dto.VolDTO;

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

    public Voluntario adicionarVoluntario(Voluntario voluntario){
        if(!catVoluntario.contains(voluntario)){
            catVoluntario.add(voluntario);
            return voluntario;
        }
        return null;
    }

    public List<Voluntario> getVoluntarios() {
        return catVoluntario;
    }

    public boolean voluntarioExistente(VolDTO voluntario) {
        return catVoluntario.stream().anyMatch(v -> v.getNumeroTelefone().equals(voluntario.getNrTelefone()));
    }

	public Voluntario getVoluntario(VolDTO voluntario) {
		return catVoluntario.stream().filter(v -> v.getNumeroTelefone().equals(voluntario.getNrTelefone())).findFirst().get();

	}

    public void wipeCatalogo(){
        if(catVoluntario.size() > 0){
            catVoluntario.clear();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Voluntario v : catVoluntario) {
            sb.append(v.toString() + "\n");
        }
        return sb.toString();
    }
}