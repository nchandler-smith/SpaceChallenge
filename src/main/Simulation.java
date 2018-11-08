package main;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    public List<Item> loadItems(){
        Item item = new Item("habitat", 100000);
        List<Item> loadedItems = new ArrayList<>();
        loadedItems.add(item);
        return loadedItems;
    }
}
