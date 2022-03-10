package com.example.go_jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.go_jobs.pojo.ModelApplicant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewApplicant extends AppCompatActivity {
    Button btn2;
    TextView text2;
    EditText nameInput, cityInput, countryInput;
    EditText emailInput, phoneInput, passwordInput, confirmPasswordInput;
    ApiInterface apiInterface;
    private ModelApplicant newApplicant = new ModelApplicant();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_applicant);

        nameInput = (EditText) findViewById(R.id.ApplicantName);
        cityInput = (EditText) findViewById(R.id.ApplicantCity);
        countryInput = (EditText) findViewById(R.id.ApplicantCountry);
        emailInput = (EditText) findViewById(R.id.ApplicantEmail);
        phoneInput = (EditText) findViewById(R.id.ApplicantPhone);
        passwordInput = (EditText) findViewById(R.id.ApplicantPassword);
        confirmPasswordInput = (EditText) findViewById(R.id.ApplicantConfirmPassword);

        apiInterface = Api.getClient().create(ApiInterface.class);

        btn2=findViewById(R.id.addApplicant);
        text2=findViewById(R.id.Applicantsignin);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("DEBUG", "Clicked add button");
                new Runnable() {
                    @Override
                    public void run() {
                        // get the values from the different inputs
                        newApplicant.setCity(cityInput.getText().toString());
                        newApplicant.setName(nameInput.getText().toString());
                        newApplicant.setEmail(emailInput.getText().toString());
                        newApplicant.setPhone(phoneInput.getText().toString());

                        String password = passwordInput.getText().toString(), confirmPassword = confirmPasswordInput.getText().toString();

                        if (password.equals(confirmPassword) && !password.equals("")) {
                            newApplicant.setPassword(password);
                            Log.v("DEBUG", "URL: " + ApiInterface.ADD_APPLICANT_URL);
                            Call<ModelApplicant> addApplicantCall = apiInterface.addApplicant(newApplicant);
                            addApplicantCall.enqueue(new Callback<ModelApplicant>() {
                                @Override
                                public void onResponse(Call<ModelApplicant> call, Response<ModelApplicant> response) {
                                    if (response.isSuccessful()) {
                                        Toast.makeText(getBaseContext(), "Applicant added successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),Login.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(getBaseContext(), "Error connecting to the server", Toast.LENGTH_LONG).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<ModelApplicant> call, Throwable t) {
                                    Log.v("DEBUG", "Message: " + t.toString());
                                    Toast.makeText(getBaseContext(), "Request failed", Toast.LENGTH_LONG).show();
                                }
                            });
                        } else {
                            Toast.makeText(getApplicationContext(), "The two passwords must be the same and cannot be empty", Toast.LENGTH_LONG).show();
                        }
                    }

//                    Call<>
                }.run();
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

    }
}