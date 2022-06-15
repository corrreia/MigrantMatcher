package migrant_matcher.app.handlers;

import java.util.List;

import migrant_matcher.app.domain.Ajuda;
import migrant_matcher.app.domain.Migrante;
import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.domain.catalogos.CatalogoAjudas;
import migrant_matcher.app.domain.catalogos.CatalogoRegiao;
import migrant_matcher.app.domain.factory.SmsFactory;

public class PedirAjudaHandler {
     
    private Migrante m;
    private List<Ajuda> ajudasRegiao;
    List<Ajuda> ajudasSelecionadas;

    public PedirAjudaHandler(Migrante m) {
        this.m = m;
    }

    public List<Regiao> regioesDisponiveis() {
        //expression to get the list of regions available for the migrant from catalogoRegiao
        return CatalogoRegiao.getInstance().getRegioes();
    }

    public List<Ajuda> indicarRegiao(String nome){
        if(CatalogoRegiao.getInstance().isValidRegiao(nome)){
            Regiao reg = CatalogoRegiao.getInstance().getRegiao(nome);

            this.ajudasRegiao.addAll(CatalogoAjudas.getInstance().getAlojamentosByRegion(reg));
            this.ajudasRegiao.addAll(CatalogoAjudas.getInstance().getItems());
        }

        return this.ajudasRegiao;
    }

    public void indicarAjuda(Ajuda ajuda){
        this.ajudasSelecionadas.add(ajuda);
    }

    public boolean confirmarSelecao(){
        if(this.ajudasSelecionadas.size() > 0){
            this.m.setAjudasUsadas(this.ajudasSelecionadas);

            for(Ajuda a : this.ajudasSelecionadas){                
                SmsFactory.getInstance().sendSms(a.getOwnerNr(), "\n-=MIGRANTMATCHER=-\nAtenção! A ajuda que disponibilizou no MigrantMatcher foi selecionada por um migrante. \n" 
                + "Pode entrar em contacto com o mesmo/a pelo número de telemóvel: " + m.getNTelefone());
            }
            return true;
        }
        return false;
    }

    








}