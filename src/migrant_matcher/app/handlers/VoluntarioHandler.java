package migrant_matcher.app.handlers;

import java.util.List;
import com.pidgeonsmssender.sdk.PidgeonSMSSender;

import migrant_matcher.app.domain.Ajuda;
import migrant_matcher.app.domain.Alojamento;
import migrant_matcher.app.domain.Item;
import migrant_matcher.app.domain.Regiao;
import migrant_matcher.app.domain.Voluntario;
import migrant_matcher.app.domain.catalogos.CatalogoAjudas;
import migrant_matcher.app.domain.catalogos.CatalogoRegiao;

public class VoluntarioHandler { //handler para criar ajudas

    private Voluntario v;
    private Ajuda a;
    private String authCode;
    private String authCodeWD;

    public VoluntarioHandler(Voluntario v) {
        this.v = v;
    }

    public List<Regiao> nPessoasAlberga(int n){
        a = new Alojamento(v.getContactNumber(), n);
        return CatalogoRegiao.getInstance().getRegioes(); //.stream().map(reg -> reg.getNome()).collect(Collectors.toList())
    }

    public boolean indicarRegiao(String regiao){
        if(CatalogoRegiao.getInstance().isValidRegiao(regiao)){
            //a.setRegiao(CatalogoRegiao.getInstance().getRegiao(regiao));
            enviarSMS();
            return true;
        }
        return false;
    }

    public void oferecerItem(String descricao){
        a = new Item(v.getContactNumber() ,descricao);
        enviarSMS();
    }
 
    private void enviarSMS(){
        //genreate random 6 digit number
        authCode = String.format("%06d", (int) (Math.random() * 1000000));
        authCodeWD = authCode.substring(0, 3) + "-" + authCode.substring(3);
        //send sms to sms provider
        PidgeonSMSSender sms = new PidgeonSMSSender();
        sms.send(v.getContactNumber(), "\n      MIGRANTMATCHER\n      O seu código de autenticação é: " + authCodeWD);
    }

    public boolean indicarCodigo(String codigo){
        if(codigo.equals(authCode) || codigo.equals(authCodeWD)){
            CatalogoAjudas.getInstance().adicionarAjuda(a);
            return true;
        }
        return false;
    }

}
