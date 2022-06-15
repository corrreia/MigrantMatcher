package migrant_matcher.app.domain;

public class Voluntario {
    
    private String contactNumber;

    public Voluntario(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNumeroTelefone() {
        return this.contactNumber;
    }
}
