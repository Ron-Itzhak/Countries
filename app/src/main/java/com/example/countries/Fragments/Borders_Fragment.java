package com.example.countries.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countries.DataService;
import com.example.countries.Models.Country;
import com.example.countries.Models.RecycleAdapter;
import com.example.countries.R;

import java.util.ArrayList;

public class Borders_Fragment extends Fragment {
    private Country country;
    private RecyclerView rv;
    private RecycleAdapter mAdapter;
    private ArrayList<Country> listCountries;

    private Button backBTN;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_countries, container, false);
        findViews(view);
        ///tEST
        // listCountries=new ArrayList<>();



        backBTN.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

               // Go_back_fragment();
            }
        });
        // Inflate the layout for this fragment
        final DataService ds = new DataService();


        listCountries=  ds.getArrState();
        mAdapter= new RecycleAdapter( listCountries, view.getContext());
        rv.setAdapter(mAdapter);


        //initiate variables
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext()));
        DividerItemDecoration decoration=new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(decoration);




        ///// fragment actions
        Intent i = getActivity().getIntent();
        Country co = (Country) i.getSerializableExtra("StateOb");

         listCountries = new ArrayList<>();

        for(String s : co.getBorders()){ // find all the borders for one given state

            //listCountries.add(ds.getNstateFromBstate(s));
        }


        return view;
    }
    private void findViews(View view) {
        rv= view.findViewById(R.id.recyclerview);

        backBTN =  view.findViewById(R.id.BRDS_backButton);

    }
}
