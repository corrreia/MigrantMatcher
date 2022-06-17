package migrant_matcher.app.facade.controllers;

import java.util.List;

import migrant_matcher.app.domain.Ajuda;
import migrant_matcher.app.domain.Alojamento;
import migrant_matcher.app.domain.Item;
import migrant_matcher.app.domain.Voluntario;
import migrant_matcher.app.domain.catalogos.CatalogoAjudas;
import migrant_matcher.app.domain.catalogos.CatalogoRegiao;
import migrant_matcher.app.domain.factory.SmsFactory;
import migrant_matcher.app.facade.dto.RegiaoDTO;

/**
 * Classe {@code OferecerAjudaHandler} é um controller
 * que lida com a parte do caso de uso de oferecer ajudas
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class OferecerAjudaHandler{ //handler para criar ajudas

    private Voluntario v;
    private Ajuda a;
    private String authCode;
    private String authCodeWD;

    /**
     * Construtor de OferecerAjudaHandler
     * 
     * @param v objeto voluntario
     */
    public OferecerAjudaHandler(Voluntario v) {
        this.v = v;
    }

    
    /** 
     * Método que retorna uma lista de regiões disponiveis
     * e que cria um alojamento que alberga um certo número de pessoas
     * 
     * @param n                 número de pessoas que o alojamento alberga
     * @return List<RegiaoDTO>  lista de regiões disponiveis
     */
    public List<RegiaoDTO> nPessoasAlberga(int n){
        a = new Alojamento(v.getNumeroTelefone(), n);
        return CatalogoRegiao.getRegioesDTO();
    }

    
    /** 
     * Método que serve para indicar a região do alojamento
     * 
     * @param regiao       região do alojamento
     * @return boolean     true se a região for válida, false se não
     */
    public boolean indicarRegiao(RegiaoDTO regiao){
        if(CatalogoRegiao.getInstance().isValidRegiao(regiao)){
            ((Alojamento) a).setRegiao(CatalogoRegiao.getInstance().getRegiao(regiao));
            enviarSMS();
            return true;
        }
        return false;
    }

    
    /** 
     * Método que verifica a validade de uma região
     * 
     * @param regiao    região a ser verificada
     * @return boolean  true se a região for válida, false se não
     */
    public boolean isValidRegiao(RegiaoDTO regiao){
        return CatalogoRegiao.getInstance().isValidRegiao(regiao);
    }

    
    /** 
     * Método que serve para oferecer um item
     * 
     * @param descricao   descrição do item
     */
    public void oferecerItem(String descricao){
        a = new Item(v.getNumeroTelefone(),descricao);
        enviarSMS();
    }
    
    /**
     * Método que envia uma sms ao voluntário para verificar a ajuda oferecida 
     */
    private void enviarSMS(){
        //genreate random 6 digit number
        authCode = String.format("%06d", (int) (Math.random() * 1000000));
        authCodeWD = authCode.substring(0, 3) + "-" + authCode.substring(3);
        //send sms to sms provider
        SmsFactory.getInstance().sendSms(v.getNumeroTelefone(), "\n-=MIGRANTMATCHER=-\nO seu código de autenticação é: " + authCodeWD);
    }

    
    /** 
     * Verifica se o código de autenticação é válido e se é o correto de
     * se sim adiciona a ajuda ao catalogo
     * 
     * @param codigo    código de autenticação
     * @return boolean  true se o código for válido, false se não
     */
    public boolean indicarCodigo(String codigo){
        if(codigo.equals(authCode) || codigo.equals(authCodeWD)){
            CatalogoAjudas.getInstance().adicionarAjuda(a);
            return true;
        }
        return false;
    }

    /**
    *  Este método apenas serve para ser possivel criar sessões nos testes
    *  Numa versão final seria apagado pois pode gerar uma falha de segurança
    */
    public String getAuthCode(){
        return authCodeWD;
    }
}
