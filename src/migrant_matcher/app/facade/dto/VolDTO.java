package migrant_matcher.app.facade.dto;

import migrant_matcher.app.domain.Voluntario;

/**
 * Classe que representa um DTO de Voluntario.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class VolDTO {

    private String nrTelefone;

    /**
     * Construtor de VolDTO.
     * 
     * @param voluntario objeto voluntario a ser convertido para DTO
     */
    public VolDTO(Voluntario voluntario) {
        this.nrTelefone = voluntario.getNumeroTelefone();
    }

    /**
     * Construtor de um DTO de Voluntario
     * 
     * @param numeroTelefone string numeroTelefone a ser convertido para DTO
     */
    public VolDTO (String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    /**
     * Método que retorna o nrTelefone de um DTO de Voluntario
     * 
     * @return o número de telefone do voluntario
     */
    public String getNrTelefone() {
        return nrTelefone;
    }

    
    /** 
     * Método que imprime um VolDTO
     * 
     * @return String   o que é impresso
     */
    public String toString() {
        return "VolDTO{" +
                "nrTelefone='" + nrTelefone + '\'' +
                '}' + "\n";
    }

}