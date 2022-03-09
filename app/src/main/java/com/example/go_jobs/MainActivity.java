package com.example.go_jobs;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private static final int[] Images={R.drawable.jobonline,R.drawable.search, R.drawable.vacancy,R.drawable.trone};
    private int position = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button btnNext =findViewById(R.id.next);
        Button btnprev =findViewById(R.id.previous);

        final ImageSwitcher imageSwitcher =findViewById(R.id.imageswitcher);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));

                return imageView;
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position<Images.length-1){
                    position +=1;
                    imageSwitcher.setBackgroundResource(Images[position]);
                    if (position==3){
                        Intent intent = new Intent(getApplicationContext(),Login.class);
                        startActivity(intent);
                    }
                }

            }
        });

        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position>0){
                    position -=1;
                    imageSwitcher.setBackgroundResource(Images[position]);
                }
            }
        });
    }
}