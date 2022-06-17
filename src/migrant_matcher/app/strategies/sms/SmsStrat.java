package migrant_matcher.app.strategies.sms;

/**
 * Interface das Strategies para envio de mensagens
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public interface SmsStrat {
    
    /**
     * Envia sms para um numero com um certo conteudo
     * 
     * @param nr    - Numero de telemovel a enviar sms
     * @param msg   - Conteudo do sms
     */
    public void sendSms(String nr, String msg);
}
