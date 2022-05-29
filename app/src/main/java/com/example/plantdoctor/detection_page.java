package com.example.plantdoctor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.plantdoctor.ml.DiseaseDetection;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class detection_page extends AppCompatActivity {

    TextView disease_name, advice_text;
    Button solution_btn;
    ImageView plant_sample, camera_btn;

    int ImageSize =224;

    BottomNavigationView bottomNavigationView;

    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detection_page);


        disease_name = findViewById(R.id.disease_name);
        advice_text = findViewById(R.id.advice_text);
        solution_btn = findViewById(R.id.solution_btn);
        plant_sample = findViewById(R.id.plant_view);
        camera_btn = findViewById(R.id.take_photo);


        bottomNavigationView = findViewById(R.id.bottom_detection);
        floatingActionButton = findViewById(R.id.fab_detection);


        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                Intent intent = new Intent(detection_page.this, MainActivity.class);
                startActivity(intent);
                return false;
            }
        });
        bottomNavigationView.getMenu().getItem(1).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                Intent intent = new Intent(detection_page.this, agri_clg_near_me.class);
                startActivity(intent);
                return false;
            }
        });





        camera_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                     Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                     startActivityForResult(camera,1);
                 }
                 else{
                     requestPermissions(new String[]{Manifest.permission.CAMERA},100);

                 }
            }
        });



            solution_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(detection_page.this, take_photo_page.class);
                    startActivity(intent);
                }
            });
        }

    


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == 1 && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            int dimension = Math.min(bitmap.getWidth(),bitmap.getHeight());
            bitmap = ThumbnailUtils.extractThumbnail(bitmap,dimension,dimension);
            plant_sample.setImageBitmap(bitmap);

            bitmap = Bitmap.createScaledBitmap(bitmap, ImageSize, ImageSize,false);

            disease_name.setVisibility(View.VISIBLE);
            advice_text.setVisibility(View.VISIBLE);
            solution_btn.setVisibility(View.VISIBLE);

            classify_the_sample(bitmap);

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void classify_the_sample(Bitmap bitmap) {
        try {
            DiseaseDetection model = DiseaseDetection.newInstance(getApplicationContext());

            TensorBuffer input0 = TensorBuffer.createFixedSize(new int[]{1,224,224,3}, DataType.FLOAT32);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4*ImageSize*ImageSize*3);
            byteBuffer.order(ByteOrder.nativeOrder());

            int[] ints = new int[ImageSize*ImageSize];
             bitmap.getPixels(ints,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());

             int pixel = 0;

             for(int i=0;i<ImageSize;i++){
                 for(int j= 0;j<ImageSize;j++ ){
                     int val = ints[pixel++];
                     byteBuffer.putFloat(((val>>16) & 0xFF) * (1.f / 255.f));
                     byteBuffer.putFloat(((val>>8) & 0xFF) * (1.f / 255.f));
                     byteBuffer.putFloat((val>>16) * (1.f / 255.f));

                 }
             }

             input0.loadBuffer(byteBuffer);

            DiseaseDetection.Outputs outputs = model.process(input0);

            TensorBuffer output0 =  outputs.getOutputFeature0AsTensorBuffer();

            float[] codident = output0.getFloatArray();

            int maxi = 0;
            float maxi_plant = 0;

            for(int i=0;i< codident.length;i++){
                if(codident[i] > maxi_plant){
                    maxi_plant = codident[i];
                    maxi = i;

                }
            }

            String[] labels = {"Tomato Mosaic Virus","Target Spot","Bacterial Spot","Tomato yellow leaf curl virus",
                    "Late Blight","Early Blight","Septoria leaf spot","Leaf mold"};
            disease_name.setText(labels[maxi]);

            model.close();


        } catch (IOException e) {
            // TODO HANDLE THE EXCEPTION
        }
    }

}