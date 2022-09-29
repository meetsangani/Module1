package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    TextView click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        click=findViewById(R.id.pdf);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewpdf();
            }
        });
    }

    private void viewpdf() {
        String value="https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(value));

        // start activity
        startActivity(intent);
    }

    /*private void viewpdf() {
        String value="https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(value));

        // start activity
        startActivity(intent);

    }*/


}
