package com.tanmay.lucy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<myviewholder> {



    ArrayList<Model> data;
    public adapter(ArrayList<Model> data) {
        this.data = data;
    }

    @NotNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.feed,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull myviewholder holder, int position) {

        holder.caption.setText(data.get(position).getCaption());
        holder.description.setText(data.get(position).getDescription());
        holder.profImg.setImageResource(data.get(position).getProfImage());
        holder.feedImg.setImageResource(data.get(position).getPostImage());
        holder.name.setText(data.get(position).getUsername());
        holder.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.putExtra(Intent.EXTRA_TEXT,"This is share option");
//                intent.setType("text/plain");



            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
