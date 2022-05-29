package com.example.plantdoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login_page extends AppCompatActivity {

    EditText email_login, password_login;

    Button login_btn;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        email_login  = findViewById(R.id.login_email);
        password_login = findViewById(R.id.password_login);
        login_btn = findViewById(R.id.login_btn);


        progressDialog = new ProgressDialog(Login_page.this);
        progressDialog.setIcon(R.drawable.email);
        progressDialog.setTitle("Hold on");
        progressDialog.setMessage("Getting you in");
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email  = email_login.getText().toString();
                String password = password_login.getText().toString();
                String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email);
                if(email.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Email is Empty",Toast.LENGTH_LONG).show();
                    email_login.setError("Email is Empty");
                }
                else if(!matcher.matches()){
                    Toast.makeText(getApplicationContext(),"Enter Valid Email Id",Toast.LENGTH_LONG).show();
                    email_login.setError("Enter Valid Email Id");
                }
                else if(password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Password is Empty",Toast.LENGTH_LONG).show();
                    password_login.setError("Password is Empty");
                }
                else if(password.length() < 8){
                    Toast.makeText(getApplicationContext(),"Password is Not Strong",Toast.LENGTH_LONG).show();
                    password_login.setError("Password should contain atleast 8 characters");
                }
                else{
                   login_user(email, password);
                }
            }

            private void login_user(String email, String password) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressDialog.show();
                            Toast.makeText(Login_page.this,"Welcome Back!",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Login_page.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                            progressDialog.dismiss();
                            finish();
                        }
                        else{
                            progressDialog.dismiss();
                            Toast.makeText(Login_page.this, "Something went wrong! Ensure that the email or password is correct or Verfication of email may not be done", Toast.LENGTH_LONG).show();
                            email_login.setError("Check your username");
                            email_login.requestFocus();
                            password_login.setError("Check your Password");
                            password_login.requestFocus();
                        }
                    }
                });



            }
        });


    }


    public void back_to_getstarted(View view) {
        Intent intent = new Intent(getApplicationContext(),get_started_page.class);
        startActivity(intent);
    }
}