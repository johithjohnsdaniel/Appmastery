package com.devjockey.appmastery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    //Set Data

    Context context;
    List<Thumbnail> itemsList;

    public RecyclerAdapter(Context context, List<Thumbnail> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.recycler_view_layout, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //set data
        String current = itemsList.get(position).getName();

        //set name
        holder.txt.setText(current);

        String img_url = itemsList.get(position).getThumbnail().getMedium();
//set image
        Glide
                .with(context)
                .load(img_url)
                .centerCrop()
                .into(holder.img);


    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private final TextView txt;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image_view_img);
            txt = itemView.findViewById(R.id.txt_view);
        }
    }
}
