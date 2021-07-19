package com.example.countries.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countries.Activities.Main_Activity;
import com.example.countries.DataService;
import com.example.countries.Models.Country;
import com.example.countries.Models.RecycleAdapter;
import com.example.countries.R;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Country_Fragment extends Fragment {

   // private Callback_List callback_list;
    private Gson gson;
    final DataService ds = new DataService();

    //ron changes
    private TextView Header;
    private RecyclerView rv;
    private RecycleAdapter mAdapter;
    private ArrayList<Country> listCountries;




//    public void setCallBack_list(Callback_List callback_list) {
//        this.callback_list = callback_list;
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_countries, container, false);
        findViews(view);
        ///tEST
       // listCountries=new ArrayList<>();
        listCountries=  ds.getArrState();
        mAdapter= new RecycleAdapter( listCountries, view.getContext());
        rv.setAdapter(mAdapter);

        retriveDataToMain();

        //initiate variables
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        DividerItemDecoration decoration=new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(decoration);

        return view;
    }

    private void retriveDataToMain() {

        mAdapter.setOnItemClickListener(new RecycleAdapter.OnItemClickListener() {


            @Override
            public void onItemClicked(int position) {
                Country chosenCountry = listCountries.get(position);
                Main_Activity ma =(Main_Activity) getActivity();
                ma.LoadSecFragment(chosenCountry);
            }
        });
    }



    private void findViews(View view) {
        rv= view.findViewById(R.id.recyclerview);
        Header= view.findViewById(R.id.Countries_Header);
    }
}
