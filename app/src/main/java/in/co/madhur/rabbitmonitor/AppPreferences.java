package in.co.madhur.rabbitmonitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by madhur on 13/05/15.
 */
public class AppPreferences {

    private Context context;
    private SharedPreferences sharedPreferences;


    public AppPreferences(Context context)
    {


        this.context = context;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public enum Keys
    {

        HOSTNAME("hostname"),
        USERNAME("username"),
        PASSWORD("password"),
        PORT("port"),
        ENABLE_NOTIFICATIONS("enable_notifications"),
        ENABLE_SOUND("enable_sound"),
        ENABLE_VIBRATE("enable_vibrate"),
        ENABLE_LED("enable_led"),
        SYNC_INTERVAL("sync_interval"),
        LAST_SUCCESSFUL_SYNC("last_successful_sync");

        public final String key;


        private Keys(String key)
        {
            this.key = key;
        }


    }

    public String getMetadata(Keys key)
    {
        return sharedPreferences.getString(key.key, "");
    }


    public boolean getBoolMetadata(Keys key)
    {
        return sharedPreferences.getBoolean(key.key, true);
    }



}
