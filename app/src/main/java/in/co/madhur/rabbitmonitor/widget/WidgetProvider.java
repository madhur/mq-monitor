package in.co.madhur.rabbitmonitor.widget;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.RemoteViews;

import java.util.Date;

import in.co.madhur.rabbitmonitor.Alarms;
import in.co.madhur.rabbitmonitor.AppPreferences;
import in.co.madhur.rabbitmonitor.Constants;
import in.co.madhur.rabbitmonitor.R;
import in.co.madhur.rabbitmonitor.SettingsActivity;

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

        AppPreferences appPreferences = new AppPreferences(context);

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.mq_appwidget);

        SetupLookAndFeel(context, remoteViews, appPreferences);

        Intent svcIntent = new Intent(context, WidgetsService.class);
        svcIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        svcIntent.setData(Uri.parse(svcIntent.toUri(Intent.URI_INTENT_SCHEME)));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
        {
            remoteViews.setRemoteAdapter(R.id.widgetListView, svcIntent);
        }
        else
        {
            remoteViews.setRemoteAdapter(appWidgetId, R.id.widgetListView, svcIntent);
        }

        remoteViews.setEmptyView(R.id.widgetListView, R.id.empty_view);


        if (!appPreferences.IsTokenPresent())
        {
            remoteViews.setTextViewText(R.id.empty_view, context.getString(R.string.login_required_desc));

            remoteViews.setTextViewText(R.id.updatedTextView, "");

        }
        else
        {

            remoteViews.setTextViewText(R.id.empty_view, context.getString(R.string.no_unread_items));
            remoteViews.setTextViewText(R.id.updatedTextView, String.format(context.getString(R.string.lastupdate_display_format), GetFormattedDate(appPreferences.GetLastSuccessfulSync(), context)));



        }

        return remoteViews;

    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void SetupLookAndFeel(Context context, RemoteViews remoteViews, AppPreferences appPreferences)
    {

        remoteViews.setInt(R.id.widget_host, "setBackgroundColor", appPreferences.GetColor(AppPreferences.Keys.WIDGET_BACKGROUND_COLOR));

        if(appPreferences.GetTheme()==0)
        {
            remoteViews.setImageViewResource(R.id.widget_icon, R.mipmap.ic_notification);
            remoteViews.setImageViewResource(R.id.widget_refresh, R.mipmap.ic_action_refresh);
            remoteViews.setImageViewResource(R.id.widget_settings, R.mipmap.ic_action_settings);
        }
        else if(appPreferences.GetTheme()==1)
        {
            remoteViews.setImageViewResource(R.id.widget_icon, R.mipmap.ic_notification);
            remoteViews.setImageViewResource(R.id.widget_refresh, R.mipmap.ic_action_refresh_light);
            remoteViews.setImageViewResource(R.id.widget_settings, R.mipmap.ic_action_settings_light);

        }

        if (appPreferences.IsWidgetHeaderEnabled())
        {
            remoteViews.setViewVisibility(R.id.widget_icon, View.VISIBLE);
            remoteViews.setViewVisibility(R.id.updatedTextView, View.VISIBLE);
            remoteViews.setViewVisibility(R.id.widget_refresh, View.VISIBLE);
            remoteViews.setViewVisibility(R.id.widget_settings, View.VISIBLE);

            remoteViews.setOnClickPendingIntent(R.id.widget_icon, GetPendingIntent(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()), context));
            remoteViews.setOnClickPendingIntent(R.id.widget_refresh, new Alarms(context).GetPendingIntentWidget(context));
            remoteViews.setOnClickPendingIntent(R.id.widget_settings, GetSettingsPendingIntent(context));

        }
        else
        {
            remoteViews.setViewVisibility(R.id.widget_icon, View.GONE);
            remoteViews.setViewVisibility(R.id.updatedTextView, View.GONE);
            remoteViews.setViewVisibility(R.id.widget_refresh, View.GONE);
            remoteViews.setViewVisibility(R.id.widget_settings, View.GONE);
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        {
            remoteViews.setTextViewTextSize(R.id.updatedTextView, TypedValue.COMPLEX_UNIT_SP, appPreferences.GetFontSize());
        }
        else
        {
            remoteViews.setFloat(R.id.updatedTextView, "setTextSize", appPreferences.GetFontSize());
        }

        remoteViews.setTextColor(R.id.updatedTextView, appPreferences.GetColor(AppPreferences.Keys.WIDGET_TITLE_COLOR));

    }

    private PendingIntent GetSettingsPendingIntent(Context context)
    {
        Intent intent =new Intent();
        intent.setClass(context, SettingsActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        return pendingIntent;

    }



    private PendingIntent GetPendingIntent(Intent intent, Context context)
    {

        if (intent != null)
        {
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            return pendingIntent;
        }

        return null;
    }

    public static String GetFormattedDate(long date, Context context)
    {

        Date dateObj = new Date(date);
        java.text.DateFormat dateFormat = android.text.format.DateFormat.getTimeFormat(context);
        return dateFormat.format(dateObj);
    }



}
