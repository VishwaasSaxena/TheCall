package com.example.thecall;

public class Text {
    String text;
    String location;
    public Text(){

    }
    public Text(String text, String location) {
        this.text = text;
        this.location = location;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
