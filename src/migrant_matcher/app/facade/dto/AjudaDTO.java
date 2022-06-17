package migrant_matcher.app.facade.dto;

import java.time.LocalDateTime;

import migrant_matcher.app.domain.Ajuda;

/**
 * Classe que representa um DTO de Ajuda.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class AjudaDTO {

    private int id;
    private String ownerNr;
    private LocalDateTime data;

    /**
     * Construtor de AjudaDTO.
     * 
     * @param ajuda objeto ajuda a ser convertido para DTO
     */
    public AjudaDTO(Ajuda ajuda) {
        this.ownerNr = ajuda.getOwnerNr();
        this.data = ajuda.getData();
        this.id = ajuda.getId();
    }

    /**
     * Método que retorna o id da ajuda.
     * 
     * @return o id
     */
    public int getId() {
        return id;
    }

    /**
     * Método que retorna a data atual
     * 
     * @return a data de criação da ajuda
     */
    public LocalDateTime getData() {
        return data;
    }

    /**
     * Método que retorna o número do dono da ajuda.
     * 
     * @return o número de telemóvel do dono da ajuda
     */
    public String getOwnerNr() {
        return ownerNr;
    }
    
    
    /** 
     * Método que imprime um DTO de Ajuda.
     * 
     * @return String   - String que representa o DTO de Ajuda
     */
    public String toString() {
        return this.getClass().getSimpleName() + "{" + "id=" + id + ", data=" + data.toString() + '}';
    }

}
