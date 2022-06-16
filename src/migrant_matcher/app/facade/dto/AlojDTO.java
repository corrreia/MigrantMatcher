package migrant_matcher.app.facade.dto;

import migrant_matcher.app.domain.Alojamento;

/**
 * Classe que representa um DTO de Alojamento.
*/
public class AlojDTO extends AjudaDTO {

    private int nPessoas;
    private RegiaoDTO regiao;

    /**
     * Construtor de AlojDTO.
     * @param alojamento objeto alojamento a ser convertido para DTO
     */
    public AlojDTO(Alojamento alojamento) {
        super(alojamento);
        this.nPessoas = alojamento.getnPessoas();
        this.regiao = new RegiaoDTO(alojamento.getRegiao());
    }

    /**
     * @return o número de pessoas que o alojamento oferece
     */
    public int getnPessoas() {
        return nPessoas;
    }

    /**
     * @return a região do alojamento
     */
    public RegiaoDTO getRegiao() {
        return regiao;
    }

    @Override
    public String toString() {
        return "Alojamento{id=" + super.getId() + ", nPessoas=" + nPessoas + ", regiao=" + regiao + ", data=" + super.getData().toString() + '}';
    }
    
}
