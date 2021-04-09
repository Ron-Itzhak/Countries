package com.example.countries.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countries.Country;
import com.example.countries.R;
import com.example.countries.RecycleAdapter;

import java.util.ArrayList;
import java.util.List;


public class Main_Activity extends AppCompatActivity {

    private RecyclerView rv;
    private RecycleAdapter mAdapter;

    private List<Country> listCountries;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findByView();



        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration decoration=new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(decoration);
        listCountries=new ArrayList<>();
}

    private void findByView() {
        rv=findViewById(R.id.rec);

    }
    }
