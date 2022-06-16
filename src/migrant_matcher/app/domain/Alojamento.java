package migrant_matcher.app.domain;

public class Alojamento extends Ajuda{
    
    private int nPessoas;
    private Regiao regiao;

    public Alojamento(String ownerNr ,int nPessoas, Regiao regiao) {
        super(ownerNr);
        this.nPessoas = nPessoas;
        this.regiao = regiao;
    }

    public Alojamento(String ownerNr ,int nPessoas) {
        super(ownerNr);
        this.nPessoas = nPessoas;
    }

    public int getnPessoas() {
        return nPessoas;
    }

    public void setnPessoas(int nPessoas) {
        this.nPessoas = nPessoas;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    @Override
    public String toString() {
        return "Alojamento [nPessoas=" + nPessoas + ", regiao=" + regiao + ", contactoProprietario: " + super.getOwnerNr() + ", data:" + 
        super.getData() + ", id:" + super.getId() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + nPessoas;
        result = prime * result + ((regiao == null) ? 0 : regiao.hashCode());
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
        Alojamento other = (Alojamento) obj;
        if (nPessoas != other.nPessoas)
            return false;
        if (regiao == null) {
            if (other.regiao != null)
                return false;
        } else if (!regiao.equals(other.regiao))
            return false;
        return true;
    }

    



}
