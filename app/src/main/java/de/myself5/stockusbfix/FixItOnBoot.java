package de.myself5.stockusbfix;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import eu.chainfire.libsuperuser.Shell;

public class FixItOnBoot extends BroadcastReceiver {

    public static final String PREFS_NAME = "USBFixPrefs";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
            boolean fixusb = settings.getBoolean("fixusb", true);
            if (fixusb) {
                FixIt.FixIt();
            }
        }
    }
}