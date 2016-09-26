package com.hpe.digitalservices.accessibledemo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GuessActivity extends BaseActivity {

    private ArrayAdapter<CharSequence> reasonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        this.setUpNavigation();

        final Spinner spinner = (Spinner) findViewById(R.id.reasons);

        reasonList = ArrayAdapter.createFromResource(this, R.array.reasons, android.R.layout.simple_spinner_item);
        reasonList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(reasonList);
    }
}
