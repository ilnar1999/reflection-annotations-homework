package com.example.entity;

import com.example.annotation.Secured;

public class Entity {

    @Secured(number = 10)
    public void doFirst(int number, String text) {
    }

    public void doSecond() {

    }

    @Secured(number = 81, text = "anyText")
    private void doThird(int number, String text) {
    }
}
