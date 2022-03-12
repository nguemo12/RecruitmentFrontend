package com.example.go_jobs;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.go_jobs.pojo.ModelOffer;

import java.security.AccessControlContext;
import java.sql.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class jobs extends AppCompatActivity {
TextView job;
private ArrayList<ModelOffer> offers;
private ApiInterface apiInterface;

ListView offersList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        apiInterface = Api.getClient().create(ApiInterface.class);

        job= findViewById(R.id.jobadd);
        offersList = findViewById(R.id.offersList);

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
                            OfferListAdapter adapter = new OfferListAdapter(getContext(), response.body());
                            offersList.setAdapter(adapter);
                            offers = response.body();
                            Log.v("DEBUG", "Offers gotten from the DB: " + offers.toString());
                        } else {
                            if (response.code() == 500) {
                                Toast.makeText(getApplicationContext(), "Error connecting to server", Toast.LENGTH_LONG).show();
                            }
                            if (response.code() == 403) {
                                Toast.makeText(getApplicationContext(), "forbidden", Toast.LENGTH_LONG).show();
                            }

                            Log.v("Request Error", String.format("Code: %d, text: %s, more text: %s", response.code(), response.message(), response.raw().body().toString()));
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
     class OfferListAdapter extends BaseAdapter {
        AccessControlContext context;

 ArrayList <ModelOffer> OfferArraylist;
 public OfferListAdapter(AccessControlContext context, ArrayList <ModelOffer> OfferArraylist){
     this.context = context;
     this.OfferArraylist=OfferArraylist;

 }
        @Override
        public int getCount() {
            return OfferArraylist.size();
        }

        @Override
        public Object getItem(int i) {
            return OfferArraylist.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ModelOffer offer = OfferArraylist.get(i);
            TextView name = (TextView) view.findViewById(R.id.offernewname);
            TextView desc = (TextView) view.findViewById(R.id.offernewdesc);
            TextView salary = (TextView) view.findViewById(R.id.offernewsalary);
            name.setText(offer.getOffername());
            salary.setText(offer.getJobsalary());
            desc.setText(offer.getDescription());
            return view;
        }
    }
}