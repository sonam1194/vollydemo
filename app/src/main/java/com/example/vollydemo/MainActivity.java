package com.example.vollydemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Queue;

public class MainActivity extends AppCompatActivity {


    private static final  String URL = "https://api.github.com/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView userList= (RecyclerView) findViewById(R.id.userList);
        userList.setLayoutManager(new LinearLayoutManager(this));


        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                Log.d("code",response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                User[] user = gson.fromJson(response, User[].class);
                userList.setAdapter(new recyclerAdapter(MainActivity.this,user));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}
