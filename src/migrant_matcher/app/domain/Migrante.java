package migrant_matcher.app.domain;

import java.util.List;

public class Migrante {
    
    private int nTelefone;
    private String nome;
    private List<Ajuda> ajudasUsadas;

    public Migrante(int nTelefone, String nome) {
        this.nTelefone = nTelefone;
        this.nome = nome;
    }

    public int getnTelefone() {
        return nTelefone;
    }

    public String getNome() {
        return nome;
    }

    public void setAjudasUsadas(List<Ajuda> ajudasUsadas) {
        this.ajudasUsadas = ajudasUsadas;
    }

    public List<Ajuda> getAjudasUsadas() {
        return ajudasUsadas;
    }

}
