package com.bignerdranch.android.fitrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerSessionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sessions);
        setTitle("Logged In: " + getString(R.string.username));
        Button mBackButton = (Button) findViewById(R.id.bBack);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(MainActivity.this, CustomLoginActivity.class);
                //startActivity(i);
                finish();
            }
        });
    }
}
