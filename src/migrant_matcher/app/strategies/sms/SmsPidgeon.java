package migrant_matcher.app.strategies.sms;

import com.pidgeonsmssender.sdk.PidgeonSMSSender;

public class SmsPidgeon implements SmsStrat{
        
        public void sendSms(String nr, String msg) {
            PidgeonSMSSender sms = new PidgeonSMSSender();
            sms.send(nr, msg);
        }
}
