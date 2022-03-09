package com.example.go_jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.go_jobs.pojo.ModelOffer;

import java.sql.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class jobs extends AppCompatActivity {
TextView job;
private ArrayList<ModelOffer> offers;
private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        apiInterface = Api.getClient().create(ApiInterface.class);

        job= findViewById(R.id.jobadd);

        job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PostJob.class);
                startActivity(intent);
            }
        });

        new Runnable() {
            Call<ArrayList<ModelOffer>> offersCall = apiInterface.getAllOffers();

            @Override
            public void run() {
                offersCall.enqueue(new Callback<ArrayList<ModelOffer>>() {
                    @Override
                    public void onResponse(Call<ArrayList<ModelOffer>> call, Response<ArrayList<ModelOffer>> response) {
                        if (response.isSuccessful()) {
                            offers = response.body();
                            Log.v("DEBUG", "Offers gotten from the DB: " + offers.toString());
                        } else {
                            Toast.makeText(getBaseContext(), "Error connecting to the server", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<ModelOffer>> call, Throwable t) {
                        Toast.makeText(getBaseContext(), "Server request failed", Toast.LENGTH_LONG ).show();
                        Log.v("DEBUG", t.toString());
                    }
                });
            }
        }.run();
    }
}