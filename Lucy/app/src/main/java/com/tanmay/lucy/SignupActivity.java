package com.tanmay.lucy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

public class SignupActivity extends AppCompatActivity {
    Button loginBTN,newAccountBTN;
    EditText email,pass,mobile,name;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        email = (EditText)findViewById(R.id.emailBox);
        pass = (EditText)findViewById(R.id.passBox);
        mobile = (EditText)findViewById(R.id.mobileNo);
        name = (EditText)findViewById(R.id.name);

        loginBTN = (Button) findViewById(R.id.submit);
        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, MainActivity.class));
                loginMethod();
            }
        });

        newAccountBTN = (Button) findViewById(R.id.loginBack);
        newAccountBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(pass.getText().toString())
                || TextUtils.isEmpty(mobile.getText().toString()) || TextUtils.isEmpty(name.getText().toString()))
                {
                    Toast.makeText(SignupActivity.this, "Please enter all the details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    AddData();
                    newAccountMethod();
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(SignupActivity.this, MainActivity.class));
    }

    public void loginMethod(){
        loginBTN = (Button)findViewById(R.id.submit);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        loginBTN.startAnimation(myAnim);
    }

    public void newAccountMethod(){
        newAccountBTN = (Button)findViewById(R.id.loginBack);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        newAccountBTN.startAnimation(myAnim);
    }

    public void AddData(){
        UserData data = new UserData();
        data.setName(name.getText().toString());
        data.setEmail(email.getText().toString());
        data.setMobileNo(mobile.getText().toString());
        data.setPassword(pass.getText().toString());

        firebaseFirestore.collection("UserInfo").document(email.getText().toString()).set(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),pass.getText().toString());
                        Toast.makeText(SignupActivity.this, "Registration Succesfull....", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupActivity.this,MainActivity.class));
                        Toast.makeText(SignupActivity.this, "Login To the app", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        Toast.makeText(SignupActivity.this, "Registration Failed!!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
