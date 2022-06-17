package migrant_matcher.app.strategies.sms;

import com.telegramsms.TelegramSMSSender;

/**
 * A classe {@code SmsTelegram} que implementa
 * a classe {@code SmsStrat} representa a estratégia
 * de envio de mensagens.
 * 
 * @author Miguel Pato | fc57102
 * @author Tomás Correia | fc56372
 */
public class SmsTelegram implements SmsStrat{
        
        
        /**
        * Envia sms para um numero com um certo conteudo
        * 
        * @param nr    - Numero de telemovel a enviar sms
        * @param msg   - Conteudo do sms
        */
        public void sendSms(String nr, String msg) {
            TelegramSMSSender tsms = new TelegramSMSSender();
            tsms.setNumber(nr);
            tsms.setText(msg);
            tsms.send();
        }
    
}
