package migrant_matcher.app.facade.dto;

import migrant_matcher.app.domain.Regiao;

public class RegiaoDTO {
    
    private String name;

    public RegiaoDTO(Regiao r) {
        this.name = r.getNome();
    }

    public RegiaoDTO(String regiao) {
        this.name = regiao;
    }

	public String getNome() {
        return name;
    }

    public String toString() {
        return name + "\n";
    }
}
