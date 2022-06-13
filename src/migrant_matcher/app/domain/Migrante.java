package migrant_matcher.app.domain;

public class Migrante {
    
    private int nTelefone;
    private String nome;

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

}
