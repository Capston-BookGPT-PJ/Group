package com.example.meltingbooks;

public class User {
    private String name;
    private String intro;

    public User(String name, String intro) {
        this.name = name;
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public String getIntro() {
        return intro;
    }
}