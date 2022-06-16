package migrant_matcher.app.facade.dto;

public class MembroDTO {

    private String nome;

    public MembroDTO(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String toString(){
        return "Nome: " + nome + "\n";
    }
}