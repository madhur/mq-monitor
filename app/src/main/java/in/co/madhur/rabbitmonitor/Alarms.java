package in.co.madhur.rabbitmonitor;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import in.co.madhur.rabbitmonitor.request.GetDataService;

public class Alarms
{
    int REQUEST_CODE_WIDGET=0, REQUEST_CODE_ALARM=1;
    private Context context;
    private AppPreferences appPreferences;
    int LOWEST_RECUR_INTERVAL=1;

    public Alarms(Context context, AppPreferences appPreferences)
    {

        this.context=context;
        this.appPreferences=appPreferences;
    }

    public Alarms(Context context)
    {

        this.context=context;
        this.appPreferences=new AppPreferences(context);
    }


    private static AlarmManager GetAlarmManager(Context context)
    {
        return (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

    }

    public void Schedule()
    {
        AlarmManager alarmManager=GetAlarmManager(context);
        long recurInterval=LOWEST_RECUR_INTERVAL*60*60*1000;
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, 0, recurInterval, GetPendingIntentAlarm(context) );
    }

    private PendingIntent GetPendingIntentAlarm(Context context)
    {
        Intent updateIntent=new Intent();
        updateIntent.setAction(Constants.UPDATE_ACTION);

        return PendingIntent.getBroadcast(context, REQUEST_CODE_ALARM, updateIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    }


    public PendingIntent GetPendingIntentWidget(int requestCode, Context context)
    {
        return PendingIntent.getBroadcast(context, requestCode, GetIntent(), PendingIntent.FLAG_ONE_SHOT);
    }

    private Intent GetIntent()
    {
        Intent updateIntent=new Intent();
        updateIntent.setAction(Constants.UPDATE_ACTION);
        return updateIntent;
    }

    public  void StartUpdate()
    {
        Intent updateIntent=new Intent();
        updateIntent.setClass(context, GetDataService.class);
        context.startService(updateIntent);
    }

    public boolean ShouldSchedule()
    {
        return appPreferences.IsSyncEnabled();
    }


}
