package migrant_matcher.app.facade.dto;

import migrant_matcher.app.domain.Alojamento;

public class AlojDTO extends AjudaDTO {

    private int nPessoas;
    private RegiaoDTO regiao;

    public AlojDTO(Alojamento alojamento) {
        super(alojamento);
        this.nPessoas = alojamento.getnPessoas();
    }

    public int getnPessoas() {
        return nPessoas;
    }

    public RegiaoDTO getRegiao() {
        return regiao;
    }

    @Override
    public String toString() {
        return "Alojamento{id=" + super.getId() + ", nPessoas=" + nPessoas + ", regiao=" + regiao + ", data=" + super.getData().toString() + '}';
    }
    
}
