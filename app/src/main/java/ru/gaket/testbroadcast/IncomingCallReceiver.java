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

    boolean shouldCreate = true;

    @Override
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        Log.i("TestApp", "We are here! " + stringExtra + " " + this.toString());

        TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        if (shouldCreate) {

            shouldCreate = false;

            telephony.listen(new PhoneStateListener() {
                @Override
                public void onCallStateChanged(int state, String incomingNumber) {
                    Log.i("TestApp", "state: " + state + " incomingNumber : " + incomingNumber);
                }
            }, PhoneStateListener.LISTEN_CALL_STATE);

        }
    }
}
