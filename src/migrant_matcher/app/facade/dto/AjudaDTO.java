package migrant_matcher.app.facade.dto;

import java.time.LocalDateTime;

import migrant_matcher.app.domain.Ajuda;

/**
 * Classe que representa um DTO de Ajuda.
 * 
 */
public class AjudaDTO {

    private int id;
    private String ownerNr;
    private LocalDateTime data;

    /**
     * Construtor de AjudaDTO.
     * @param ajuda objeto ajuda a ser convertido para DTO
     */
    public AjudaDTO(Ajuda ajuda) {
        this.ownerNr = ajuda.getOwnerNr();
        this.data = ajuda.getData();
        this.id = ajuda.getId();
    }

    /**
     * @return o id
     */
    public int getId() {
        return id;
    }

    /**
     * @return a data de criação da ajuda
     */
    public LocalDateTime getData() {
        return data;
    }

    /**
     * 
     * @return o número de telemóvel do dono da ajuda
     */
    public String getOwnerNr() {
        return ownerNr;
    }
    
    public String toString() {
        return this.getClass().getSimpleName() + "{" + "id=" + id + ", data=" + data.toString() + '}';
    }

}
