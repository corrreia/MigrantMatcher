package migrant_matcher.app.domain;

public class Item extends Ajuda {
    
    private String descricao;

    public Item(String descricao) {
        super();
        this.descricao = descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}