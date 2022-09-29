package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.TypedValue;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    View myview;
    RadioButton r1,r2,r3,r4;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radio);
        r1=findViewById(R.id.add);
        r2 = findViewById(R.id.sub);
        r3 = findViewById(R.id.mul);
        r4 = findViewById(R.id.div);

        myview = findViewById(R.id.view);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(r1.isChecked())
                {
                    myview.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.black));
                }
                else if(r2.isChecked())
                {
                    myview.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.orange));
                }
                else if(r3.isChecked())
                {
                    myview.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.green));
                }
                else if(r4.isChecked())
                {
                    myview.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.blue));
                }

            }
        });









        }
    }




