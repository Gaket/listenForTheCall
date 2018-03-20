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

    @Override
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        Log.i("TestApp", "State update! " + stringExtra + " " + this.toString() + " " + System.identityHashCode(intent));
    }
}
