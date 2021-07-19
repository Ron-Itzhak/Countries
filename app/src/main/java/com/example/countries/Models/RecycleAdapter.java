package com.example.countries.Models;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.countries.MyGlideModule;
import com.example.countries.R;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    public ArrayList<Country> listCountries;
    public Context ct;

    //
    public  OnItemClickListener mListener;


    public interface OnItemClickListener{
        void onItemClicked(int position);

    }
    public void  setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;

    }

    public RecycleAdapter(ArrayList<Country> listCountries, Context ct) {
        this.listCountries = listCountries;
        this.ct = ct;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country, parent, false);
        return new ViewHolder(view,mListener);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = listCountries.get(position);


        //set the details to each country
        GlideToVectorYou.init()
                .with(ct)
                .load(Uri.parse(country.getFlagUrl()), holder.CountryFlag);

        holder.Countryname.setText(country.getName());
        holder.nativename.setText(country.getNativeName());

    }


    @Override
    public int getItemCount() {
        return listCountries.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView CountryFlag;
        TextView Countryname,nativename;
        public ViewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);
            CountryFlag = itemView.findViewById(R.id.country_picture);
            Countryname = itemView.findViewById(R.id.CountryNameTxt);
            nativename = itemView.findViewById(R.id.NativeNameTxt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!= null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onItemClicked(position);
                        }
                    }
                }
            });


        }


    }


}