package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



   EditText edtfirstnum,edtsecondnum;
   Button btnpassdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtfirstnum = findViewById(R.id.firstnum);
        edtsecondnum = findViewById(R.id.secondnum);

        btnpassdata = findViewById(R.id.btndatapass);

        btnpassdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String firstnum = edtfirstnum.getText().toString();
                String secondnum = edtsecondnum.getText().toString();

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("first",firstnum);
                intent.putExtra("second",secondnum);
                startActivity(intent);
            }
        });








    }
}