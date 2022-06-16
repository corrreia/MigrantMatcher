package migrant_matcher.app.facade.dto;

import java.util.List;
import java.util.stream.Collectors;

import migrant_matcher.app.domain.Familia;

/**
 * Classe que representa um DTO de Familia.
 */
public class FamDTO extends MigDTO{
    
    private List<MembroDTO> membros;

    /**
     * Construtor de FamDTO.
     * @param nomeChefeCasal nome do chefe de casales da família
     * @param nrTelefoneChefeCasal número de telemóvel do chefe de casal
     * @param membros lista de membros da família
     */
    public FamDTO(String nomeChefeCasal, String nrTelefoneChefeCasal, List<MembroDTO> membros) {
        super(nomeChefeCasal, nrTelefoneChefeCasal);
        this.membros = membros;
    }

    /**
     * 
     * @param fam objeto familia a ser convertido para DTO
     */
    public FamDTO(Familia fam){
        super(fam);
        this.membros = fam.getMembros().stream().map(m -> new MembroDTO(m.getNome())).collect(Collectors.toList());
    }

    /**
     * @return a lista de membros da família
     */
    public List<MembroDTO> getMembros() {
        return this.membros;
    }

    /**
     * @return o tamanho da família
     * 
     */
    public int getFamiliaSize() { 
        return this.membros.size() + 1; 
    }

    @Override
    public String toString() {
        return "FamDTO [membros=" + membros + "]";
    }

    

}