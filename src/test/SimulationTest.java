package test;

import main.Simulation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    Simulation sim;
    String simFile = "SimulationPayloadTest.txt";
    String u1SimFile = "U1TestPayload.txt";
    String u2SimFile = "U2TestPayload.txt";

    @BeforeEach
    void setup(){
        sim = new Simulation();
    }

    @Test
    void ReadLineHabitatEquals100000Test() {
        assertEquals("habitat", sim.loadItems(simFile).get(0).getName());
        assertEquals(1, sim.loadItems(simFile).get(0).getWeight());
    }

    @Test
    void ReadLineColonyEquals50000Test() {
        assertEquals("colony", sim.loadItems(simFile).get(1).getName());
        assertEquals(5, sim.loadItems(simFile).get(1).getWeight());
    }

    @Test
    void loadU1Need2U1RocketsTest() {
        assertEquals(2, sim.loadU1(sim.loadItems(simFile)).size());
    }

    @Test
    void loadU2Need1U2RocketsTest() {
        assertEquals(1, sim.loadU2(sim.loadItems(simFile)).size());
    }
}