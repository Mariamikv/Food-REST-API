package com.example.georgianfoodapi.utils;

public enum MealType {
    BREAKFAST("Breakfast"),
    BRANCH("Branch"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    SNACK("Snack"),
    TEATIME("Teatime");

    private final String mealType;

    MealType(String mealType) {
        this.mealType = mealType;
    }

    public String getMealType() {
        return this.mealType;
    }
}
