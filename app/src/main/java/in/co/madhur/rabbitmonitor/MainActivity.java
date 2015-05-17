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

import org.json.JSONObject;

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
        AppPreferences appPreferences = new AppPreferences(this);
        String hostName = appPreferences.getMetadata(AppPreferences.Keys.HOSTNAME);
        String port = appPreferences.getMetadata(AppPreferences.Keys.PORT);

        if(hostName.length()==0 || port.length()==0)
        {
            Toast.makeText(this, getString(R.string.incomplete_info), Toast.LENGTH_SHORT).show();
            return;
        }

        String url = "http://"+hostName+":"+port+Constants.OVERVIEW_API;

        Log.d(Constants.TAG, url);

        GsonRequest jsObjRequest = new GsonRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(Constants.TAG, response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        if(error.networkResponse.statusCode==401)
                        {
                            Toast.makeText(MainActivity.this, getString(R.string.invalid_creds), Toast.LENGTH_SHORT).show();
                            return;
                        }

                    }
                });

// Access the RequestQueue through your singleton class.
        App.getInstance().getRequestQueue().add(jsObjRequest);


    }
}
