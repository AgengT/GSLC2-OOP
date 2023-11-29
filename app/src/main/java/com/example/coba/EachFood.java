package com.example.coba;

public class EachFood extends Food{
    public EachFood(String foodName, Integer calories) {
        super(foodName, calories);
    }
    @Override
    public String getDetails() {
        return "Food name: " + getFoodName() + "\nCalories: " + getCalories();
    }
    @Override
    public String toString() {
        return getDetails();
    }
}
