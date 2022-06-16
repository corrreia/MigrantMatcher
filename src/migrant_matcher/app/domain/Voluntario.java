package migrant_matcher.app.domain;

public class Voluntario {
    
    private String contactNumber;

    public Voluntario(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNumeroTelefone() {
        return this.contactNumber;
    }

    @Override
    public String toString() {
        return "Voluntario [contactNumber=" + contactNumber + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
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
        Voluntario other = (Voluntario) obj;
        if (contactNumber == null) {
            if (other.contactNumber != null)
                return false;
        } else if (!contactNumber.equals(other.contactNumber))
            return false;
        return true;
    }

    
}
