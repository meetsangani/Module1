package com.example.mobileshop;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText edtemail,edtpass;
    Button btnlogin;
    TextView txtcreateaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtemail=findViewById(R.id.edtemamil1);
        edtpass = findViewById(R.id.edtpass1);
        btnlogin=findViewById(R.id.btnlogin);
        txtcreateaccount = findViewById(R.id.createaccount);

        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(LoginActivity.this, R.color.statusbar));


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_ = edtemail.getText().toString();
                String pass_ = edtpass.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://nejadhari.000webhostapp.com/MOBILE/login.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        if(response.contains("1")) {

                            Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(LoginActivity.this,Dataview.class);
                            intent.putExtra("email",email_);
                            intent.putExtra("pass", pass_);

                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                        }

                        //startActivity(new Intent(LoginActivity.this,Dataview.class));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
                {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        HashMap hashMap = new HashMap();
                        hashMap.put("email",email_);
                        hashMap.put("pass",pass_);
                        return hashMap;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
                requestQueue.add(stringRequest);

            }
        });
        txtcreateaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });



    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}