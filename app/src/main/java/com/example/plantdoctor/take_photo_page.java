package com.example.plantdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class take_photo_page extends AppCompatActivity {

    LinearLayout tomato_mosic, target_spot, bacterial_spot, late_blight, early_blight, spectoria, tylc, leaf_mold;

    BottomNavigationView bottomNavigationView;

    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo_page);


        tomato_mosic = findViewById(R.id.tomato_mosaic_layout);
        target_spot = findViewById(R.id.target_spot_layout);
        bacterial_spot = findViewById(R.id.bacterial_spot_layout);
        late_blight = findViewById(R.id.late_blight_layout);
        early_blight = findViewById(R.id.early_blight_layout);
        spectoria = findViewById(R.id.septoria_layout);
        tylc = findViewById(R.id.tylc_layout);
        leaf_mold  = findViewById(R.id.leaf_mold_layout);


        bottomNavigationView = findViewById(R.id.bottom_solution);
        floatingActionButton = findViewById(R.id.fab_solution);


        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                Intent intent = new Intent(take_photo_page.this, MainActivity.class);
                startActivity(intent);
                return false;
            }
        });
        bottomNavigationView.getMenu().getItem(1).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                Intent intent = new Intent(take_photo_page.this, agri_clg_near_me.class);
                startActivity(intent);
                return false;
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(take_photo_page.this, detection_page.class);
                startActivity(intent);
            }
        });





    }

    public void expand_tomato_monica(View view) {


        if(tomato_mosic.getVisibility() == View.GONE){
            TransitionManager.beginDelayedTransition(tomato_mosic,new AutoTransition());

            tomato_mosic.setVisibility(View.VISIBLE);
        }
        if(target_spot.getVisibility() == View.VISIBLE){
            target_spot.setVisibility(View.GONE);
        }
        if(bacterial_spot.getVisibility() == View.VISIBLE){
            bacterial_spot.setVisibility(View.GONE);
        }
        if(late_blight.getVisibility() == View.VISIBLE){
            late_blight.setVisibility(View.GONE);
        }
        if(early_blight.getVisibility() == View.VISIBLE){
            early_blight.setVisibility(View.GONE);
        }
        if(spectoria.getVisibility() == View.VISIBLE){
            spectoria.setVisibility(View.GONE);
        }
        if(leaf_mold.getVisibility() == View.VISIBLE){
            leaf_mold.setVisibility(View.GONE);
        }
        if(tylc.getVisibility() == View.VISIBLE){
            tylc.setVisibility(View.GONE);
        }
    }


    public void expand_target_spot(View view) {


        if(target_spot.getVisibility() == View.GONE){
            TransitionManager.beginDelayedTransition(target_spot,new AutoTransition());

            target_spot.setVisibility(View.VISIBLE);
        }
        if(tomato_mosic.getVisibility() == View.VISIBLE){
            tomato_mosic.setVisibility(View.GONE);
        }
        if(bacterial_spot.getVisibility() == View.VISIBLE){
            bacterial_spot.setVisibility(View.GONE);
        }
        if(late_blight.getVisibility() == View.VISIBLE){
            late_blight.setVisibility(View.GONE);
        }
        if(early_blight.getVisibility() == View.VISIBLE){
            early_blight.setVisibility(View.GONE);
        }
        if(spectoria.getVisibility() == View.VISIBLE){
            spectoria.setVisibility(View.GONE);
        }
        if(leaf_mold.getVisibility() == View.VISIBLE){
            leaf_mold.setVisibility(View.GONE);
        }
        if(tylc.getVisibility() == View.VISIBLE){
            tylc.setVisibility(View.GONE);
        }






    }

    public void expand_bacterial(View view) {


        if(bacterial_spot.getVisibility() == View.GONE){
            TransitionManager.beginDelayedTransition(bacterial_spot,new AutoTransition());

            bacterial_spot.setVisibility(View.VISIBLE);
        }
        if(target_spot.getVisibility() == View.VISIBLE){
            target_spot.setVisibility(View.GONE);
        }
        if(tomato_mosic.getVisibility() == View.VISIBLE){
            tomato_mosic.setVisibility(View.GONE);
        }
        if(late_blight.getVisibility() == View.VISIBLE){
            late_blight.setVisibility(View.GONE);
        }
        if(early_blight.getVisibility() == View.VISIBLE){
            early_blight.setVisibility(View.GONE);
        }
        if(spectoria.getVisibility() == View.VISIBLE){
            spectoria.setVisibility(View.GONE);
        }
        if(leaf_mold.getVisibility() == View.VISIBLE){
            leaf_mold.setVisibility(View.GONE);
        }
        if(tylc.getVisibility() == View.VISIBLE){
            tylc.setVisibility(View.GONE);
        }

    }

    public void expand_late_blight(View view) {


        if(late_blight.getVisibility() == View.GONE){
            TransitionManager.beginDelayedTransition(late_blight,new AutoTransition());

            late_blight.setVisibility(View.VISIBLE);
        }
        if(target_spot.getVisibility() == View.VISIBLE){
            target_spot.setVisibility(View.GONE);
        }
        if(bacterial_spot.getVisibility() == View.VISIBLE){
            bacterial_spot.setVisibility(View.GONE);
        }
        if(tomato_mosic.getVisibility() == View.VISIBLE){
            tomato_mosic.setVisibility(View.GONE);
        }
        if(early_blight.getVisibility() == View.VISIBLE){
            early_blight.setVisibility(View.GONE);
        }
        if(spectoria.getVisibility() == View.VISIBLE){
            spectoria.setVisibility(View.GONE);
        }
        if(leaf_mold.getVisibility() == View.VISIBLE){
            leaf_mold.setVisibility(View.GONE);
        }
        if(tylc.getVisibility() == View.VISIBLE){
            tylc.setVisibility(View.GONE);
        }






    }

    public void expand_early_blight(View view) {


        if(early_blight.getVisibility() == View.GONE){
            TransitionManager.beginDelayedTransition(early_blight,new AutoTransition());

            early_blight.setVisibility(View.VISIBLE);
        }
        if(target_spot.getVisibility() == View.VISIBLE){
            target_spot.setVisibility(View.GONE);
        }
        if(bacterial_spot.getVisibility() == View.VISIBLE){
            bacterial_spot.setVisibility(View.GONE);
        }
        if(late_blight.getVisibility() == View.VISIBLE){
            late_blight.setVisibility(View.GONE);
        }
        if(tomato_mosic.getVisibility() == View.VISIBLE){
            tomato_mosic.setVisibility(View.GONE);
        }
        if(spectoria.getVisibility() == View.VISIBLE){
            spectoria.setVisibility(View.GONE);
        }
        if(leaf_mold.getVisibility() == View.VISIBLE){
            leaf_mold.setVisibility(View.GONE);
        }
        if(tylc.getVisibility() == View.VISIBLE){
            tylc.setVisibility(View.GONE);
        }






    }

    public void expand_spectoria(View view) {


        if(spectoria.getVisibility() == View.GONE){
            TransitionManager.beginDelayedTransition(spectoria,new AutoTransition());

            spectoria.setVisibility(View.VISIBLE);
        }
        if(target_spot.getVisibility() == View.VISIBLE){
            target_spot.setVisibility(View.GONE);
        }
        if(bacterial_spot.getVisibility() == View.VISIBLE){
            bacterial_spot.setVisibility(View.GONE);
        }
        if(late_blight.getVisibility() == View.VISIBLE){
            late_blight.setVisibility(View.GONE);
        }
        if(early_blight.getVisibility() == View.VISIBLE){
            early_blight.setVisibility(View.GONE);
        }
        if(tomato_mosic.getVisibility() == View.VISIBLE){
            tomato_mosic.setVisibility(View.GONE);
        }
        if(leaf_mold.getVisibility() == View.VISIBLE){
            leaf_mold.setVisibility(View.GONE);
        }
        if(tylc.getVisibility() == View.VISIBLE){
            tylc.setVisibility(View.GONE);
        }






    }

    public void expand_leaf_mold(View view) {


        if(leaf_mold.getVisibility() == View.GONE){
            TransitionManager.beginDelayedTransition(leaf_mold,new AutoTransition());

            leaf_mold.setVisibility(View.VISIBLE);
        }
        if(target_spot.getVisibility() == View.VISIBLE){
            target_spot.setVisibility(View.GONE);
        }
        if(bacterial_spot.getVisibility() == View.VISIBLE){
            bacterial_spot.setVisibility(View.GONE);
        }
        if(late_blight.getVisibility() == View.VISIBLE){
            late_blight.setVisibility(View.GONE);
        }
        if(early_blight.getVisibility() == View.VISIBLE){
            early_blight.setVisibility(View.GONE);
        }
        if(spectoria.getVisibility() == View.VISIBLE){
            spectoria.setVisibility(View.GONE);
        }
        if(tomato_mosic.getVisibility() == View.VISIBLE){
            tomato_mosic.setVisibility(View.GONE);
        }
        if(tylc.getVisibility() == View.VISIBLE){
            tylc.setVisibility(View.GONE);
        }






    }

    public void expand_tylc(View view) {
        if(tylc.getVisibility() == View.GONE){
            TransitionManager.beginDelayedTransition(tylc,new AutoTransition());

            tylc.setVisibility(View.VISIBLE);
        }
        if(target_spot.getVisibility() == View.VISIBLE){
            target_spot.setVisibility(View.GONE);
        }
        if(bacterial_spot.getVisibility() == View.VISIBLE){
            bacterial_spot.setVisibility(View.GONE);
        }
        if(late_blight.getVisibility() == View.VISIBLE){
            late_blight.setVisibility(View.GONE);
        }
        if(early_blight.getVisibility() == View.VISIBLE){
            early_blight.setVisibility(View.GONE);
        }
        if(spectoria.getVisibility() == View.VISIBLE){
            spectoria.setVisibility(View.GONE);
        }
        if(tomato_mosic.getVisibility() == View.VISIBLE){
            tomato_mosic.setVisibility(View.GONE);
        }
        if(tomato_mosic.getVisibility() == View.VISIBLE){
            tomato_mosic.setVisibility(View.GONE);
        }
    }

    public void back_to_home(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}