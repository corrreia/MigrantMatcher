package migrant_matcher.app.facade.handlers;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import migrant_matcher.app.domain.Ajuda;
import migrant_matcher.app.domain.Item;
import migrant_matcher.app.domain.Migrante;
import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.domain.Alojamento;
import migrant_matcher.app.domain.catalogos.CatalogoAjudas;
import migrant_matcher.app.domain.catalogos.CatalogoRegiao;
import migrant_matcher.app.domain.factory.OrdAjFactory;
import migrant_matcher.app.domain.factory.SmsFactory;
import migrant_matcher.app.facade.dto.AjudaDTO;
import migrant_matcher.app.facade.dto.AlojDTO;
import migrant_matcher.app.facade.dto.ItemDTO;
import migrant_matcher.app.facade.dto.RegiaoDTO;

public class PedirAjudaHandler{
     
    private Migrante m;
    
    private List<Ajuda> ajudasSelecionadas = new LinkedList<Ajuda>();

    public PedirAjudaHandler(Migrante m) {
        this.m = m;
    }

    public List<RegiaoDTO> regioesDisponiveis() {
        //expression to get the list of regions available for the migrant from catalogoRegiao
        return CatalogoRegiao.getRegioes().stream().map(r -> new RegiaoDTO(r)).collect(Collectors.toList());
    }

    public List<AjudaDTO> indicarRegiao(RegiaoDTO reg){
        List<Ajuda> ajudasRegiao = new LinkedList<Ajuda>();
        if(CatalogoRegiao.getInstance().isValidRegiao(reg)){
            Regiao r = CatalogoRegiao.getInstance().getRegiao(reg);

            ajudasRegiao.addAll(CatalogoAjudas.getInstance().getAlojamentosByRegion(r));
            ajudasRegiao.addAll(CatalogoAjudas.getInstance().getItems());

            ajudasRegiao = OrdAjFactory.getInstance().getOrdAjStrat().ordListAj(ajudasRegiao);
            
            return ajudasRegiao.stream().map(a -> a instanceof Item ? new ItemDTO((Item) a) : new AlojDTO((Alojamento)a)).collect(Collectors.toList());
        }
        return null; 
    }

    public void indicarAjuda(AjudaDTO ajuda){  
        ajudasSelecionadas.add(CatalogoAjudas.getInstance().getAjuda(ajuda));
    }

    public boolean confirmarSelecao(){
        try{
            m.addAjudasUsadas(ajudasSelecionadas);
               
            for(Ajuda a: ajudasSelecionadas){
                SmsFactory.getInstance().sendSms(a.getOwnerNr(), "\n-=MIGRANTMATCHER=-\nAtenção! A ajuda que disponibilizou no MigrantMatcher (" +
                (a instanceof Item ? 
                ("Item: " + ((Item) a).getDescricao()) : 
                ( "Alojamento : " + ((Alojamento) a).getRegiao().getNome())) + 
                ") foi selecionada por um migrante. \n" 
                + "Pode entrar em contacto com o mesmo/a pelo número de telemóvel: " + m.getNTelefone());
            }  
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    








}