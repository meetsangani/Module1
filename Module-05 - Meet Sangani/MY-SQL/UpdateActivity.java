package com.example.mobileshop;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.Map;

public class UpdateActivity extends AppCompatActivity {


    EditText edt1,edt2,edt3,edt4,edt5;
    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        edt1=findViewById(R.id.updfname);
        edt2=findViewById(R.id.updlname);
        edt3=findViewById(R.id.updemail);
        edt4=findViewById(R.id.updmobile);
        edt5=findViewById(R.id.updpass);
        btn1=findViewById(R.id.update);




        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        edt1.setText(intent.getStringExtra("fname"));
        edt2.setText(intent.getStringExtra("lname"));
        edt3.setText(intent.getStringExtra("email"));
        edt4.setText(intent.getStringExtra("mobile"));
        edt5.setText(intent.getStringExtra("pass"));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fname =edt1.getText().toString();
                String lname = edt2.getText().toString();
                String email = edt3.getText().toString();
                String mobile = edt4.getText().toString();
                String pass = edt5.getText().toString();


                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://nejadhari.000webhostapp.com/MOBILE/update.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(UpdateActivity.this,Dataview.class);
                        startActivity(i);
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
                        hashMap.put("id",id);
                        hashMap.put("fname",fname);
                        hashMap.put("lname",lname);
                        hashMap.put("email",email);
                        hashMap.put("mobile",mobile);
                        hashMap.put("pass",pass);

                        return hashMap;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(UpdateActivity.this);
                requestQueue.add(stringRequest);
            }
        });

    }
}