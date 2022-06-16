package migrant_matcher.app.facade.dto;

import migrant_matcher.app.domain.Regiao;

/**
 * Classe que representa um DTO de Regiao.
 */
public class RegiaoDTO {
    
    private String name;

    /**
     * Construtor de RegiaoDTO.
     * @param regiao objeto regiao a ser convertido para DTO
     */
    public RegiaoDTO(Regiao r) {
        this.name = r.getNome();
    }

    /**
     * @param regiao string regiao a ser convertido para DTO
     */
    public RegiaoDTO(String regiao) {
        this.name = regiao;
    }

    /**
     * @return o nome da regiao
     */
	public String getNome() {
        return name;
    }

    public String toString() {
        return name + "\n";
    }
}
