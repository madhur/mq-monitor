package in.co.madhur.rabbitmonitor.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import in.co.madhur.rabbitmonitor.App;

/**
 * Created by madhur on 5/17/15.
 */
public class LargeWidgetProvider extends WidgetProvider {

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.d(App.TAG, "Updating widget");
        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {
        Log.d(App.TAG, "Updating widget1");
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

}
