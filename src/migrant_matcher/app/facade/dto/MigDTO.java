package migrant_matcher.app.facade.dto;

import migrant_matcher.app.domain.Migrante;

public class MigDTO {
    
    private String nome;
    private String nrTelefone;
    

    public MigDTO(String nome, String nrTelefone) {
        this.nome = nome;
        this.nrTelefone = nrTelefone;
    }

    public MigDTO(Migrante migrante) {
        this.nome = migrante.getNome();
        this.nrTelefone = migrante.getNTelefone();
    }

    public String getNome() {
        return nome;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public String toString() {
        return "MigDTO{" + "nome=" + nome + ", nrTelefone=" + nrTelefone + '}' + "\n";
    }
    

}