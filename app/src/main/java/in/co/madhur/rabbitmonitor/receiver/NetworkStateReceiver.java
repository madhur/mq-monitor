package in.co.madhur.rabbitmonitor.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import in.co.madhur.rabbitmonitor.Constants;
import in.co.madhur.rabbitmonitor.request.GetDataService;

/**
 * Created by madhur on 5/17/15.
 */

public class NetworkStateReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (intent.getExtras() != null)
        {
            @SuppressWarnings("deprecation")
            NetworkInfo ni = (NetworkInfo) intent.getExtras().get(ConnectivityManager.EXTRA_NETWORK_INFO);
            if (ni != null && ni.getState() == NetworkInfo.State.CONNECTED)
            {
                Intent serviceIntent=new Intent();
                serviceIntent.putExtra(Constants.UPDATE_SOURCE, Constants.UPDATESOURCE.NETWORK_CHANGE.key);
                serviceIntent.setClass(context, GetDataService.class);
                context.startService(serviceIntent);
            }
        }

    }

}
