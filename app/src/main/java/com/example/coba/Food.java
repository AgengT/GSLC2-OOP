package com.example.coba;

abstract public class Food {

    String foodName;

    Integer calories;

    public Food(String foodName, Integer calories) {
        this.foodName = foodName;
        this.calories = calories;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public abstract String getDetails();
}
