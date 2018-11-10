package main;

public class Rocket implements SpaceShip {

    protected int cost;
    protected int cargoWeight;
    protected int weightLimit;
    protected double launchExplosionChance;
    protected double landingCrashChance;

    public Rocket() {
        this.cargoWeight = 0;
        this.weightLimit = 1;
    }
    public boolean launch() { return Math.random() > getLaunchExplosionChance(); }

    public boolean land() { return Math.random() > getLandingCrashChance(); }

    public boolean canCarry(Item item) {
        return this.cargoWeight + item.getWeight() <= this.weightLimit;
    }

    public void carry(Item item) {
        this.cargoWeight += item.getWeight();
    }

    public int getCargoWeight() {
        return this.cargoWeight;
    }

    public int getCost() {
        return this.cost;
    }

    public double getLaunchExplosionChance() {
        return (this.launchExplosionChance * (this.cargoWeight / this.weightLimit));
    }

    public double getLandingCrashChance() { return (this.landingCrashChance * (this.cargoWeight / this.weightLimit)); }
}
