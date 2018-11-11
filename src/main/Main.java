package main;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        simRunner("Phase1Payload.txt", "U1");
        simRunner("Phase1Payload.txt", "U2");
        simRunner("Phase2Payload.txt", "U1");
        simRunner("Phase2Payload.txt", "U2");

    }

    private static void simRunner(String filename, String rocketName) {
        String phase = filename.substring(5,6);
        List<Rocket> fleet;
        System.out.println("*******************************************");
        System.out.println("Loading Phase " + phase + " with " + rocketName + " rockets.");
        System.out.println("*******************************************");
        Simulation sim = new Simulation();
        List<Item> manifest = sim.loadItems(filename);
        if (rocketName == "U1") {
            fleet = sim.loadU1(manifest);
        } else {
            fleet = sim.loadU2(manifest);
        }
        int budget = sim.runSimulation(fleet);
        System.out.println("===================================");
        System.out.println("This is expected to cost: " + budget + "\n\n");
    }
}
