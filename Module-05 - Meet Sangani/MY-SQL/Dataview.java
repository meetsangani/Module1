package com.example.mobileshop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dataview extends AppCompatActivity {


    ListView listView;
    List<Model> list;
    FloatingActionButton btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataview);

        listView = findViewById(R.id.list);
        list = new ArrayList<>();
        btnadd = findViewById(R.id.btnadd);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dataview.this,SignupActivity.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String pass = intent.getStringExtra("pass");

        Toast.makeText(this, ""+email + " "+ pass, Toast.LENGTH_LONG).show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://nejadhari.000webhostapp.com/MOBILE/view.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        int id = jsonObject.getInt("id");
                        String fname = jsonObject.getString("fname");
                        String lname = jsonObject.getString("lname");
                        String email = jsonObject.getString("email");
                        String mobile = jsonObject.getString("mobile");
                        String pass = jsonObject.getString("pass");
                        //String pass = jsonObject.getString("pass");

                        Model model = new Model();
                        model.setId(id);
                        model.setFname(fname);
                        model.setLname(lname);
                        model.setEmail(email);
                        model.setMobile(mobile);
                        model.setPass(pass);
                        //model.setPass(pass);
                        list.add(model);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }



                MyAdapter adapter = new MyAdapter(Dataview.this,list);
                listView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Dataview.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(Dataview.this);
        requestQueue.add(stringRequest);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem m1 = menu.add(0, 1, 0, "Update");
        MenuItem m2 = menu.add(0, 2, 0, "Delete");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo acm = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id = acm.position;


        switch (item.getItemId())
        {
            case 1:

                Model model = list.get(id);
                String Id1 = String.valueOf(model.getId());
                Intent intent = new Intent(Dataview.this,UpdateActivity.class);
                intent.putExtra("id",Id1);
                intent.putExtra("fname",model.getFname());
                intent.putExtra("lname",model.getLname());
                intent.putExtra("email",model.getEmail());
                intent.putExtra("mobile",model.getMobile());
                intent.putExtra("pass",model.getPass());

                startActivity(intent);
            break;

            case 2:

                Model model1 = list.get(id);

                String Id = String.valueOf(model1.getId());

                AlertDialog.Builder alert = new AlertDialog.Builder(Dataview.this);
                alert.setTitle("Are You Sure to Delte data?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://nejadhari.000webhostapp.com/MOBILE/delete.php", new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                Toast.makeText(Dataview.this, "Deleted", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Dataview.this,Dataview.class);
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
                                hashMap.put("id",Id);
                                return hashMap;
                            }
                        };

                        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                        requestQueue.add(stringRequest);

                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                alert.show();

        }
        return super.onContextItemSelected(item);

    }

    @Override
    public void onBackPressed() {

        finishAffinity();

    }
}