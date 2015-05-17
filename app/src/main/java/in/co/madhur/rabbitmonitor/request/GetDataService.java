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
        final String userName = appPreferences.getMetadata(AppPreferences.Keys.USERNAME);
        final String password = appPreferences.getMetadata(AppPreferences.Keys.PASSWORD);

        if(hostName.length()==0 || port.length()==0)
        {
            Toast.makeText(this, getString(R.string.incomplete_info), Toast.LENGTH_SHORT).show();
            return;
        }

        final String url = "http://"+hostName+":"+port+Constants.QUEUE_API;

        Log.d(Constants.TAG, url);

        Toast.makeText(getApplicationContext(), getString(R.string.sync_started), Toast.LENGTH_SHORT).show();

        GsonRequest<Queue[]> jsObjRequest = new GsonRequest<>
                (Request.Method.GET, url, Queue[].class, new Response.Listener<Queue[]>() {

                    @Override
                    public void onResponse(Queue[] response) {
                        Log.d(Constants.TAG, "Got the data");

                        App.getInstance().setQueueData(response);

                        appPreferences.SaveSuccessfulSync();

                        SendUpdateBroadcast();

                        stopSelf();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {


                        if(error!=null && error.networkResponse!=null && error.networkResponse.statusCode==401)
                        {
                            Toast.makeText(GetDataService.this, getString(R.string.invalid_creds), Toast.LENGTH_SHORT).show();
                            return;
                        }

                        stopSelf();

                    }
                }, userName, password);

        App.getInstance().getRequestQueue().add(jsObjRequest);

    }

    private void SendUpdateBroadcast()
    {
        // Send update broadcast for widgets
        Intent updateIntent = new Intent();
        updateIntent.setAction(Constants.REFRESH_ACTION);
        sendBroadcast(updateIntent);

    }
}
