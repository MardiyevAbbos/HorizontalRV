package com.example.horizontalrv.model;

import java.util.ArrayList;

public class Fruit {
    public ArrayList<FruitSub> fruitSubs;

    public Fruit(ArrayList<FruitSub> fruitSubs) {
        this.fruitSubs = fruitSubs;
    }

    public ArrayList<FruitSub> getFruitSubs() {
        return fruitSubs;
    }

    public void setFruitSubs(ArrayList<FruitSub> fruitSubs) {
        this.fruitSubs = fruitSubs;
    }

}
