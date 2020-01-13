package com.example.resto;

public class Model {

    String Name, image, Price; //declared variables in firebase


    // constructor
    public Model () {


    }

    public String getName () {
        return Name;
    }

    public void setName ( String name ) {
        Name = name;
    }

    public String getPrice () {
        return Price;
    }

    public void setPrice ( String price ) {
        Price = price;
    }
}

