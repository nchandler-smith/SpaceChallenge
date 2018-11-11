package main;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Running phase 1 simulation with U1 rockets.");
        System.out.println("-------------------------------------------");
        Simulation sim = new Simulation();
        List<Item> manifest = sim.loadItems("Phase1Payload.txt");
        List<Rocket> fleet = sim.loadU1(manifest);
        int budget = sim.runSimulation(fleet);
        System.out.println("===================================");
        System.out.println("This is expected to cost: " + budget);

        
    }
}
