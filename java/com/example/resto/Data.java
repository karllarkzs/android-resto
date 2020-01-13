package com.example.resto;

public class Data {


        private String foodName;
        private String foodPrice;

    public Data(){

    }

    public Data (  String foodName , String foodPrice ) {

        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }




    public String getFoodName () {
        return foodName;
    }

    public void setFoodName ( String foodName ) {
        this.foodName = foodName;
    }

    public String getFoodPrice () {
        return foodPrice;
    }

    public void setFoodPrice ( String foodPrice ) {
        this.foodPrice = foodPrice;
    }
}
