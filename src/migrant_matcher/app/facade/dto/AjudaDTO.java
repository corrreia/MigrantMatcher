package migrant_matcher.app.facade.dto;

import java.time.LocalDateTime;

import migrant_matcher.app.domain.Ajuda;

public class AjudaDTO {

    private int id;
    private String ownerNr;
    private LocalDateTime data;

    public AjudaDTO(Ajuda ajuda) {
        this.ownerNr = ajuda.getOwnerNr();
        this.data = ajuda.getData();
        this.id = ajuda.getId();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getOwnerNr() {
        return ownerNr;
    }

    public String toString() {
        return this.getClass().getSimpleName() + "{" + "id=" + id + ", data=" + data.toString() + '}';
    }

}
