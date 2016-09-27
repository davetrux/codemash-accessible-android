package com.hpe.digitalservices.accessibledemo;

import android.icu.text.DateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class GuessActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        this.setUpNavigation();

        final Spinner spinner = (Spinner) findViewById(R.id.reasons);

        final ArrayAdapter<CharSequence> reasonList = ArrayAdapter.createFromResource(this, R.array.reasons, android.R.layout.simple_spinner_item);
        reasonList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(reasonList);

        Button guessButton = (Button) findViewById(R.id.submit);

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                long currentEpoch = System.currentTimeMillis();

                CharSequence message;

                if(currentEpoch % 2 == 0) {
                    message = getResources().getString(R.string.guess_correct);
                } else {
                    message = getResources().getString(R.string.guess_wrong);
                }

                Toast result = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
                result.show();
            }
        });

    }
}
