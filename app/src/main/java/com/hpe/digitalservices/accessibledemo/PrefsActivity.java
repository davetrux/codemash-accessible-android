package com.hpe.digitalservices.accessibledemo;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

public class PrefsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         *  Accessibility feature
         */
        ThemeUtils.setUiTheme(this);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new CluePreferenceFragment()).commit();
    }

    public static class CluePreferenceFragment extends PreferenceFragment
                                               implements SharedPreferences.OnSharedPreferenceChangeListener {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);

            addPreferencesFromResource(R.xml.preferences);
        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (key.equals(ThemeUtils.THEME_KEY)) {

                Intent sendBack = new Intent(ThemeUtils.THEME_INTENT);

                //Keep the intent local to the application
                LocalBroadcastManager.getInstance(this.getActivity()).sendBroadcast(sendBack);

                /*
                 * Accessibility Feature
                 */
                ThemeUtils.changeTheme(this.getActivity());

            }
        }

        @Override
        public void onResume() {
            // TODO Auto-generated method stub
            super.onResume();
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }

        /* (non-Javadoc)
         * @see android.app.Activity#onPause()
         */
        @Override
        public void onPause() {
            // TODO Auto-generated method stub
            super.onPause();

            getPreferenceScreen().getSharedPreferences()
                    .unregisterOnSharedPreferenceChangeListener(this);
        }
    }
}
