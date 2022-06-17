package migrant_matcher.app.domain;

/**
 * Classe que representa um objeto Voluntario.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class Voluntario {
    
    private String contactNumber;

    /**
     * Construtor de Voluntario.
     * 
     * @param contactNumber número de contacto do voluntário
     */
    public Voluntario(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Getter do número de contacto do voluntário
     * 
     * @return número de contacto do voluntário
     */
    public String getNumeroTelefone() {
        return this.contactNumber;
    }

    
    /** 
     * Método que imprime um Voluntario
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Voluntario [contactNumber=" + contactNumber + "]";
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
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
        Voluntario other = (Voluntario) obj;
        if (contactNumber == null) {
            if (other.contactNumber != null)
                return false;
        } else if (!contactNumber.equals(other.contactNumber))
            return false;
        return true;
    }

    
}
