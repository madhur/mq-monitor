package in.co.madhur.rabbitmonitor;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import de.greenrobot.event.EventBus;
import in.co.madhur.rabbitmonitor.api.Overview;
import in.co.madhur.rabbitmonitor.events.OverviewRefreshEvent;
import in.co.madhur.rabbitmonitor.request.GsonRequest;

/**
 * Created by madhur on 4/26/15.
 */
public class MainActivity extends AppCompatActivity {


    private RelativeLayout statsLayout;
    private TextView consumersTextView;
    private TextView queuesTextView;
    private TextView exchangeTextView;
    private TextView connectionsTextView;
    private TextView channelsTextView;

    private TextView rabbmitmqTextView;
    private TextView erlangTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);

        statsLayout= (RelativeLayout) findViewById(R.id.statsLayout);
        consumersTextView= (TextView) findViewById(R.id.consumers);
        queuesTextView= (TextView) findViewById(R.id.queues);
        exchangeTextView= (TextView) findViewById(R.id.exchanges);
        connectionsTextView= (TextView) findViewById(R.id.connections);
        channelsTextView= (TextView) findViewById(R.id.channels);
        rabbmitmqTextView= (TextView) findViewById(R.id.rabbitmqversion);
        erlangTextView= (TextView) findViewById(R.id.erlangversion);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PreferenceManager.setDefaultValues(this, R.xml.pref_general, false);

        // Setup alarm if it doesn't exist
        Alarms alarms = new Alarms(this);

        if (!alarms.DoesAlarmExist())
        {
            if (alarms.ShouldSchedule())
                alarms.Schedule();
        }

        EventBus.getDefault().register(this);

    }


    public void onEvent(OverviewRefreshEvent e)
    {
        refreshStatus();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.action_settings:
                Intent i = new Intent();
                i.setClass(this, SettingsActivity.class);
                startActivity(i);
                break;

            case R.id.action_refresh:
                refreshStatus();

        }

        return false;
    }

    /**
     * Refresh status
     */
    private void refreshStatus()
    {
        final AppPreferences appPreferences = new AppPreferences(this);
        final String hostName = appPreferences.getMetadata(AppPreferences.Keys.HOSTNAME);
        final String port = appPreferences.getMetadata(AppPreferences.Keys.PORT);
        final String userName = appPreferences.getMetadata(AppPreferences.Keys.USERNAME);
        final String password = appPreferences.getMetadata(AppPreferences.Keys.PASSWORD);

        if(hostName.length()==0 || port.length()==0)
        {
            Toast.makeText(this, getString(R.string.incomplete_info), Toast.LENGTH_SHORT).show();
            return;
        }

        final String url = "http://"+hostName+":"+port+Constants.OVERVIEW_API;

        Log.d(Constants.TAG, url);

        GsonRequest<Overview> jsObjRequest = new GsonRequest<>
                (Request.Method.GET, url, Overview.class, new Response.Listener<Overview>() {

                    @Override
                    public void onResponse(Overview response) {
                        Log.d(Constants.TAG, response.toString());

                        statsLayout.setVisibility(View.VISIBLE);

                        rabbmitmqTextView.setText(response.getRabbitmqVersion());
                        erlangTextView.setText(response.getErlangVersion());
                        consumersTextView.setText(response.getObjectTotals().getConsumers().toString());
                        channelsTextView.setText(response.getObjectTotals().getChannels().toString());
                        connectionsTextView.setText(response.getObjectTotals().getConnections().toString());
                        queuesTextView.setText(response.getObjectTotals().getQueues().toString());
                        exchangeTextView.setText(response.getObjectTotals().getExchanges().toString());

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        statsLayout.setVisibility(View.GONE);

                        if(error!=null && error.networkResponse!=null && error.networkResponse.statusCode==401)
                        {
                            Toast.makeText(MainActivity.this, getString(R.string.invalid_creds), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if(error!=null && error.getMessage()!=null) {
                            Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, getString(R.string.error_occurred), Toast.LENGTH_SHORT).show();
                            return;
                        }


                    }
                }, userName, password);

        App.getInstance().getRequestQueue().add(jsObjRequest);


    }
}
