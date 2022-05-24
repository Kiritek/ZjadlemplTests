package com.zjadlem;

public class HomePage {

    static String url = "https://zjadlem.pl/";
    static String title = "Zjadłem.pl | Podziel się swoją opinią!";
    public void goTo(){
        Browser.goTo(url);
    }
    public boolean isAt(){
        return Browser.title().equals(title);
    }
}
