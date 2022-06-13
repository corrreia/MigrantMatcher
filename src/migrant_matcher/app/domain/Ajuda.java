package migrant_matcher.app.domain;

import java.time.LocalDate;

public class Ajuda {

    private int id;
    private LocalDate data;

    public Ajuda() {
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

    public String toString() {
        return this.getClass().getSimpleName() + "{" + "id=" + id + ", data=" + data.toString() + '}';
    }

}