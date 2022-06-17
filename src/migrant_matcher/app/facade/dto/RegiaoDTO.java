package migrant_matcher.app.facade.dto;

import migrant_matcher.app.domain.Regiao;

/**
 * Classe que representa um DTO de Regiao.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class RegiaoDTO {
    
    private String name;

    /**
     * Construtor de RegiaoDTO.
     * 
     * @param regiao objeto regiao a ser convertido para DTO
     */
    public RegiaoDTO(Regiao r) {
        this.name = r.getNome();
    }

    /**
     * Construtor de RegiaoDTO.
     * 
     * @param regiao string regiao a ser convertido para DTO
     */
    public RegiaoDTO(String regiao) {
        this.name = regiao;
    }

    /**
     * Método que retorna o nome de um regiaoDTO.
     * 
     * @return o nome da regiao
     */
	public String getNome() {
        return name;
    }

    
    /** 
     * Método que imprime um regiaoDTO
     * 
     * @return String   o nome da regiao
     */
    public String toString() {
        return name + "\n";
    }
}
