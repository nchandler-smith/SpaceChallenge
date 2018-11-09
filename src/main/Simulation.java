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
                String[] parts = line.split("=");
                Item item = new Item(parts[0], Integer.parseInt(parts[1])/1000);
                loadedItems.add(item);
            }
        } catch (FileNotFoundException e) {
        }
        return loadedItems;
    }

    public List<Rocket> loadU1(List<Item> loadedItems){
        U1 u1 = new U1();
        return loadRocket(loadedItems, u1);
    }

    public List<Rocket> loadU2(List<Item> loadedItems) {
        U2 u2 = new U2();
        return loadRocket(loadedItems, u2);
    }

    private List<Rocket> loadRocket(List<Item> loadedItems, Rocket rocketIn) {
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
