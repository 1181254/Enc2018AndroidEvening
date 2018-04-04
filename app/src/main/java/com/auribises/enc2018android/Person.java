package com.auribises.enc2018android;

import java.io.Serializable;

/**
 * Created by ishantkumar on 04/04/18.
 */

public class Person implements Serializable{

    String name;
    int age;

    public Person(){

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
