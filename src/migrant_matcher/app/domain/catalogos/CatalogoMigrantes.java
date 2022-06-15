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
    
    public void registarMigrante(Migrante migrante) {
        catMigrante.add(migrante);
    }

    public boolean migranteExistente(Migrante migrante) {
        return catMigrante.contains(migrante);
    }

    public boolean migranteExistente(String nrTelefone, String nome) {
        return catMigrante.stream().anyMatch(m -> m.getNTelefone().equals(nrTelefone) && m.getNome().equals(nome));
    }

    public Migrante getMigrante(String nrTelefone) {
        return catMigrante.stream().filter(m -> m.getNTelefone().equals(nrTelefone)).findFirst().get();
    }
}
