package com.example.countries.Activities;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countries.Fragments.Borders_Fragment;
import com.example.countries.Fragments.Country_Fragment;
import com.example.countries.Models.Country;
import com.example.countries.R;
import com.example.countries.Models.RecycleAdapter;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Main_Activity extends AppCompatActivity {
    private  int flag;
    private Country_Fragment country_Fragment;
    private FrameLayout MainActivityFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //findByView();
        MainActivityFrame=findViewById(R.id.Countries_frame);


        //Fragment switch
        country_Fragment = new Country_Fragment();
        ///connect the fragment into the main view frame
        getSupportFragmentManager().beginTransaction().add(R.id.Countries_frame, country_Fragment).commit();






    }


    public void LoadSecFragment(Country chosenCountry) // replace the first fragment with the second fragment
    {

        Borders_Fragment secondFregment = new Borders_Fragment();

        getIntent().putExtra("StateOb", chosenCountry);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.Countries_frame, secondFregment,(getSupportFragmentManager().getBackStackEntryCount()-1)+"").addToBackStack(null).commit();
        flag =1;
    }

    private void findByView() {

    }




    private void createList(){
        String sURL= "https://restcountries.eu/rest/v2/all?fields=name;nativeName;borders;flag";

        URL url= null;
        try {
             url = new URL(sURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

          // JsonParser jp = new JsonParser();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }
