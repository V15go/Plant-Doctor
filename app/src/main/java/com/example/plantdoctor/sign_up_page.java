package com.example.plantdoctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sign_up_page extends AppCompatActivity {


    EditText name_signup, email_signup, location_signup, phone_signup, password_signup;
    Button sign_up_btn;
    ImageView back_btn;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);


        name_signup = findViewById(R.id.sign_up_name);
        email_signup = findViewById(R.id.sign_up_email);
        location_signup = findViewById(R.id.sign_up_area);
        phone_signup = findViewById(R.id.sign_up_phone);
        password_signup = findViewById(R.id.sign_up_password);
        sign_up_btn = findViewById(R.id.sign_up_btn);

       back_btn = findViewById(R.id.back_btn_sign_up);

        progressDialog = new ProgressDialog(sign_up_page.this);
        progressDialog.setTitle("Hold On");
        progressDialog.setMessage("Your account is getting ready");
        progressDialog.setIcon(R.drawable.email);


        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_signup.getText().toString();
                String email = email_signup.getText().toString();
                String location = location_signup.getText().toString();
                String phone = phone_signup.getText().toString();
                String password = password_signup.getText().toString();
                String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email);

                if(name.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Name is Empty",Toast.LENGTH_LONG).show();
                    name_signup.setError("Name is Empty");
                }
                else if(email.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Email is Empty",Toast.LENGTH_LONG).show();
                    name_signup.setError("Email is Empty");
                }
                else if(location.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Location is Empty",Toast.LENGTH_LONG).show();
                    name_signup.setError("Location is Empty");
                }
                else if(phone.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Phone number is Empty",Toast.LENGTH_LONG).show();
                    name_signup.setError("Phone number is Empty");
                }
                else if(phone.length()!=10){
                    Toast.makeText(getApplicationContext(),"Phone number is Invalid",Toast.LENGTH_LONG).show();
                    name_signup.setError("Phone number is Invalid");
                }
                else if(!matcher.matches()){
                    Toast.makeText(getApplicationContext(),"Enter Valid Email Id",Toast.LENGTH_LONG).show();
                    email_signup.setError("Enter Valid Email Id");
                }
                else if(password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Password is Empty",Toast.LENGTH_LONG).show();
                    password_signup.setError("Password is Empty");
                }
                else if(password.length() < 8){
                    Toast.makeText(getApplicationContext(),"Password is Not Strong",Toast.LENGTH_LONG).show();
                    password_signup.setError("Password should contain atleast 8 characters");
                }
                else{
                    reg_the_user(name, email, phone, location,password);
                }
            }

            private void reg_the_user(String name, String email, String phone, String location, String password) {


                FirebaseAuth auth = FirebaseAuth.getInstance();

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(sign_up_page.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressDialog.show();
                            String id = task.getResult().getUser().getUid();
                            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Registered users");

                            HashMap<String,Object> map = new HashMap<>();

                            map.put("Name",name);
                            map.put("email",email);
                            map.put("location",location);
                            map.put("phone",phone);
                            map.put("password",password);

                            reference.child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(sign_up_page.this, "You Have been Registered. Please verify your email ID", Toast.LENGTH_LONG).show();
                                        progressDialog.dismiss();
                                        Intent intent = new Intent(sign_up_page.this,MainActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);

                                        finish();

                                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                    }
                                    else {
                                        progressDialog.dismiss();

                                        Toast.makeText(sign_up_page.this,"Registration failed. Do it again",Toast.LENGTH_LONG).show();

                                    }
                                }
                            });
                        }
                        else{
                            try {
                                throw Objects.requireNonNull(task.getException());
                            }
                            catch (FirebaseAuthWeakPasswordException e){
                                password_signup.setError("Your Password is too weak, Kindly use a mix of alphabets and numericals");
                                password_signup.requestFocus();

                            }
                            catch (FirebaseAuthInvalidCredentialsException e){
                                email_signup.setError("Your email is invalid or already in use. kindly re-entry");
                                email_signup.requestFocus();
                            }
                            catch (FirebaseAuthUserCollisionException e){
                                email_signup.setError("The email is already registered with us");
                                email_signup.requestFocus();
                            }
                            catch (Exception e){
                                Log.e("TAG", e.getMessage());
                                Toast.makeText(sign_up_page.this,e.getMessage(), Toast.LENGTH_LONG).show();
                            }
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