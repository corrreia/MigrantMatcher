package migrant_matcher.app.facade.dto;

import migrant_matcher.app.domain.Item;

/**
 * Classe que representa um DTO de Item.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class ItemDTO extends AjudaDTO {
    
    private String descricao;

    /**
     * Construtor de ItemDTO.
     * 
     * @param item objeto item a ser convertido para DTO
     */
    public ItemDTO(Item item) {
        super(item);
        this.descricao = item.getDescricao();
    }

    /**
     * Retorna a descrição de um itemDTO.
     * 
     * @return a descrição do item
     */
    public String getDescricao() {
        return descricao;
    }

}
