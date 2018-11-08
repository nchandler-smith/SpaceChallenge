package test;

import main.Simulation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void ReadLineHabitatEquals100000Test() {
        Simulation sim = new Simulation();
        String filename = "test.txt";

        assertEquals("habitat", sim.loadItems(filename).get(0).getName());
        assertEquals(100000, sim.loadItems(filename).get(0).getWeight());
    }

    @Test
    void ReadLineColonyEquals50000Test() {
        Simulation sim = new Simulation();
        String filename = "test.txt";

        assertEquals("colony", sim.loadItems(filename).get(1).getName());
        assertEquals(50000, sim.loadItems(filename).get(1).getWeight());
    }

}