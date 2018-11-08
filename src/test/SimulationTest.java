package test;

import main.Item;
import main.Simulation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    @Test
    void ReadLineHabitatEquals100000Test() {
        Simulation sim = new Simulation();

        assertEquals("habitat", sim.loadItems().get(0).getName());
        assertEquals(100000l, sim.loadItems().get(0).getWeight());
    }

}