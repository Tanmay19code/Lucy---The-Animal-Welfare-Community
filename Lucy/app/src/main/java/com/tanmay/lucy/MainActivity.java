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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
//    FirebaseFirestore firebaseFirestore;
    Button loginBTN,forgotPasswordBTN,newAccountBTN;
    EditText email,password;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        firebaseAuth = FirebaseAuth.getInstance();


        if (firebaseAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(MainActivity.this,HomeDashActivity.class));
            finish();
        }

        email = (EditText)findViewById(R.id.emailBox);
        password = (EditText)findViewById(R.id.passBox);

//        firebaseFirestore = FirebaseFirestore.getInstance();


        loginBTN = (Button) findViewById(R.id.submit);
        forgotPasswordBTN = (Button)findViewById(R.id.forgotPasswordButton);
        newAccountBTN = (Button)findViewById(R.id.loginBack);

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(email.getText().toString()) ||
                TextUtils.isEmpty(password.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, "Please! Enter valid credentials", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    loginMethod();
                    Validity();
                    
                }


            }
        });

        forgotPasswordBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPassMethod();
                startActivity(new Intent(MainActivity.this,ForgotPassword.class));
            }
        });

        newAccountBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignupActivity.class));
                newMethod();
            }
        });



    }


    public void newMethod() {
        Button signupBTN = (Button) findViewById(R.id.loginBack);

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        signupBTN.startAnimation(myAnim);
    }

    public void loginMethod() {
        Button loginBTN = (Button) findViewById(R.id.submit);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        loginBTN.startAnimation(myAnim);
    }

    public void forgotPassMethod() {
        Button forgotPasswordBTN = (Button) findViewById(R.id.forgotPasswordButton);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        forgotPasswordBTN.startAnimation(myAnim);
    }

    public void Validity()
    {

        firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, HomeDashActivity.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                password.setText("");
                password.setHint("If new, please register");
                Toast.makeText(MainActivity.this, "Wrong email and password!!", Toast.LENGTH_LONG).show();
            }
        });


    }
}