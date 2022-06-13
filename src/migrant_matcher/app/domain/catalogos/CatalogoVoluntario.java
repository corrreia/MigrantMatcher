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

    public void adicionarVoluntarios(Voluntario voluntario){
        catVoluntario.add(voluntario);
    }

    public List<Voluntario> getVoluntarios() {
        return catVoluntario;
    }
}