package com.bignerdranch.android.fitrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.bignerdranch.android.fitrainer.R.styleable.View;

public class CustomLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String username = "jdoe";
        final String password = "welcome1";
        setContentView(R.layout.activity_custom_login);
        Button mButton = (Button) findViewById(R.id.loginButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etUser = (EditText)findViewById(R.id.userUsername);
                String userStr = etUser.getText().toString();
                EditText etPass = (EditText)findViewById(R.id.userPassword);
                String passStr = etPass.getText().toString();
                if(userStr.equals(username) && passStr.equals(password)){
                    Intent i = new Intent(CustomLoginActivity.this, MainActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(CustomLoginActivity.this, R.string.error_incorrect_password,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
