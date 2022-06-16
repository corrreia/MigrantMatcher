package migrant_matcher.app.facade.dto;

import java.util.List;
import java.util.stream.Collectors;

import migrant_matcher.app.domain.Familia;

public class FamDTO extends MigDTO{
    
    private List<MembroDTO> membros;

    public FamDTO(String nomeChefeCasal, String nrTelefoneChefeCasal, List<MembroDTO> membros) {
        super(nomeChefeCasal, nrTelefoneChefeCasal);
        this.membros = membros;
    }

    public FamDTO(Familia fam){
        super(fam);
        this.membros = fam.getMembros().stream().map(m -> new MembroDTO(m.getNome())).collect(Collectors.toList());
    }

    public List<MembroDTO> getMembros() {
        return this.membros;
    }

    @Override
    public String toString() {
        return "FamDTO [membros=" + membros + "]";
    }

    

}