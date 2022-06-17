package migrant_matcher.app.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * Classe que representa um objeto de Familia.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class Familia extends Migrante {

    private List<Membro> membros = new LinkedList<Membro>();;
    
    /**
     * Construtor de Familia.
     * 
     * @param nTefefone número de telemóvel do dono da familia
     * @param nomeChefeCasal nome do chefe da familia
     */
	public Familia(String nTelefone, String nomeChefeCasal) {
		super(nTelefone, nomeChefeCasal);
        //membros.add(new Membro(nomeChefeCasal));
	}

    /**
     * Getter da lista de membros da familia
     * 
     * @return lista de membros
     */
    public List<Membro> getMembros() {
        return membros;
    }

    /**
     * Adiciona um membro à lista de membros da familia
     * 
     * @param membro membro a adicionar
     */
    public void addMembro(Membro membro) {
        membros.add(membro);
    }

    /**
     * Método que retorna o numero de membros da familia
     * 
     * @return quantidade de membros da familia
     */
    public int getQuantidadeMembros() {
        return membros.size() + 1;
    }

    
    /** 
     * Método que imprime uma familia
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Familia [membros=" + membros + "]";
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((membros == null) ? 0 : membros.hashCode());
        return result;
    }

    
    /** 
     * @param obj
     * @return boolean
     */
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