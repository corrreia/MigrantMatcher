package migrant_matcher.app.domain;

/** 
 * Classe que representa um objeto de Membro.
 */
public class Membro {
    private String nome;

    /**
     * Construtor de Membro.
     * @param nome nome do membro
     */
    public Membro(String nome) {
        this.nome = nome;
    }

    /**
     * Getter do nome do membro
     * @return nome do membro
     */
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Membro [nome=" + nome + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        Membro other = (Membro) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    
}
