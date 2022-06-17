package migrant_matcher.app.domain.factory;

import migrant_matcher.app.Configuration;
import migrant_matcher.app.strategies.sms.SmsPidgeon;
import migrant_matcher.app.strategies.sms.SmsStrat;

/**
 * A classe {@code SmsFactory} usa o padrão Factory 
 * para criar estratégias de envio de mensagens 
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372 
 */
public class SmsFactory {

    //singleton
    private static SmsFactory INSTANCE = null;

    /**
     * Construtor privado da classe {@code SmsFactory}
     */
    private SmsFactory() {
    }

    
    /** 
     * Construtor da classe {@code SmsFactory}
     * 
     * @return SmsFactory   instância da classe {@code SmsFactory}
     */
    public static SmsFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SmsFactory();
        }
        return INSTANCE;
    }
    
    
    /** 
     * Método que envia o sms consoante a estratégia
     * 
     * @param nr    número de telemóvel        
     * @param msg   mensagem a enviar
     */
    public void sendSms(String nr, String msg) {
        SmsStrat smstrat = Configuration.getConfiguration().getInstanceOfClass("sms_strategy", new SmsPidgeon());
        smstrat.sendSms(nr, msg);
    }
}
