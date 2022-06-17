package migrant_matcher.app.facade.dto;

import migrant_matcher.app.domain.Migrante;

/**
 * Classe que representa um DTO de Migrante.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
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
     * Construtor de um migrante DTO a partir de um migrante.
     * 
     * @return o nome do migrante
     */
    public MigDTO(Migrante migrante) {
        this.nome = migrante.getNome();
        this.nrTelefone = migrante.getNTelefone();
    }

    /**
     * Método que retorna o nome de um migranteDTO.	
     * 
     * @return o nome do migrante
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que retorna o nrTelefone de um migranteDTO.
     * 
     * @return o número de telefone do migrante
     */
    public String getNrTelefone() {
        return nrTelefone;
    }

    
    /** 
     * Método que imprime um migranteDTO
     * 
     * @return String   o que é impresso
     */
    public String toString() {
        return "MigDTO{" + "nome=" + nome + ", nrTelefone=" + nrTelefone + '}' + "\n";
    }
    

}