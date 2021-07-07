package com.tanmay.lucy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class EmergencyActivity extends AppCompatActivity {
    CardView medicalCard,vaccineCard,accidentCard,missingCard,foodCard,accessoriesCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        getSupportActionBar().hide();

        medicalCard = (CardView)findViewById(R.id.medicalCard);
        accidentCard = (CardView)findViewById(R.id.accidentCard);
        missingCard = (CardView)findViewById(R.id.missingCard);
        foodCard = (CardView)findViewById(R.id.foodCard);
        accessoriesCard = (CardView)findViewById(R.id.accessoriesCard);
        vaccineCard = (CardView)findViewById(R.id.vaccineCard);

        medicalCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(EmergencyActivity.this, R.anim.bounce);
                medicalCard.startAnimation(myAnim);

                String url = "https://youthful-hopper-13df1d.netlify.app/medical.html";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        accidentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(EmergencyActivity.this, R.anim.bounce);
                accidentCard.startAnimation(myAnim);

//                String url = "";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
                Toast.makeText(EmergencyActivity.this, "This feature is not added till now", Toast.LENGTH_SHORT).show();
            }
        });

        missingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(EmergencyActivity.this, R.anim.bounce);
                missingCard.startAnimation(myAnim);

//                String url = "";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);

                Toast.makeText(EmergencyActivity.this, "This feature is not added till now", Toast.LENGTH_SHORT).show();
            }
        });

        foodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(EmergencyActivity.this, R.anim.bounce);
                foodCard.startAnimation(myAnim);

                String url = "https://youthful-hopper-13df1d.netlify.app/food.html";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        accessoriesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(EmergencyActivity.this, R.anim.bounce);
                accessoriesCard.startAnimation(myAnim);

//                String url = "";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);

                Toast.makeText(EmergencyActivity.this, "This feature is not added till now", Toast.LENGTH_SHORT).show();
            }
        });

        vaccineCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(EmergencyActivity.this, R.anim.bounce);
                vaccineCard.startAnimation(myAnim);

                String url = "https://youthful-hopper-13df1d.netlify.app/vaccination.html";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(EmergencyActivity.this,HomeDashActivity.class));
    }
}