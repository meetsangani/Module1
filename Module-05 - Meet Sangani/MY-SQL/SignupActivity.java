package com.example.mobileshop;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
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
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    TextInputEditText fname, lname, email, mobile, pass, conpass;
    TextInputLayout edt1;
    Button btnsignup;

    TextView txtsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(SignupActivity.this, R.color.statusbar));

        fname = findViewById(R.id.edtfname);
        lname = findViewById(R.id.edtlname);
        email = findViewById(R.id.edtemail);
        mobile = findViewById(R.id.edtmobile);
        pass = findViewById(R.id.edtpass);
        conpass = findViewById(R.id.confirmpassword);
        btnsignup = findViewById(R.id.btnsignup);
        txtsignup = findViewById(R.id.txtsignup);
        edt1 = findViewById(R.id.edt1);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fname_ = fname.getText().toString();
                String lname_ = lname.getText().toString();
                String email_ = email.getText().toString();
                String mobile_ = mobile.getText().toString();
                String pass_ = pass.getText().toString();

                if(fname_.length()==0)
                {
                    edt1.setHelperText("Please enter name");
                }
                else
                {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://nejadhari.000webhostapp.com/MOBILE/insert.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(SignupActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignupActivity.this,LoginActivity.class));


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {

                            HashMap hashMap = new HashMap();
                            hashMap.put("fname", fname_);
                            hashMap.put("lname", lname_);
                            hashMap.put("email", email_);
                            hashMap.put("mobile", mobile_);
                            hashMap.put("pass", pass_);

                            return hashMap;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(SignupActivity.this);
                    requestQueue.add(stringRequest);
                }


            }
        });


        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });

    }

        @Override
        public void onBackPressed () {
            finishAffinity();
        }
    }
