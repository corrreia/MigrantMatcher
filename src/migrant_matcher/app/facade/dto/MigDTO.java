package migrant_matcher.app.facade.dto;

import migrant_matcher.app.domain.Migrante;

/**
 * Classe que representa um DTO de Migrante.
 *
 */
public class MigDTO {
    
    private String nome;
    private String nrTelefone;
    
    /**
     * Construtor de MigDTO.
     * @param migrante objeto migrante a ser convertido para DTO
     */
    public MigDTO(String nome, String nrTelefone) {
        this.nome = nome;
        this.nrTelefone = nrTelefone;
    }

    /**
     * @return o nome do migrante
     */
    public MigDTO(Migrante migrante) {
        this.nome = migrante.getNome();
        this.nrTelefone = migrante.getNTelefone();
    }

    /**
     * @return o nome do migrante
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return o número de telefone do migrante
     */
    public String getNrTelefone() {
        return nrTelefone;
    }

    public String toString() {
        return "MigDTO{" + "nome=" + nome + ", nrTelefone=" + nrTelefone + '}' + "\n";
    }
    

}