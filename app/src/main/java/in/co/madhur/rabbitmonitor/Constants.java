package in.co.madhur.rabbitmonitor;

/**
 * Created by madhur on 5/17/15.
 */
public class Constants {

    public static final String OVERVIEW_API="/api/overview";
    public static final String QUEUE_API="/api/queues";

    public static final String TAG="mqmonitor";

    public static final String UPDATE_ACTION="in.co.madhur.ACTION.UPDATE";

    public static final String REFRESH_ACTION="in.co.madhur.ACTION.REFRESH";

    public static final String TWITTER_URL="https://twitter.com/intent/user?screen_name=madhur25";
    public static final String UPDATE_SOURCE="update_source";

    public enum UPDATESOURCE
    {
        ALARM("alarm"),
        ACCEPT_BUTTON("accept_button"),
        NETWORK_CHANGE("network_change"),
        SETTINGS_CHANGE("settings_change"),
        LOGOUT_BUTTON("logout_button"),
        WIDGET_REFRESH_BUTTON("widget_refresh_button");

        public final String key;

        private UPDATESOURCE(String key)
        {
            this.key = key;
        }

    }


}
