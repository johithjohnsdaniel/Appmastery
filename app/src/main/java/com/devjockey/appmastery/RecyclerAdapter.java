package com.devjockey.appmastery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    //Set Data
    Context context;
    ArrayList<DataMembers> dataMemberList;

    public RecyclerAdapter(Context context, ArrayList<DataMembers> dataMemberList) {
        this.context = context;
        this.dataMemberList = dataMemberList;
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
        DataMembers currentItem=dataMemberList.get(position);
        String image_url_get=currentItem.getImage_url();
        Picasso.get().load(image_url_get).fit().centerInside().into(holder.img);


    }

    @Override
    public int getItemCount() {
        return dataMemberList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private  ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image_view_img);
        }
    }
}
