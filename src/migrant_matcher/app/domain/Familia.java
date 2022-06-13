package migrant_matcher.app.domain;

import java.util.LinkedList;
import java.util.List;

public class Familia extends Migrante {

    private List<Membro> membros = new LinkedList<Membro>();;
    
	public Familia(int nTelefone, String nomeChefeCasal) {
		super(nTelefone, nomeChefeCasal);
        //membros.add(new Membro(nomeChefeCasal));
	}

    public List<Membro> getMembros() {
        return membros;
    }

    public void adicionarMembro(Membro membro) {
        membros.add(membro);
    }
    
}