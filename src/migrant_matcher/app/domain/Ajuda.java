package migrant_matcher.app.domain;

import java.time.LocalDate;

public class Ajuda {

    private int id;
    private String ownerNr;
    private LocalDate data;

    public Ajuda(String ownerNr) {
        this.ownerNr = ownerNr;
        this.data = LocalDate.now();
    }

    public void setId(int id) {
        this.id = id;
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