package main;

import main.Rocket;

public class U1 extends Rocket {

    int cost;
    static int weightLimit = 18;

    public U1() {
        this.cost = 100;
        this.weight = 10;
    }

    public int getCost() {
        return this.cost;
    }

    public double getLaunchExplosionChance() {
        return (0.05 * (this.weight / this.weightLimit));
    }

    public boolean launch() {
        return Math.random() > getLaunchExplosionChance();
    }

    public double getLandingCrashChance() {
        return (0.01 * (this.weight / this.weightLimit));
    }

    public boolean land() {
        return Math.random() > getLandingCrashChance();
    }
}
