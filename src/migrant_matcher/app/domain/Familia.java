package migrant_matcher.app.domain;

import java.util.LinkedList;
import java.util.List;

public class Familia extends Migrante {

    private List<Membro> membros = new LinkedList<Membro>();;
    
	public Familia(String nTelefone, String nomeChefeCasal) {
		super(nTelefone, nomeChefeCasal);
        //membros.add(new Membro(nomeChefeCasal));
	}

    public List<Membro> getMembros() {
        return membros;
    }

    public void addMembro(Membro membro) {
        membros.add(membro);
    }

    public int getQuantidadeMembros() {
        return membros.size();
    }

    @Override
    public String toString() {
        return "Familia [membros=" + membros + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((membros == null) ? 0 : membros.hashCode());
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
        Familia other = (Familia) obj;
        if (membros == null) {
            if (other.membros != null)
                return false;
        } else if (!membros.equals(other.membros))
            return false;
        return true;
    }

    
    
}