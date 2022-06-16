package migrant_matcher.app.domain;

/**
 * Classe que representa um objeto de Item.
 */
public class Item extends Ajuda {
    
    private String descricao;

    /**
     * Construtor de Item.
     * @param ownerNr número de telemóvel do dono da ajuda
     * @param descricao descrição do item
     */
    public Item(String ownerNr,String descricao) {
        super(ownerNr);
        this.descricao = descricao;
    }

    /**
     * Setter da descrição do item.
     * @param descricao descrição do item
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Getter da descrição do item.
     * @return descrição do item
     */
    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Item [descricao=" + descricao + ", contactoProprietario=" + super.getOwnerNr() + ", data=" + 
        super.getData() + ", id=" + super.getId() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        return true;
    }

}