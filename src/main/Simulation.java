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
                Item item = new Item(parts[0], Integer.parseInt(parts[1]));
                loadedItems.add(item);
            }
        } catch (FileNotFoundException e) {
        }
        return loadedItems;
    }
}
