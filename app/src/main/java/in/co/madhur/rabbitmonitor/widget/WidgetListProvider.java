package in.co.madhur.rabbitmonitor.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.Arrays;
import java.util.List;

import in.co.madhur.rabbitmonitor.App;
import in.co.madhur.rabbitmonitor.AppPreferences;
import in.co.madhur.rabbitmonitor.R;
import in.co.madhur.rabbitmonitor.api.queue.Queue;

/**
 * Created by madhur on 5/17/15.
 */
public class WidgetListProvider implements RemoteViewsService.RemoteViewsFactory {

    private Context context;
    private WidgetConfig widgetConfig;
    private List<Queue> queues;
    private Intent blankIntent;

    public WidgetListProvider(Context context)
    {
        this.context = context;
        widgetConfig = new WidgetConfig();
        blankIntent = new Intent();
    }


    @Override
    public void onCreate() {

        PullData();

    }


    private void PullData()
    {
        Queue [] queueData = App.getInstance().getQueueData();
        if(queueData!=null) {
            queues = Arrays.asList(queueData);

            Log.d(App.TAG, "Got non null queue " + queues.size());
        }

        widgetConfig.RefreshData(new AppPreferences(context));

    }

    @Override
    public void onDataSetChanged() {

        PullData();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        if(queues!=null)
            return queues.size()+1;

        return 0;
    }

    @Override
    public RemoteViews getViewAt(int i)
    {
        RemoteViews view = new RemoteViews(context.getPackageName(), R.layout.widget_row);


        if(i==0)
        {
            view.setTextViewText(R.id.TitleTextView, "Name");
            view.setTextViewText(R.id.totalTextView, "Total");
            view.setTextViewText(R.id.unackedTextView, "Unack");
            view.setTextViewText(R.id.readyTextView, "Ready");

        }
        else
        {
            Queue rowData = queues.get(i-1);

            if(rowData!=null) {
                Log.d(App.TAG, "Filling row");
                view.setTextViewText(R.id.TitleTextView, rowData.getName());
                view.setTextViewText(R.id.totalTextView, String.valueOf(rowData.getMessages()));
                view.setTextViewText(R.id.unackedTextView, String.valueOf(rowData.getMessagesUnacknowledged()));
                view.setTextViewText(R.id.readyTextView, String.valueOf(rowData.getMessagesReady()));


            }
        }

        view.setTextColor(R.id.TitleTextView, widgetConfig.getTitleColor());
        view.setTextColor(R.id.totalTextView, widgetConfig.getCountColor());
        view.setTextColor(R.id.unackedTextView, widgetConfig.getCountColor());
        view.setTextColor(R.id.readyTextView, widgetConfig.getCountColor());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setTextViewTextSize(R.id.TitleTextView, TypedValue.COMPLEX_UNIT_SP, widgetConfig.getTextSize());
            view.setTextViewTextSize(R.id.totalTextView, TypedValue.COMPLEX_UNIT_SP, widgetConfig.getTextSize());
            view.setTextViewTextSize(R.id.unackedTextView, TypedValue.COMPLEX_UNIT_SP, widgetConfig.getTextSize());
            view.setTextViewTextSize(R.id.readyTextView, TypedValue.COMPLEX_UNIT_SP, widgetConfig.getTextSize());
        } else {

            view.setFloat(R.id.TitleTextView, "setTextSize", widgetConfig.getTextSize());
            view.setFloat(R.id.totalTextView, "setTextSize", widgetConfig.getTextSize());
            view.setFloat(R.id.unackedTextView, "setTextSize", widgetConfig.getTextSize());
            view.setFloat(R.id.readyTextView, "setTextSize", widgetConfig.getTextSize());
        }

        view.setOnClickFillInIntent(R.id.widget_row, blankIntent);

        return view;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
