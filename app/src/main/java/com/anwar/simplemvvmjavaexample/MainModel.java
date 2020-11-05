package com.anwar.simplemvvmjavaexample;

public class MainModel {
    private final String name;
    private final String image_url;

    public MainModel(String name, String image_url) {
        this.name = name;
        this.image_url = image_url;

    }

    public String getName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }


}