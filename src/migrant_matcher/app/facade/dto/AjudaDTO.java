package migrant_matcher.app.facade.dto;

import java.time.LocalDate;

import migrant_matcher.app.domain.Ajuda;

public class AjudaDTO {

    private int id;
    private String ownerNr;
    private LocalDate data;

    public AjudaDTO(Ajuda ajuda) {
        this.ownerNr = ajuda.getOwnerNr();
        this.data = ajuda.getData();
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public String getOwnerNr() {
        return ownerNr;
    }

    public String toString() {
        return this.getClass().getSimpleName() + "{" + "id=" + id + ", data=" + data.toString() + '}';
    }

}
