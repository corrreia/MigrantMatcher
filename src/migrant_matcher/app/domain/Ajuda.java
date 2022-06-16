package migrant_matcher.app.domain;

import java.time.LocalDateTime;

public class Ajuda {

    private int id;
    private String ownerNr;
    private LocalDateTime data;

    public Ajuda(String ownerNr) {
        this.ownerNr = ownerNr;
        this.data = LocalDateTime.now();
    }

    public void setId(int id) {
        this.id = id;
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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + id;
        result = prime * result + ((ownerNr == null) ? 0 : ownerNr.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ajuda other = (Ajuda) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (id != other.id)
            return false;
        if (ownerNr == null) {
            if (other.ownerNr != null)
                return false;
        } else if (!ownerNr.equals(other.ownerNr))
            return false;
        return true;
    }

    
}