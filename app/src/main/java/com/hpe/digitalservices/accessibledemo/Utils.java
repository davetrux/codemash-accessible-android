package com.hpe.digitalservices.accessibledemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by trux on 9/28/16.
 */

public class Utils {

    static final String THEME_INTENT = "themechange";
    static final String THEME_KEY = "theme";

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */

    static void changeTheme(Activity activity) {
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    static void setUiTheme(Activity activity) {

        if(isDarkTheme(activity)) {
            activity.setTheme(R.style.DarkTheme);
        } else {
            activity.setTheme(R.style.LightTheme);
        }

    }

    static boolean isDarkTheme(Activity activity) {

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(activity.getBaseContext());

        return sharedPrefs.getBoolean("theme", false);

    }
}
