package com.tanmay.lucy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class AnimalActActivity extends AppCompatActivity {

//    TextView rights6,prevention,section11,animalLaw,animalWelfare,animalVaccination;
    CardView faqCard,knowMoreCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_animal_act);
        setContentView(R.layout.animal_act_2);
        getSupportActionBar().hide();

//        rights6 = (TextView) findViewById(R.id.Rights6TXT);
//        prevention = (TextView) findViewById(R.id.preventionTXT);
//        section11 = (TextView) findViewById(R.id.section11TXT);
//        animalLaw = (TextView) findViewById(R.id.animalLawTXT);
//        animalWelfare = (TextView) findViewById(R.id.animalWelfareTXT);
//        animalVaccination = (TextView) findViewById(R.id.animalVaccinationTXT);

//        rights6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final Animation myAnim = AnimationUtils.loadAnimation(AnimalActActivity.this, R.anim.bounce);
//                rights6.startAnimation(myAnim);
//
//                String url = "https://www.indiatoday.in/education-today/gk-current-affairs/story/rules-for-animal-welfare-967061-2017-03-22";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        });
//        rights6.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                final Animation myAnim = AnimationUtils.loadAnimation(AnimalActActivity.this, R.anim.bounce);
//                rights6.startAnimation(myAnim);
//                return false;
//            }
//        });
//
//        prevention.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final Animation myAnim = AnimationUtils.loadAnimation(AnimalActActivity.this, R.anim.bounce);
//                prevention.startAnimation(myAnim);
//
//                String url = "https://www.indiacode.nic.in/bitstream/123456789/11237/1/the_prevention_of_cruelty_to_animals_act%2C_1960.pdf";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        });
//        prevention.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                final Animation myAnim = AnimationUtils.loadAnimation(AnimalActActivity.this, R.anim.bounce);
//                prevention.startAnimation(myAnim);
//                return false;
//            }
//        });
//
//        section11.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final Animation myAnim = AnimationUtils.loadAnimation(AnimalActActivity.this, R.anim.bounce);
//                section11.startAnimation(myAnim);
//
//                String url = "https://indiankanoon.org/doc/1763700/";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        });
//        section11.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                final Animation myAnim = AnimationUtils.loadAnimation(AnimalActActivity.this, R.anim.bounce);
//                section11.startAnimation(myAnim);
//                return false;
//            }
//        });
//
//        animalLaw.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final Animation myAnim = AnimationUtils.loadAnimation(AnimalActActivity.this, R.anim.bounce);
//                animalLaw.startAnimation(myAnim);
//
//                String url = "https://cupabangalore.org/animal-law/";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        });
//        animalLaw.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                final Animation myAnim = AnimationUtils.loadAnimation(AnimalActActivity.this, R.anim.bounce);
//                animalLaw.startAnimation(myAnim);
//                return false;
//            }
//        });
//
//        animalWelfare.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final Animation myAnim = AnimationUtils.loadAnimation(AnimalActActivity.this, R.anim.bounce);
//                animalWelfare.startAnimation(myAnim);
//
//                String url = "http://www.awbi.in/";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        });
//        animalWelfare.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                final Animation myAnim = AnimationUtils.loadAnimation(AnimalActActivity.this, R.anim.bounce);
//                animalWelfare.startAnimation(myAnim);
//                return false;
//            }
//        });
//
//        animalVaccination.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final Animation myAnim = AnimationUtils.loadAnimation(AnimalActActivity.this, R.anim.bounce);
//                animalVaccination.startAnimation(myAnim);
//
//                String url = "https://www.noah.co.uk/briefingdocument/vaccination-animal-health-overview/";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        });
//        rights6.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                final Animation myAnim = AnimationUtils.loadAnimation(AnimalActActivity.this, R.anim.bounce);
//                rights6.startAnimation(myAnim);
//                return false;
//            }
//        });

        faqCard = (CardView)findViewById(R.id.faqCard);
        knowMoreCard = (CardView)findViewById(R.id.knowMoreCard);

        faqCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(AnimalActActivity.this, R.anim.bounce);
                faqCard.startAnimation(myAnim);

                String url = "https://youthful-hopper-13df1d.netlify.app/animal_act.html";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        knowMoreCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(AnimalActActivity.this, R.anim.bounce);
                knowMoreCard.startAnimation(myAnim);

                String url = "https://youthful-hopper-13df1d.netlify.app/animal_act.html";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(AnimalActActivity.this,HomeDashActivity.class));
    }
}