package test;

import main.Item;
import main.Rocket;
import main.Simulation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {

    Simulation sim;
    String simFile = "SimulationPayloadTest.txt";
    String phase1File = "Phase1Payload.txt";

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

    @Test
    void loadU1FleetVerifyCargoWeight() {
        List<Item> manifest = sim.loadItems(phase1File);
        List<Rocket> fleet = sim.loadU1(manifest);

        assertEquals(6, fleet.get(0).getCargoWeight());
        assertEquals(5, fleet.get(1).getCargoWeight());
        assertEquals(8, fleet.get(2).getCargoWeight());
        assertEquals(5, fleet.get(3).getCargoWeight());
        assertEquals(6, fleet.get(4).getCargoWeight());
        assertEquals(5, fleet.get(5).getCargoWeight());
        assertEquals(6, fleet.get(6).getCargoWeight());
        assertEquals(8, fleet.get(7).getCargoWeight());
        assertEquals(6, fleet.get(8).getCargoWeight());
    }

    @Test
    void loadU2FleetVerifyCargoWeight() {
        List<Item> manifest = sim.loadItems(phase1File);
        List<Rocket> fleet = sim.loadU2(manifest);

        assertEquals(11, fleet.get(0).getCargoWeight());
        assertEquals(8, fleet.get(1).getCargoWeight());
        assertEquals(11, fleet.get(2).getCargoWeight());
        assertEquals(11, fleet.get(3).getCargoWeight());
        assertEquals(9, fleet.get(4).getCargoWeight());
        assertEquals(5, fleet.get(5).getCargoWeight());
    }
}