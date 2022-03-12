package com.example.go_jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.go_jobs.pojo.ModelJobApplication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Job_Apply extends AppCompatActivity {
EditText jobapptitle, motivationletter;
Button submitapplication;
ApiInterface apiInterface3;
private ModelJobApplication newJobapply  = new ModelJobApplication();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_apply);

        submitapplication = findViewById(R.id.addapplication);

        jobapptitle = findViewById(R.id.apptitle);
        motivationletter = findViewById(R.id.motivationLetter);

        apiInterface3 = Api.getClient().create(ApiInterface.class);

        submitapplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("DEBUG","Clicked on add apply");
                new Runnable(){

                    @Override
                    public void run() {
                        newJobapply.setJobapptitle(jobapptitle.getText().toString());
                        newJobapply.setJobappletter(motivationletter.getText().toString());
                        Log.v("DEBUG","URL"+ ApiInterface.ADD_JOBAPPLICATION_URL);
                        Call<ModelJobApplication> addapplyCall = apiInterface3.addJobapply(newJobapply);
                        addapplyCall.enqueue(new Callback<ModelJobApplication>() {
                            @Override
                            public void onResponse(Call<ModelJobApplication> call, Response<ModelJobApplication> response) {

                                if (response.isSuccessful()) {
                                    Toast.makeText(getBaseContext(), "Application submitted  successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent11 = new Intent(getApplicationContext(),Login.class);
                                    startActivity(intent11);
                                }
                                else {
                                    Toast.makeText(getBaseContext(), "Error connecting to the server", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ModelJobApplication> call, Throwable t) {
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