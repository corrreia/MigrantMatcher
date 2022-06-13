package migrant_matcher.app.domain;

public class Alojamento extends Ajuda{
    
    private int nPessoas;
    private Regiao regiao;

    public Alojamento(int nPessoas, Regiao regiao) {
        super();
        this.nPessoas = nPessoas;
        this.regiao = regiao;
    }

    public Alojamento(int nPessoas) {
        super();
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
        return "Alojamento{id=" + super.getId() + ", nPessoas=" + nPessoas + ", regiao=" + regiao + ", data=" + super.getData().toString() + '}';
    }

}
