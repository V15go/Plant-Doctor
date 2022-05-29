package com.example.plantdoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile_page extends AppCompatActivity {

    TextView name, email_address, phone_number, location;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;
    private FirebaseUser user;

    BottomNavigationView bottomNavigationView;

    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        name = findViewById(R.id.profile_name);
        email_address = findViewById(R.id.email_dis);
        phone_number = findViewById(R.id.phone_dis);

        location = findViewById(R.id.location_dis);
        user = FirebaseAuth.getInstance().getCurrentUser();

        reference = FirebaseDatabase.getInstance().getReference("Registered users").child(user.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    name.setText(snapshot.child("Name").getValue().toString());
                    email_address.setText(snapshot.child("email").getValue().toString());
                    phone_number.setText(snapshot.child("phone").getValue().toString());
                    location.setText(snapshot.child("location").getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        bottomNavigationView = findViewById(R.id.bottom_profile);
        floatingActionButton = findViewById(R.id.fab_profile);


        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                Intent intent = new Intent(profile_page.this, MainActivity.class);
                startActivity(intent);
                return false;
            }
        });
        bottomNavigationView.getMenu().getItem(1).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {


                Intent intent = new Intent(profile_page.this, agri_clg_near_me.class);
                startActivity(intent);
                return false;
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profile_page.this, detection_page.class);
                startActivity(intent);
            }
        });









    }

    public void back_to_home(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}