package in.co.madhur.rabbitmonitor.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import in.co.madhur.rabbitmonitor.Constants;
import in.co.madhur.rabbitmonitor.R;

/**
 * Created by madhur on 5/17/15.
 */
public class WidgetProvider extends AppWidgetProvider {


    /**
     * On update
     * @param context
     * @param appWidgetManager
     * @param appWidgetIds
     */
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);


        UpdateWidget(context, appWidgetManager, appWidgetIds);
    }


    /**
     * On Receive
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);


        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);


        ComponentName name = new ComponentName(context, getClass().getName());
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(name);


        UpdateWidget(context, appWidgetManager, appWidgetIds);
    }

    /**
     * Update widget
     * @param context
     * @param appWidgetManager
     * @param appWidgetIds
     */
    private void UpdateWidget(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;


        for (int i = 0; i < N; ++i) {
            try {
                RemoteViews remoteViews = updateWidgetListView(context, appWidgetIds[i]);
                appWidgetManager.updateAppWidget(appWidgetIds[i], remoteViews);
                appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds[i], R.id.widgetListView);


            } catch (NullPointerException e) {
                Log.e(Constants.TAG, "Null in widget");
            }
        }


    }


    /**
     * Update widget list view
     * @param context
     * @param appWidgetId
     * @return
     */
    private RemoteViews updateWidgetListView(Context context, int appWidgetId) {

        return null;

    }



}
