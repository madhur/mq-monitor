package in.co.madhur.rabbitmonitor;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.MaterialDialog;

import in.co.madhur.rabbitmonitor.AppPreferences.Keys;

/**
 * A {@link PreferenceActivity} that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 * <p/>
 * See <a href="http://developer.android.com/design/patterns/settings.html">
 * Android Design: Settings</a> for design guidelines and the <a
 * href="http://developer.android.com/guide/topics/ui/settings.html">Settings
 * API Guide</a> for more information on developing a Settings UI.
 */
public class SettingsActivity extends PreferenceActivity {
    /**
     * Determines whether to always show the simplified settings UI, where
     * settings are presented in a single list. When false, settings are shown
     * as a master/detail two-pane view on tablets. When true, a single pane is
     * shown on tablets.
     */

    private AppCompatDelegate mDelegate;

    private final Preference.OnPreferenceChangeListener widgetListListener = new Preference.OnPreferenceChangeListener()
    {

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue)
        {
            UpdateLabel((ListPreference) preference, newValue.toString());
            WidgetSettingsChanged();
            return true;
        }
    };

    private final Preference.OnPreferenceChangeListener widgetChangeListener = new Preference.OnPreferenceChangeListener()
    {

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue)
        {
            WidgetSettingsChanged();
            return true;
        }
    };
    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        getDelegate().setSupportActionBar(toolbar);
    }


    protected void UpdateLabel(ListPreference listPreference, String newValue)
    {

        if (newValue == null)
        {
            newValue = listPreference.getValue();
        }

        int index = listPreference.findIndexOfValue(newValue);
        if (index != -1)
        {
            newValue = (String) listPreference.getEntries()[index];

                listPreference.setTitle(newValue);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getDelegate().installViewFactory();
        getDelegate().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);


    }

    private void WidgetSettingsChanged()
    {
        // Broadcast intent to update widget

        Intent updateIntent = new Intent();
        updateIntent.setAction(Constants.REFRESH_ACTION);
        sendBroadcast(updateIntent);

    }


    private void SetWidgetListeners()
    {

        findPreference(Keys.HOSTNAME.key).setOnPreferenceChangeListener(widgetChangeListener);
        findPreference(Keys.PORT.key).setOnPreferenceChangeListener(widgetChangeListener);
        findPreference(Keys.USERNAME.key).setOnPreferenceChangeListener(widgetChangeListener);
        findPreference(Keys.PASSWORD.key).setOnPreferenceChangeListener(widgetChangeListener);

        findPreference(Keys.WIDGET_BACKGROUND_COLOR.key).setOnPreferenceChangeListener(widgetChangeListener);
        findPreference(Keys.WIDGET_COUNT_COLOR.key).setOnPreferenceChangeListener(widgetChangeListener);
        findPreference(Keys.WIDGET_TITLE_COLOR.key).setOnPreferenceChangeListener(widgetChangeListener);
//        findPreference(Keys.WIDGET_SORT_ORDER.key).setOnPreferenceChangeListener(widgetChangeListener);
        findPreference(Keys.ENABLE_WIDGET_HEADER.key).setOnPreferenceChangeListener(widgetChangeListener);
        findPreference(Keys.WIDGET_TEXT_SIZE.key).setOnPreferenceChangeListener(widgetListListener);

        findPreference(Keys.FOLLOW_TWITTER.key).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {

            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.TWITTER_URL)));
                return true;
            }
        });

        findPreference(Keys.ACTION_ABOUT.key).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
        {

            @Override
            public boolean onPreferenceClick(Preference preference)
            {
                new MaterialDialog.Builder(SettingsActivity.this)
                        .title(R.string.action_about)
                        .content(R.string.about_content)
                        .positiveText("OK")
                        .show();


                return true;
            }
        });

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getDelegate().onPostCreate(savedInstanceState);
        setupSimplePreferencesScreen();

        LinearLayout root = (LinearLayout)findViewById(android.R.id.list).getParent().getParent().getParent();
        Toolbar bar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.settings_toolbar, root, false);
        root.addView(bar, 0); // insert at top
        bar.setTitle(getString(R.string.app_name));

        setSupportActionBar(bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    /**
     * Shows the simplified settings UI if the device configuration if the
     * device configuration dictates that a simplified, single-pane UI should be
     * shown.
     */
    private void setupSimplePreferencesScreen() {

        // In the simplified UI, fragments are not used at all and we instead
        // use the older PreferenceActivity APIs.

        // Add 'general' preferences.
        addPreferencesFromResource(R.xml.pref_general);
        SetWidgetListeners();

    }

    private AppCompatDelegate getDelegate() {
        if (mDelegate == null) {
            mDelegate = AppCompatDelegate.create(this, null);
        }
        return mDelegate;
    }

    @Override
    public MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        getDelegate().setContentView(layoutResID);
    }
    @Override
    public void setContentView(View view) {
        getDelegate().setContentView(view);
    }
    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        getDelegate().setContentView(view, params);
    }
    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        getDelegate().addContentView(view, params);
    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }
    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        getDelegate().setTitle(title);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getDelegate().onConfigurationChanged(newConfig);
    }
    @Override
    protected void onStop() {
        super.onStop();
        getDelegate().onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

}
