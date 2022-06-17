package migrant_matcher.app.domain;

/**
 * Classe que representa um objeto de Alojamento.
 *
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class Alojamento extends Ajuda{
    
    private int nPessoas;
    private Regiao regiao;

    /**
     * Construtor de Alojamento.
     * 
     * @param ownerNr número de telemóvel do dono da ajuda
     * @param nPessoas número de pessoas que o alojamento oferece
     * @param regiao região do alojamento
     */
    public Alojamento(String ownerNr ,int nPessoas, Regiao regiao) {
        super(ownerNr);
        this.nPessoas = nPessoas;
        this.regiao = regiao;
    }

    /**
     * Constructor de Alojamento.
     * 
     * @param ownerNr número de telemóvel do dono da ajuda
     * @param nPessoas número de pessoas que o alojamento oferece
     */
    public Alojamento(String ownerNr ,int nPessoas) {
        super(ownerNr);
        this.nPessoas = nPessoas;
    }

    /**
     * Getter do número de pessoas que o alojamento oferece
     * 
     * @return número de pessoas
     */
    public int getnPessoas() {
        return nPessoas;
    }

    /**
     * Getter da região do alojamento
     * 
     * @param nPessoas  número de pessoas que o alojamento oferece
     */
    public void setnPessoas(int nPessoas) {
        this.nPessoas = nPessoas;
    }

    /**
     * Getter da região do alojamento
     * 
     * @return região   região do alojamento
     */
    public Regiao getRegiao() {
        return regiao;
    }

    /**
     * Setter da região do alojamento
     * 
     * @param regiao região
     */
    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    
    /** 
     * Método que imprime um alojamento
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "Alojamento [nPessoas=" + nPessoas + ", regiao=" + regiao + ", contactoProprietario=" + super.getOwnerNr() + ", data=" + 
        super.getData() + ", id=" + super.getId() + "]";
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + nPessoas;
        result = prime * result + ((regiao == null) ? 0 : regiao.hashCode());
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
