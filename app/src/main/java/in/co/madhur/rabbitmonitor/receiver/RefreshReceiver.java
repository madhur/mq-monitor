package in.co.madhur.rabbitmonitor.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import in.co.madhur.rabbitmonitor.Connection;
import in.co.madhur.rabbitmonitor.request.GetDataService;

/**
 * Created by madhur on 5/17/15.
 */
public class RefreshReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (Connection.isConnected(context))
        {
            Intent serviceIntent = new Intent();
            serviceIntent.setClass(context, GetDataService.class);

            context.startService(serviceIntent);
        }

    }
}
