package com.bignerdranch.android.fitrainer;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewCustomerActivity extends AppCompatActivity {
    EditText CustomerName, CustomerAge, CustomerWeight, CustomerGoal;
    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);
        setTitle("Logged In: jdoe");

        CustomerName = (EditText) findViewById(R.id.newName);
        CustomerAge = (EditText) findViewById(R.id.newAge);
        CustomerWeight = (EditText) findViewById(R.id.newWeight);
        CustomerGoal = (EditText) findViewById(R.id.newGoal);


        Button mReturn = (Button) findViewById(R.id.bReturn);
        mReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(NewCustomerActivity.this, MainActivity.class);
                //startActivity(i);
                finish();
            }
        });
    }

    public void addCustomer(View view) {
        String name = CustomerName.getText().toString();
        String age = CustomerAge.getText().toString();
        String weight = CustomerWeight.getText().toString();
        String goal = CustomerGoal.getText().toString();
        userDbHelper = new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        userDbHelper.addInfo(name,age,weight,goal,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Saved!", Toast.LENGTH_LONG).show();
        userDbHelper.close();
    }
}
