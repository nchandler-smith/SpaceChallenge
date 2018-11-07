package main;

import main.Rocket;

public class U2 extends Rocket {

    public U2() {
        this.cost = 120;
        this.weight = 18;
        this.weightLimit = 29;
        this.launchExplosionChance = 0.04;
        this.landingCrashChance = 0.08;
    }
}
