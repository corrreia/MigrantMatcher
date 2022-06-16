package migrant_matcher.app.facade.dto;

import migrant_matcher.app.domain.Voluntario;

/**
 * Classe que representa um DTO de Voluntario.
 *
 */
public class VolDTO {

    private String nrTelefone;

    /**
     * Construtor de VolDTO.
     * @param voluntario objeto voluntario a ser convertido para DTO
     */
    public VolDTO(Voluntario voluntario) {
        this.nrTelefone = voluntario.getNumeroTelefone();
    }

    /**
     * @param numeroTelefone string numeroTelefone a ser convertido para DTO
     */
    public VolDTO (String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    /**
     * @return o número de telefone do voluntario
     */
    public String getNrTelefone() {
        return nrTelefone;
    }

    public String toString() {
        return "VolDTO{" +
                "nrTelefone='" + nrTelefone + '\'' +
                '}' + "\n";
    }

}