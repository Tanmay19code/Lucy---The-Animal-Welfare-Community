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

import java.util.Objects;

public class HelpActivity extends AppCompatActivity {
    EditText query;
    Button ask;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(HelpActivity.this, HomeDashActivity.class));
    }

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        getSupportActionBar().hide();
        query = (EditText)findViewById(R.id.queryTXT);
        ask  = (Button)findViewById(R.id.askBTN);
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();


        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(query.getText().toString())) {

                    final Animation myAnim = AnimationUtils.loadAnimation(HelpActivity.this, R.anim.bounce);
                    ask.startAnimation(myAnim);
                    addQuery();
                }
                else
                {
                    Toast.makeText(HelpActivity.this, "Please enter a valid query", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void addQuery() {

        UserData question = new UserData();
        question.setName(query.getText().toString());

        String user_email = Objects.requireNonNull(firebaseAuth.getCurrentUser()).getEmail();
        firebaseFirestore.collection("HelpDesk")
                .document(Objects.requireNonNull(user_email)).set(question)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(HelpActivity.this, "Your query is successfully submitted\nYou will be answered soon!", Toast.LENGTH_LONG).show();
                        query.setText("");

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {

                    }
                });

    }
}