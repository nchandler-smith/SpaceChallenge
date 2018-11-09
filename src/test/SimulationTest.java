package test;

import main.Simulation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void ReadLineHabitatEquals100000Test() {
        Simulation sim = new Simulation();
        String filename = "SimulationTest.txt";

        assertEquals("habitat", sim.loadItems(filename).get(0).getName());
        assertEquals(1, sim.loadItems(filename).get(0).getWeight());
    }

    @Test
    void ReadLineColonyEquals50000Test() {
        Simulation sim = new Simulation();
        String filename = "SimulationTest.txt";

        assertEquals("colony", sim.loadItems(filename).get(1).getName());
        assertEquals(5, sim.loadItems(filename).get(1).getWeight());
    }

    @Test
    void loadU1TestNeed2U1RocketsTest() {
        Simulation sim = new Simulation();
        String filename = "SimulationTest.txt";

        assertEquals(2, sim.loadU1(sim.loadItems(filename)).size());
    }
}