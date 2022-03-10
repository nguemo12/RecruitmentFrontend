package com.example.go_jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.go_jobs.pojo.ModelOffer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostJob extends AppCompatActivity {
Button addoffer;
    EditText Offername, Offerdescription, OfferType,Salary,status;
    ApiInterface apiInterface2;
    private ModelOffer newOffer = new ModelOffer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_job);

        Offername = findViewById(R.id.JobName);
        Offerdescription = findViewById(R.id.JobDescription);
        OfferType = findViewById(R.id.JobType);
        Salary = findViewById(R.id.MaxSalary);
        status =findViewById(R.id.JobStatus);

        apiInterface2 =Api.getClient().create(ApiInterface.class);
        addoffer=findViewById(R.id.addJob);
        addoffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("DEBUG","Clicked on add btn");

                new Runnable(){

                    @Override
                    public void run() {
                        newOffer.setOffername(Offername.getText().toString());
                        newOffer.setDescription(Offerdescription.getText().toString());
                        newOffer.setJobtype(OfferType.getText().toString());
                        newOffer.setJobsalary(Salary.getText().toString());
                        newOffer.setStatus(status.getText().toString());

                        Log.v("DEBUG","URL"+ ApiInterface.ADD_OFFER_URL);
                        Call<ModelOffer> addOfferCall = apiInterface2.addOffer(newOffer);
                        addOfferCall.enqueue(new Callback<ModelOffer>() {
                            @Override
                            public void onResponse(Call<ModelOffer> call, Response<ModelOffer> response) {
                                if (response.isSuccessful()) {
                                    Toast.makeText(getBaseContext(), "Job added successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent10 = new Intent(getApplicationContext(),jobs.class);
                                    startActivity(intent10);
                                }
                                else {
                                    Toast.makeText(getBaseContext(), "Error connecting to the server", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ModelOffer> call, Throwable t) {
                                Log.v("DEBUG", "Message: " + t.toString());
                                Toast.makeText(getBaseContext(), "Request failed", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }.run();
            }
        });

    }
}