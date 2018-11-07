package main;

import main.Item;

public class Rocket implements SpaceShip {

    int cost;
    int weight;
    int weightLimit;
    double launchExplosionChance;
    double landingCrashChance;

    public Rocket() {
        this.weight = 0;
        this.weightLimit = 1;
    }

    public int getCost() {
        return this.cost;
    }

    public int getWeight() {
        return this.weight;
    }

    public double getLaunchExplosionChance() {
        return (this.launchExplosionChance * (this.weight / this.weightLimit));
    }

    public boolean launch() {
        return Math.random() > getLaunchExplosionChance();
    }

    public double getLandingCrashChance() {
        return (this.landingCrashChance * (this.weight / this.weightLimit));
    }

    public boolean land() {
        return Math.random() > getLandingCrashChance();
    }

    public boolean canCarry(Item item) {
        return this.weight + item.getWeight() <= this.weightLimit;
    }

    public void carry(Item item) {
        this.weight += item.getWeight();
    }
}
