package in.co.madhur.rabbitmonitor;

import android.app.Application;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

/**
 * Created by madhur on 4/26/15.
 */
public class App extends Application {

    private RequestQueue requestQueue;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    /**
     * Get Volley request queue
     * @return
     */
    public RequestQueue getRequestQueue()
    {
        if(requestQueue==null)
        {
            // Instantiate the cache
            Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

            // Set up the network to use HttpURLConnection as the HTTP client.
            Network network = new BasicNetwork(new HurlStack());

            // Instantiate the RequestQueue with the cache and network.
            requestQueue = new RequestQueue(cache, network);

            requestQueue.start();
        }


        return requestQueue;

    }

    public static App getInstance()
    {
        return instance;
    }
}
