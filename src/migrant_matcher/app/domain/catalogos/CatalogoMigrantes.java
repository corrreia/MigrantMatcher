package migrant_matcher.app.domain.catalogos;

import java.util.LinkedList;
import java.util.List;

import migrant_matcher.app.domain.Migrante;

public class CatalogoMigrantes {
    
    private List<Migrante> catMigrante;
	private static CatalogoMigrantes INSTANCE;

    private CatalogoMigrantes() {
        catMigrante = new LinkedList<Migrante>();
    }

    public static CatalogoMigrantes getInstance() {  // Singleton
        if (INSTANCE == null) {
            INSTANCE = new CatalogoMigrantes();
        }
        return INSTANCE;
    }

    public void adicionarMigrante(Migrante migrante) {
        catMigrante.add(migrante);
    }

    public List<Migrante> getMigrantes() {
        return catMigrante;
    }
    
}
