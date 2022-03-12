package com.example.go_jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.example.go_jobs.pojo.ModelApplicant;
import com.example.go_jobs.pojo.ModelCompany;

import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewCompany extends AppCompatActivity {
    Button btn1;
    TextView text1;
    EditText et, et1, et3, et4,et2,et5, et6,et7;
    ApiInterface apiInterface1;
    private ModelCompany newCompany = new ModelCompany();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_company);

        btn1=findViewById(R.id.addCompany);
        text1=findViewById(R.id.Companysignin);
        et=findViewById(R.id.CompanyName);
        et1=findViewById(R.id.Companypassword);
        et3=findViewById(R.id.CompanyEmail);
        et2 = findViewById(R.id.CompanyPhone);
                et5 =findViewById(R.id.CompanyDescription);
                et6= findViewById(R.id.CompanyCountry);

        et4 =findViewById(R.id.createCompanypassword);
        apiInterface1 = Api.getClient().create(ApiInterface.class);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Log.v("DEBUG","Clicked on add Button");
            new Runnable(){
                @Override
                public void run() {
                    newCompany.setCompanyname(et.getText().toString());
                    newCompany.setCompanyemail(et3.getText().toString());
                    newCompany.setCompanyphone(et2.getText().toString());
                    newCompany.setCompanydescription(et5.getText().toString());
                    newCompany.setCompanycountry(et6.getText().toString());

                    String password = et1.getText().toString(), ConfirmPassword = et4.getText().toString();


                    if (password.equals(ConfirmPassword) && !password.equals("")) {
                        newCompany.setCompanypassword(password);
                        Log.v("DEBUG", "URL: " + ApiInterface.ADD_COMPANY_URL);
                        Call<ModelCompany> addCompanyCall = apiInterface1.addCompany(newCompany);
                        addCompanyCall.enqueue(new Callback<ModelCompany>() {
                            @Override
                            public void onResponse(Call<ModelCompany> call, Response<ModelCompany> response) {
                                if (response.isSuccessful()) {
                                    Toast.makeText(getBaseContext(), "Company added successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),Login.class);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(getBaseContext(), "Error connecting to the server", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ModelCompany> call, Throwable t) {
                                Log.v("DEBUG", "Message: " + t.toString());
                                Toast.makeText(getBaseContext(), "Request failed", Toast.LENGTH_LONG).show();
                            }

                        });
                    } else {
                        Toast.makeText(getApplicationContext(), "The two passwords must be the same and cannot be empty", Toast.LENGTH_LONG).show();
                    }
                }
               // Call<>
            }.run();
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