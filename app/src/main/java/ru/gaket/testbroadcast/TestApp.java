package ru.gaket.testbroadcast;

import android.app.Application;
import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @author Artur Badretdinov (Gaket) 14.03.2018
 */
public class TestApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("TestApp", "We are in onCreate!");
        initListener();
    }

    private void initListener() {
        TelephonyManager telephony = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        PhoneStateListener testApp = new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);
                Log.i("TestApp", "state: " + state + " incomingNumber : " + incomingNumber);
            }
        };
        telephony.listen(testApp, PhoneStateListener.LISTEN_CALL_STATE);
    }
}
