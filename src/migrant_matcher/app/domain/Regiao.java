package migrant_matcher.app.domain;

/**
 * Classe que representa um objeto Regiao.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class Regiao {
    
    private String name;

    /**
     * Construtor de Regiao.
     * @param name nome da região
     */
    public Regiao(String name) {
        this.name = name;
    }

    /**
     * Getter do nome da região
     * @return nome da região
     */
    public String getNome() {
        return name;
    }

    
    /** 
     * Método que imprime uma Regiao
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Regiao [name=" + name + "]";
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Regiao other = (Regiao) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    
}
