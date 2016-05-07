package de.myself5.stockusbfix;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import eu.chainfire.libsuperuser.Shell;

public class FixIt extends AppCompatActivity {

    CheckBox persist_USB;

    public static final String PREFS_NAME = "USBFixPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_it);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        persist_USB = ((CheckBox) findViewById(R.id.persist_USB));
        boolean fixusb = settings.getBoolean("fixusb", true);
        persist_USB.setChecked(fixusb);
    }

    public void FixIt(View unused) {
        FixIt();
    }

    public static void FixIt() {
        Shell.SU.run("chmod 750 /init.usbmode.sh");
        Shell.SU.run("sh /init.usbmode.sh");
    }

    public void setUSBPersist(View view){
        boolean checked = persist_USB.isChecked();
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("fixusb", checked);
        editor.apply();
    }
}