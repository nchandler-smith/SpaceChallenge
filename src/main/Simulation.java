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
        List<Rocket> rockets = new ArrayList();
        U1 u1 = new U1();

        for (Item item : loadedItems ) {
            System.out.println("Rocket weight: " + u1.getWeight());
            if (u1.canCarry(item)) {
                u1.carry(item);
            } else {
                rockets.add(u1);
                u1 = new U1();
                u1.carry(item);
            }
        }
        rockets.add(u1);
        return rockets;
    }
}
