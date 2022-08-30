package com.example.georgianfoodapi.utils;

public enum DishType {
    ALCOHOL_COCKTAIL("Alcohol cocktail"),
    BISCUITS_COOKIES("Biscuits and cookies"),
    BREAD("Bread"),
    CONDIMENTS_SAUCES("Condiments and sauces"),
    DESSERTS("Desserts"),
    DRINKS("Drinks"),
    EGG("Egg"),
    ICE_CREAM_CUSTARD("Ice cream and custard"),
    MAIN_COURSE("Main course"),
    PANCAKE("Pancake"),
    PREPS("Preps"),
    PRESERVE("Preserve"),
    SALAD("Salad"),
    SEAFOOD("Seafood"),
    SIDE_DISH("Side dish"),
    SOUP("Soup");

    private final String dishType;

    DishType(String dishType) {
        this.dishType = dishType;
    }

    public String getDishType() {
        return this.dishType;
    }
}
