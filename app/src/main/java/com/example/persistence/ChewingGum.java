package com.example.persistence;

public class ChewingGum {
    long id;
    String taste;
    String chewiness;
    String color;
    public ChewingGum(long id, String taste, String chewiness, String color){
        this.id = id;
        this.taste= taste;
        this.chewiness = chewiness;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public String getTaste() {
        return taste;
    }

    public String getChewiness() {
        return chewiness;
    }

    public String getColor() {
        return color;
    }
}
