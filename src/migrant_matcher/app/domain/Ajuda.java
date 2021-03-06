package migrant_matcher.app.domain;

import java.time.LocalDateTime;

/**
 * Classe que representa um objeto de Ajuda.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class Ajuda {

    private int id;
    private String ownerNr;
    private LocalDateTime data;

    /**
     * Construtor de Ajuda.
     * 
     * @param ownerNr número de telemóvel do dono da ajuda
     */
    public Ajuda(String ownerNr) {
        this.ownerNr = ownerNr;
        this.data = LocalDateTime.now();
    }

    /**
     * Setter do id.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter do id.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter do data de criaçao da ajuda
     * 
     * @return  data de criaçao da ajuda
     */
    public LocalDateTime getData() {
        return data;
    }

    /**
     * Getter do número de telemóvel do dono da ajuda
     * 
     * @return número de telemóvel do dono da ajuda
     */
    public String getOwnerNr() {
        return ownerNr;
    }


    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + id;
        result = prime * result + ((ownerNr == null) ? 0 : ownerNr.hashCode());
        return result;
    }

    
    /** 
     * @param obj
     * @return boolean
     */
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