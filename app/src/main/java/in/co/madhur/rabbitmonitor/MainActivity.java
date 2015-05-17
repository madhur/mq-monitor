package in.co.madhur.rabbitmonitor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import in.co.madhur.rabbitmonitor.api.Overview;
import in.co.madhur.rabbitmonitor.request.GsonRequest;

/**
 * Created by madhur on 4/26/15.
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                        if(error==null)
                            return;

                        if(error.networkResponse!=null && error.networkResponse.statusCode==401)
                        {
                            Toast.makeText(MainActivity.this, getString(R.string.invalid_creds), Toast.LENGTH_SHORT).show();
                            return;
                        }

                    }
                }, userName, password);

        App.getInstance().getRequestQueue().add(jsObjRequest);


    }
}
