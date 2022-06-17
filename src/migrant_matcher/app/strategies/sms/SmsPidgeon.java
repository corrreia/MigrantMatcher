package migrant_matcher.app.strategies.sms;

import com.pidgeonsmssender.sdk.PidgeonSMSSender;

/**
 * A classe {@code SmsPidgeon} que implementa
 * a classe {@code SmsStrat} representa a estratégia
 * de envio de mensagens.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class SmsPidgeon implements SmsStrat{
    
        /** 
         * Envia sms para um numero com um certo
         * conteudo
         * 
         * @param nr    - Numero de telemovel a enviar sms
         * @param msg   - Conteudo do sms
         */
        public void sendSms(String nr, String msg) {
            PidgeonSMSSender sms = new PidgeonSMSSender();
            sms.send(nr, msg);
        }
}
