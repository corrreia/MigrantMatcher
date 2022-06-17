package migrant_matcher.app.facade.dto;

import java.util.List;
import java.util.stream.Collectors;

import migrant_matcher.app.domain.Familia;

/**
 * Classe que representa um DTO de Familia.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class FamDTO extends MigDTO{
    
    private List<MembroDTO> membros;

    /**
     * Construtor de FamDTO.
     * 
     * @param nomeChefeCasal nome do chefe de casales da família
     * @param nrTelefoneChefeCasal número de telemóvel do chefe de casal
     * @param membros lista de membros da família
     */
    public FamDTO(String nomeChefeCasal, String nrTelefoneChefeCasal, List<MembroDTO> membros) {
        super(nomeChefeCasal, nrTelefoneChefeCasal);
        this.membros = membros;
    }

    /**
     * Construtor de um DTO de familia
     * 
     * @param fam objeto familia a ser convertido para DTO
     */
    public FamDTO(Familia fam){
        super(fam);
        this.membros = fam.getMembros().stream().map(m -> new MembroDTO(m.getNome())).collect(Collectors.toList());
    }

    /**
     * Método que retorna a lista de membros da familia
     * 
     * @return a lista de membros da família
     */
    public List<MembroDTO> getMembros() {
        return this.membros;
    }

    /**
     * Método que retorna o tamanho da familia
     * 
     * @return o tamanho da família
     */
    public int getFamiliaSize() { 
        return this.membros.size() + 1; 
    }

    
    /** 
     * Método que imprime um DTO de Familia.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "FamDTO [membros=" + membros + "]";
    }

    

}