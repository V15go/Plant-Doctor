package com.example.plantdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {


    CircleImageView profile_navigator;
    BottomNavigationView bottomNavigationView;

    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile_navigator = findViewById(R.id.profile_navigator);

        bottomNavigationView = findViewById(R.id.bottom_home);
        floatingActionButton = findViewById(R.id.fab_home);


        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(0).setEnabled(true);
        bottomNavigationView.getMenu().getItem(2).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                Intent intent = new Intent(MainActivity.this, agri_clg_near_me.class);
                startActivity(intent);
                return false;
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, detection_page.class);
                startActivity(intent);
            }
        });


        profile_navigator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),detection_page.class));
            }
        });
    }
}