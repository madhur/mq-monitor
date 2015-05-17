package in.co.madhur.rabbitmonitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import in.co.madhur.rabbitmonitor.api.queue.Queue;

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

    public boolean IsTokenPresent() {

        String accessToken = sharedPreferences.getString(Keys.HOSTNAME.key, "");
        if (TextUtils.isEmpty(accessToken))
            return false;

        return true;
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
        LAST_SUCCESSFUL_SYNC("last_successful_sync"),
        PICK_THEME("pick_theme"),

        ACTION_ABOUT("action_about"),
        WIDGET_TITLE_COLOR("widget_title_color"),
        WIDGET_COUNT_COLOR("widget_count_color"),
        WIDGET_BACKGROUND_COLOR("widget_background_color"),
        WIDGET_TEXT_SIZE("widget_text_size"),
        WIDGET_OPTIONS("widget_options"),
        ENABLE_WIDGET_HEADER("enable_widget_header"),
        WIDGET_SORT_ORDER("widget_sort_order");

        public final String key;


        private Keys(String key)
        {
            this.key = key;
        }


    }

    public int GetWidgetSortOrder()
    {
        String s=sharedPreferences.getString(Keys.WIDGET_SORT_ORDER.key, context.getString(R.string.widget_sort_order_default));
        return Integer.parseInt(s);
    }


    public String getMetadata(Keys key)
    {
        return sharedPreferences.getString(key.key, "");
    }

    public boolean IsWidgetHeaderEnabled()
    {
        return sharedPreferences.getBoolean(Keys.ENABLE_WIDGET_HEADER.key, context.getResources().getBoolean(R.bool.enable_widget_header_default));
    }

    public int GetColor(Keys key)
    {
        int color = sharedPreferences.getInt(key.key, 0);
        return color;
    }

    public int GetFontSize()
    {
        int intFontSize;
        String fontSize = sharedPreferences.getString(Keys.WIDGET_TEXT_SIZE.key, context.getResources().getString(R.string.font_medium_default));

        intFontSize = Integer.parseInt(fontSize);

        return intFontSize;

    }


    public boolean getBoolMetadata(Keys key)
    {
        return sharedPreferences.getBoolean(key.key, true);
    }

    public int GetSyncInterval()
    {

        int interval;

        String s = sharedPreferences.getString(Keys.SYNC_INTERVAL.key, context.getResources().getString(R.string.sync_interval_default));
        interval = Integer.parseInt(s);

        return interval;

    }

    public int GetTheme()
    {
        String s=sharedPreferences.getString(Keys.PICK_THEME.key, context.getString(R.string.default_theme));
        return Integer.parseInt(s);
    }

    public long GetLastSuccessfulSync()
    {
        try
        {
            return sharedPreferences.getLong(Keys.LAST_SUCCESSFUL_SYNC.key, 0);
        }
        catch (ClassCastException e)
        {
            return 0;
        }

    }

}
