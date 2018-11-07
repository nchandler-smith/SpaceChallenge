package main;

import main.Item;

public class Rocket implements SpaceShip {
    int weight;
    int maxWeight;

    public Rocket() {
        this.weight = 0;
        this.maxWeight = 1;
    }

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return this.weight + item.getWeight() <= this.maxWeight;
    }

    public void carry(Item item) {
        this.weight += item.getWeight();
    }

    public int getWeight() {
        return this.weight;
    }
}
