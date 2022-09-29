package com.example.internet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ConnectivityManager connectivityManager=(ConnectivityManager)

                this.getSystemService(Context.CONNECTIVITY_SERVICE);


        NetworkInfo wifi=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);


        NetworkInfo  network=connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);



        if(isNetworkAvaliable(MainActivity.this))
        {
            Toast.makeText(this, "Inernet is Connected", Toast.LENGTH_SHORT).show();
            if (wifi.isConnected())
            {
                Toast.makeText(this, "Wifi", Toast.LENGTH_SHORT).show();

            }
            else if(network.isConnected())
            {
                Toast.makeText(this, "Mobile Internet", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "noo", Toast.LENGTH_SHORT).show();
            }

        }
        else
        {
            Toast.makeText(this, "No Internet Available", Toast.LENGTH_SHORT).show();
        }



    }



   /* private boolean isNetworkAvailable() {


        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isWifi = activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }*/
    public static boolean isNetworkAvaliable(Context ctx) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if ((connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED)

                || (connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState() == NetworkInfo.State.CONNECTED)) {
            return true;
        } else {
            return false;
        }
    }



    }
