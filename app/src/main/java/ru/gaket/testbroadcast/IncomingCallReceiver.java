package ru.gaket.testbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * @author Artur Badretdinov (Gaket) 14.03.2018
 */
public class IncomingCallReceiver extends BroadcastReceiver {

    private static boolean alreadyInitialized = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        Log.i("TestApp", "State update! " + stringExtra + " " + this.toString() + " " + System.identityHashCode(intent));

        if (!alreadyInitialized) {
            TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            PhoneStateListener testApp = new PhoneStateListener() {
                @Override
                public void onCallStateChanged(int state, String incomingNumber) {
                    super.onCallStateChanged(state, incomingNumber);
                    Log.i("TestApp", "state: " + state + " incomingNumber : " + incomingNumber);
                }
            };
            telephony.listen(testApp, PhoneStateListener.LISTEN_CALL_STATE);
            alreadyInitialized = true;
        }
    }
}
