package com.example.go_jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class NewCompany extends AppCompatActivity {
    Button btn1;
    TextView text1;
    EditText et, et1, et3, et4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_company);

        btn1=findViewById(R.id.addCompany);
        text1=findViewById(R.id.Companysignin);
        et=findViewById(R.id.CompanyName);
        et1=findViewById(R.id.Companypassword);
        et3=findViewById(R.id.CompanyEmail);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String url="http://localhost:14484/RecruitmentPlatformBackend/webresources/companycontroller/company";
               StringRequest stringRequest = new StringRequest(Request.Method.POST,url, response -> {Toast.makeText(getApplicationContext(),"success", Toast.LENGTH_LONG).show();},
                      error->Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show()){
                   @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                      Map<String, String>params = new HashMap<>();
                      params.put("CompanyName",et.getText().toString());
                      params.put("CompanyEmail",et3.getText().toString());
                      params.put("CompanyPassword",et1.getText().toString());
                      return params;
                    }
                };
               RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
              // RequestQueue.add(stringRequest);
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

    }
}