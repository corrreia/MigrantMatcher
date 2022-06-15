package migrant_matcher.app.domain.factory;

import migrant_matcher.app.Configuration;
import migrant_matcher.app.strategies.sms.SmsPidgeon;
import migrant_matcher.app.strategies.sms.SmsStrat;

public class SmsFactory {

    //singleton
    private static SmsFactory INSTANCE = null;

    private SmsFactory() {
    }

    public static SmsFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SmsFactory();
        }
        return INSTANCE;
    }
    
    public void sendSms(String nr, String msg) {
        SmsStrat smstrat = Configuration.getConfiguration().getInstanceOfClass("sms_strategy", new SmsPidgeon());
        smstrat.sendSms(nr, msg);
    }
}
