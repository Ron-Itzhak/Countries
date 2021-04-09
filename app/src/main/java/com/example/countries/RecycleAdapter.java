package com.example.countries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    public List<Country> listCountries;
    public Context ct;

    //
    public  OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemLike(int position);
        void onItemDelete(int position);

    }
    public void  setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;

    }

    public RecycleAdapter(List<Country> listCountries, Context ct) {
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

        //get the details from countries Site

//        Glide.with(ct)
//                .load(Country.getImageUrl())
//                .into(holder.post_Img);

    }


    @Override
    public int getItemCount() {
        return listCountries.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView CountryFlag;
        public ViewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);
            CountryFlag = itemView.findViewById(R.id.country_picture);

        }

}


}