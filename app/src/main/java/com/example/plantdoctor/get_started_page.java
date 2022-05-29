package com.example.plantdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class get_started_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started_page);
    }

    public void sign_up_page_navi(View view) {
        Intent intent = new Intent(getApplicationContext(), sign_up_page.class);
        startActivity(intent
        );
    }

    public void login_navi(View view) {
        Intent intent = new Intent(getApplicationContext(), Login_page.class);
        startActivity(intent);
    }
}