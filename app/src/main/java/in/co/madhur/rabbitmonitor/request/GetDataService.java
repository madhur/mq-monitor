package in.co.madhur.rabbitmonitor.request;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import in.co.madhur.rabbitmonitor.App;
import in.co.madhur.rabbitmonitor.AppPreferences;
import in.co.madhur.rabbitmonitor.Constants;
import in.co.madhur.rabbitmonitor.R;
import in.co.madhur.rabbitmonitor.api.Overview;
import in.co.madhur.rabbitmonitor.api.queue.Queue;

/**
 * Created by madhur on 13/05/15.
 */
public class GetDataService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        createRequest();

        return START_NOT_STICKY;
    }

    private void createRequest()
    {
        final AppPreferences appPreferences = new AppPreferences(this);
        final String hostName = appPreferences.getMetadata(AppPreferences.Keys.HOSTNAME);
        final String port = appPreferences.getMetadata(AppPreferences.Keys.PORT);

        if(hostName.length()==0 || port.length()==0)
        {
            Toast.makeText(this, getString(R.string.incomplete_info), Toast.LENGTH_SHORT).show();
            return;
        }

        final String url = "http://"+hostName+":"+port+Constants.QUEUE_API;

        Log.d(Constants.TAG, url);

        GsonRequest<Overview> jsObjRequest = new GsonRequest<>
                (Request.Method.GET, url, Queue.class, new Response.Listener<Overview>() {

                    @Override
                    public void onResponse(Overview response) {
                        Log.d(Constants.TAG, response.toString());

                        stopSelf();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        if(error==null)
                            return;

                        if(error.networkResponse!=null && error.networkResponse.statusCode==401)
                        {
                            Toast.makeText(GetDataService.this, getString(R.string.invalid_creds), Toast.LENGTH_SHORT).show();
                            return;
                        }

                    }
                });

        App.getInstance().getRequestQueue().add(jsObjRequest);

    }
}
