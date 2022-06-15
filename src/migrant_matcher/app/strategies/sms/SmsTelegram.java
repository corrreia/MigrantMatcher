package migrant_matcher.app.strategies.sms;

import com.telegramsms.TelegramSMSSender;

public class SmsTelegram implements SmsStrat{
        
        public void sendSms(String nr, String msg) {
            TelegramSMSSender tsms = new TelegramSMSSender();
            tsms.setNumber(nr);
            tsms.setText(msg);
            tsms.send();
        }
    
}
