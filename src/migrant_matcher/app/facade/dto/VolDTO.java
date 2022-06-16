package migrant_matcher.app.facade.dto;

import migrant_matcher.app.domain.Voluntario;

public class VolDTO {

    private String nrTelefone;

    public VolDTO(Voluntario voluntario) {
        this.nrTelefone = voluntario.getNumeroTelefone();
    }

    public VolDTO (String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public String toString() {
        return "VolDTO{" +
                "nrTelefone='" + nrTelefone + '\'' +
                '}' + "\n";
    }

}