package com.tanmay.lucy;

import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import io.grpc.Context;

public class myviewholder extends RecyclerView.ViewHolder {


    ImageView profImg,feedImg;
    ImageView likeButton,shareButton;
    TextView name,caption,description;
    int i = 0;

    public myviewholder(@NonNull @NotNull View itemView) {
        super(itemView);
        profImg = (ImageView) itemView.findViewById(R.id.profilePicture);
        feedImg = (ImageView) itemView.findViewById(R.id.postImage);
        name = (TextView) itemView.findViewById(R.id.userName);
        caption = (TextView) itemView.findViewById(R.id.caption);
        description = (TextView) itemView.findViewById(R.id.description);

//        shareButton = (ImageView)itemView.findViewById(R.id.shareButton);

        likeButton = (ImageView) itemView.findViewById(R.id.like);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Animation myAnim = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.bounce);
                likeButton.startAnimation(myAnim);

                if (i %2 == 0 ){
                    likeButton.setImageResource(R.drawable.ic_baseline_thumb_up_alt_24);
                    i = i+1;
                }
                else{
                    likeButton.setImageResource(R.drawable.ic_outline_thumb_up_alt_24);
                    i = i+1;
                }

            }
        });

//        shareButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(itemView.getContext(), "Hello", Toast.LENGTH_SHORT).show();
////                Intent intent = new Intent();
////                intent.setAction(Intent.ACTION_SEND);
////                intent.putExtra(Intent.EXTRA_TEXT,"This is a share function");
////                intent.setType("text/plain");
////                Intent.createChooser(intent,"Share via");
////                itemView.getContext().startActivity(intent);
//
//            }
//        });
    }
}