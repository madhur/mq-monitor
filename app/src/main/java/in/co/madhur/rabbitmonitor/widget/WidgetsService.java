package in.co.madhur.rabbitmonitor.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by madhur on 5/17/15.
 */
public class WidgetsService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {

        return new WidgetListProvider(this);
    }
}
