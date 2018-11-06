public class Rocket implements SpaceShip {
    int weight;


    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return false;
    }

    public void carry(Item item) {
        this.weight += item.getWeight();
    }

    public int getWeight() {
        return this.weight;
    }
}
