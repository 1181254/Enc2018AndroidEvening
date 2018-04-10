package com.auribises.enc2018android;

import java.io.Serializable;

/**
 * Created by ishantkumar on 10/04/18.
 */

public class Enquiry implements Serializable{

    public boolean cpp;
    public boolean java;
    public boolean python;

    public String gender;

    public float rating;

    public String city;

    public String name;

    public Enquiry(){

    }

    public Enquiry(boolean cpp, boolean java, boolean python, String gender, float rating, String city, String name) {
        this.cpp = cpp;
        this.java = java;
        this.python = python;
        this.gender = gender;
        this.rating = rating;
        this.city = city;
        this.name = name;
    }

    public boolean isCpp() {
        return cpp;
    }

    public void setCpp(boolean cpp) {
        this.cpp = cpp;
    }

    public boolean isJava() {
        return java;
    }

    public void setJava(boolean java) {
        this.java = java;
    }

    public boolean isPython() {
        return python;
    }

    public void setPython(boolean python) {
        this.python = python;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
