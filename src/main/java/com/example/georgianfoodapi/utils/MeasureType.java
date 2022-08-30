package com.example.georgianfoodapi.utils;

public enum MeasureType {
    GRAM("Gram"),
    KILOGRAM("Kilogram"),
    PINCH("Pinch"),
    LITER("Liter"),
    QUART("Quart"),
    DROP("Drop"),
    CUP("Cup"),
    TABLESPOON("Tablespoon"),
    TEASPOON("Teaspoon");

    private final String measureType;

    MeasureType(String measureType) {
        this.measureType = measureType;
    }

    public String getMeasureType() {
        return this.measureType;
    }
}
