package migrant_matcher.app.facade.dto;

/**
 * Classe que representa um DTO de Membro.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class MembroDTO {

    private String nome;

    /**
     * Construtor de MembroDTO.
     * 
     * @param membro objeto membro a ser convertido para DTO
     */
    public MembroDTO(String nome){
        this.nome = nome;
    }

    /**
     * Método que retorna o nome de um membroDTO.
     *
     * @return o nome do membro
     */
    public String getNome() {
        return nome;
    }

    
    /** 
     * Método que imprime um membroDTO
     * 
     * @return String   o nome do membro
     */
    @Override
    public String toString(){
        return "Nome: " + nome + "\n";
    }
}