package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {

    public List<Item> loadItems(String filename)  {
        List<Item> loadedItems = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                loadedItems.add(parseLineItem((line)));
            }
        } catch (FileNotFoundException e) {
            // logging
        }
        return loadedItems;
    }

    private Item parseLineItem(String line) {
        int kgPerTonne = 1000;
        // line in file: 'itemName = itemWeight'
        String[] parts = line.split("=");
        int weight = Integer.parseInt(parts[1])/kgPerTonne;
        Item item = new Item(parts[0], weight);
        return item;
    }

    public List<Rocket> loadU1(List<Item> loadedItems){
        U1 u1 = new U1();
        return loadRocketFleet(loadedItems, u1);
    }

    public List<Rocket> loadU2(List<Item> loadedItems) {
        U2 u2 = new U2();
        return loadRocketFleet(loadedItems, u2);
    }

    public int runSimulation(List<Rocket> rocketList) {
        int totalRocketCost = 0;

        for (Rocket rocket: rocketList) {
            sendGargoUntilSuccessful(rocket, totalRocketCost);
        }
        return totalRocketCost;
    }

    private List<Rocket> loadRocketFleet(List<Item> loadedItems, Rocket rocket) {
        List<Rocket> rocketsList = new ArrayList();

        for (Item item : loadedItems ) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rocketsList.add(rocket);
                rocket = new Rocket();
                rocket.carry(item);
            }
        }
        rocketsList.add(rocket);
        System.out.println("Cargo will require at least " + rocketsList.size() + " rockets.");
        return rocketsList;
    }

    private int sendGargoUntilSuccessful(Rocket rocket, int totalRocketCost) {
        boolean launchSuccessful = rocket.launch();
        boolean landingSuccessful = rocket.land();
        totalRocketCost += rocket.getCost();

        if (launchSuccessful && landingSuccessful) {
            System.out.println("Cargo safely arrived!");
        }
        else if (!launchSuccessful) {
            System.out.println("Launch explosion! Retrying...");
            sendGargoUntilSuccessful(rocket, totalRocketCost);
        }
        else {
            System.out.println("Landing explosion! Retrying...");
            sendGargoUntilSuccessful(rocket, totalRocketCost);
        }
        return totalRocketCost;
    }
}
