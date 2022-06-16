package migrant_matcher.app.facade.dto;

/**
 * Classe que representa um DTO de Membro.
 *
 */
public class MembroDTO {

    private String nome;

    /**
     * Construtor de MembroDTO.
     * @param membro objeto membro a ser convertido para DTO
     */
    public MembroDTO(String nome){
        this.nome = nome;
    }

    /**
     * @return o nome do membro
     */
    public String getNome() {
        return nome;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "\n";
    }
}