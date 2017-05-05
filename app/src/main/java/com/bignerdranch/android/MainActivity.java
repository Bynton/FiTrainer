package com.bignerdranch.android.fitrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String username = "jdoe";
        final String password = "welcome1";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Logged In: " + getString(R.string.username));
        TextView t = (TextView) findViewById(R.id.loggedInText);
        //t.setText("Logged In: " + username);
        /*Button mLogOutButton = (Button) findViewById(R.id.bLogOut);
        mLogOutButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(MainActivity.this, CustomLoginActivity.class);
                //startActivity(i);
                finish();
            }
        });*/

        Button mNewCustomerButton = (Button) findViewById(R.id.bNewCustomer);
        mNewCustomerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NewCustomerActivity.class);
                startActivity(i);
            }
        });

        //Button mCustomerListButton = (Button) findViewById(R.id.bCustomerList);
        //mCustomerListButton.setOnClickListener(new OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  Intent i = new Intent(MainActivity.this, CustomerListActivity.class);
                //startActivity(i);
          //  }
        //});

        Button mCustomerSessionsButton = (Button) findViewById(R.id.bCustomarSessions);
        mCustomerSessionsButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CustomerSessionsActivity.class);
                startActivity(i);
            }
        });

        Button nCheckoutButton = (Button) findViewById(R.id.bCheckout);
        nCheckoutButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CheckoutActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu manu) {
        getMenuInflater().inflate(R.menu.main, manu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.id_logout) {
            Toast toast = Toast.makeText(getApplicationContext(), "Logging Off...", Toast.LENGTH_SHORT);
            toast.show();
            finish();
            return true;
        }
        return true;
    }

    public void viewCustomers(View view) {
        Intent intent = new Intent(this, DataListActivity.class);
        startActivity(intent);
    }
}
