package in.co.madhur.rabbitmonitor.widget;

import android.content.Context;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

/**
 * Created by madhur on 5/17/15.
 */
public class WidgetListProvider implements RemoteViewsService.RemoteViewsFactory {

    private Context context;
    private WidgetConfig widgetConfig;

    public WidgetListProvider(Context context)
    {
        this.context = context;
        widgetConfig = new WidgetConfig();
    }


    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public RemoteViews getViewAt(int i) {
        return null;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
