package com.example.go_jobs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.go_jobs.pojo.ModelCategory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewCategory extends AppCompatActivity {
    EditText categoryname, categorydesc;
    Button addCategory;
    ApiInterface apiInterface5;
    private ModelCategory newCategory = new ModelCategory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category);
        categoryname = findViewById(R.id.Categoryname);
        categorydesc = findViewById(R.id.Categorydesc);
        addCategory = findViewById(R.id.addCategory);

        apiInterface5 =Api.getClient().create(ApiInterface.class);
        addCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("DEBUG","Clicked on new category");

                new Runnable(){

                    @Override
                    public void run() {
                        newCategory.setJcname(categoryname.getText().toString());
                        newCategory.setJcdesc(categorydesc.getText().toString());

                        Log.v("DEBUG","URL"+ ApiInterface.ADD_CATEGORY_URL);
                        Call<ModelCategory> addCategoryCall =apiInterface5.addCategory(newCategory);
                        addCategoryCall.enqueue(new Callback<ModelCategory>() {
                            @Override
                            public void onResponse(Call<ModelCategory> call, Response<ModelCategory> response) {
                                if (response.isSuccessful()) {
                                    Toast.makeText(getBaseContext(), "Category added successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent12 = new Intent(getApplicationContext(),CategoryList.class);
                                    startActivity(intent12);
                                }
                                else {
                                    Toast.makeText(getBaseContext(), "Error connecting to the server", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<ModelCategory> call, Throwable t) {
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