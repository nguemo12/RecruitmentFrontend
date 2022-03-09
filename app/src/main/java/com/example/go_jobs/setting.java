package com.example.go_jobs;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class setting extends AppCompatActivity implements View.OnClickListener {
    private static final int PICK_IMAGE_REQUEST = 234 ;
    private static final int PICK_PDF_REQUEST = 23;

    private TextView buttonChoose;
    private ImageButton  buttonUpload;
private ImageView imageView, img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
          imageView =  findViewById(R.id.ImageView);
          buttonChoose = (TextView)  findViewById(R.id.buttonChoose);
          buttonUpload = (ImageButton)  findViewById(R.id.buttonUpload);
img= (ImageView) findViewById(R.id.imagecv);
          buttonUpload.setOnClickListener(this);
          buttonChoose.setOnClickListener(this);
    }

    private void showFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"select an Image"), PICK_IMAGE_REQUEST);

    }
    private void showpdfchooser(){
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"select a pdf"), PICK_PDF_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data !=null && data.getData() !=null){
            Uri filePath = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
           imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (requestCode ==PICK_PDF_REQUEST && resultCode ==RESULT_OK && data !=null && data.getData() !=null){
            Uri filePath2 = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filePath2);
                img.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onClick(View view) {

        if (view==buttonChoose){
showFileChooser();
        }else if(view == buttonUpload){
            showpdfchooser();
        }
    }
}