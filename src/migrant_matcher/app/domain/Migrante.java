package migrant_matcher.app.domain;

import java.util.LinkedList;
import java.util.List;

import migrant_matcher.app.domain.catalogos.CatalogoAjudas;

public class Migrante {
    
    private String nTelefone;
    private String nome;
    private List<Ajuda> ajudasUsadas;

    public Migrante(String nTelefone, String nome) {
        this.nTelefone = nTelefone;
        this.nome = nome;
        this.ajudasUsadas = new LinkedList<Ajuda>();
    }

    public String getNTelefone() {
        return nTelefone;
    }

    public String getNome() {
        return nome;
    }

    public void addAjudasUsadas(List<Ajuda> ajudasSelecionadas) {
        this.ajudasUsadas.addAll(ajudasSelecionadas);
        //remove them from the catalogo
        for(Ajuda a: ajudasSelecionadas){
            CatalogoAjudas.getInstance().removeAjuda(a);
        }
    }

    public List<Ajuda> getAjudasUsadas() {
        return ajudasUsadas;
    }

    @Override
    public String toString() {
        return "Migrante [ajudasUsadas=" + ajudasUsadas + ", nTelefone=" + nTelefone + ", nome=" + nome + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ajudasUsadas == null) ? 0 : ajudasUsadas.hashCode());
        result = prime * result + ((nTelefone == null) ? 0 : nTelefone.hashCode());
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
        Migrante other = (Migrante) obj;
        if (ajudasUsadas == null) {
            if (other.ajudasUsadas != null)
                return false;
        } else if (!ajudasUsadas.equals(other.ajudasUsadas))
            return false;
        if (nTelefone == null) {
            if (other.nTelefone != null)
                return false;
        } else if (!nTelefone.equals(other.nTelefone))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    
}
