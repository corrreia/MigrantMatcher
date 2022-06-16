package migrant_matcher.app.facade.dto;

import migrant_matcher.app.domain.Item;

public class ItemDTO extends AjudaDTO {
    
    private String descricao;

    public ItemDTO(Item item) {
        super(item);
        this.descricao = item.getDescricao();
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
