package main;

import main.Rocket;

public class U1 extends Rocket {

    public U1() {
        this.cost = 100;
        this.weight = 10;
        this.weightLimit = 18;
        this.launchExplosionChance = 0.05;
        this.landingCrashChance = 0.01;
    }
}
