package com.example.countries.Models;


import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Country implements Serializable {
    private String name;
    private String nativeName;
    private String flag;
    private ArrayList<String> borders;

    public Country() {
        //empty constructor
    }

    public Country(String name,String nativeName,String flag,ArrayList<String> borders) {
        this.name=name;
        this.nativeName=nativeName;
        this.flag=flag;
        this.borders = borders;

    }
    public String getName() {
        return name;
    }

    public List<String> getBorders() {
        return borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getFlagUrl() {
        return flag;
    }



}