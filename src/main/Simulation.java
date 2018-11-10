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
            totalRocketCost += rocket.getCost();
            while (!rocket.launch() || !rocket.land()) {
                totalRocketCost += rocket.getCost();
            }
        }

        return totalRocketCost;
    }

    private List<Rocket> loadRocketFleet(List<Item> loadedItems, Rocket rocketIn) {
        List<Rocket> rocketsList = new ArrayList();

        for (Item item : loadedItems ) {
            if (rocketIn.canCarry(item)) {
                rocketIn.carry(item);
            } else {
                rocketsList.add(rocketIn);
                rocketIn = new Rocket();
                rocketIn.carry(item);
            }
        }
        rocketsList.add(rocketIn);
        return rocketsList;
    }
}
