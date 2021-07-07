package com.tanmay.lucy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class AdoptionActivity extends AppCompatActivity {

    RecyclerView rev;
    adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption);
        getSupportActionBar().hide();

        rev = (RecyclerView) findViewById(R.id.rclView);
        rev.setLayoutManager(new LinearLayoutManager(this));

        adapter  = new adapter(dataqueue());
        rev.setAdapter(adapter);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(AdoptionActivity.this,HomeDashActivity.class));
    }

    public ArrayList<Model> dataqueue() {
        ArrayList<Model> holder = new ArrayList<>();
        Model obj1 =new Model();
        obj1.setDescription("I have rescued them from a big problem.Looking about to adopt them.Anyone who is interested can dm.");
        obj1.setCaption("Rescued Dogs");
        obj1.setUsername("Tanmay Mutalik");
        obj1.setProfImage(R.drawable.puppy);
        obj1.setPostImage(R.drawable.dog_rescue);
        holder.add(obj1);

        Model obj2 =new Model();
        obj2.setDescription("I adopted these kittens from an NGO");
        obj2.setCaption("My new kitten");
        obj2.setUsername("Manoj Tiwari");
        obj2.setProfImage(R.drawable.puppy);
        obj2.setPostImage(R.drawable.cat_adoption);
        holder.add(obj2);

        Model obj3 =new Model();
        obj3.setDescription("This is my horse. Is anyone interested to adopt.");
        obj3.setCaption("My horse - Chetak");
        obj3.setUsername("Vishwas Patwardhan");
        obj3.setProfImage(R.drawable.puppy);
        obj3.setPostImage(R.drawable.horse_adoption);
        holder.add(obj3);

        Model obj4 =new Model();
        obj4.setDescription("Please someone adopt these innocents");
        obj4.setCaption("Rabbits to be sold");
        obj4.setUsername("Vivek Agnihotri");
        obj4.setProfImage(R.drawable.puppy);
        obj4.setPostImage(R.drawable.rabbit_adoption);
        holder.add(obj4);

        Model obj5 =new Model();
        obj5.setDescription("Please can someone adopt it?");
        obj5.setCaption("Parrot Parody");
        obj5.setUsername("Chris Morris");
        obj5.setProfImage(R.drawable.puppy);
        obj5.setPostImage(R.drawable.parrot_adoption);
        holder.add(obj5);


        return holder;
    }
}