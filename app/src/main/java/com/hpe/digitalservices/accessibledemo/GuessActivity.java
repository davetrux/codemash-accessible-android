package com.hpe.digitalservices.accessibledemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GuessActivity extends BaseActivity {

    private boolean flag_spinner_isFirst = true;
    private ArrayAdapter<CharSequence> reasonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        this.setUpNavigation();

        final Spinner spinner = (Spinner) findViewById(R.id.reasons);

        reasonList = ArrayAdapter.createFromResource(this, R.array.reasons, android.R.layout.simple_spinner_item);
        reasonList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.initial_reason, android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);

        spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                updateList(spinner);
                view.onTouchEvent(motionEvent);
                return true;

            }
        });

        spinner.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if(keyCode == 66 && flag_spinner_isFirst) {
                    updateList(spinner);
                }
                return false;
            }
        });
    }

    private void updateList(Spinner spinner){
        if(flag_spinner_isFirst){
            spinner.setAdapter(reasonList);
            flag_spinner_isFirst = false;
        }
    }
}
