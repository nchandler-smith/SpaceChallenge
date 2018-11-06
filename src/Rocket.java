public class Rocket implements SpaceShip {



    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return false;
    }

    public boolean carry(Item item) {
        return true;
    }

    public int getWeight() {
        return 1000;
    }
}
