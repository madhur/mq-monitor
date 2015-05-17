package in.co.madhur.rabbitmonitor.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import in.co.madhur.rabbitmonitor.Alarms;

/**
 * Created by madhur on 5/17/15.
 */
public class BootReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Alarms alarms = new Alarms(context);
        if (alarms.ShouldSchedule())
        {
            alarms.Schedule();
        }
    }

}