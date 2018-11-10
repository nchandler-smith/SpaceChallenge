package test;

import main.Item;
import main.Rocket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RocketTest {

    Rocket rocket;

    @BeforeEach
    void setUp() {
        rocket = new Rocket();
    }

    @Test
    void LaunchReturnsTrueTest() {
        assertTrue(rocket.launch());
    }

    @Test
    void LandReturnsTrueTest() {
        assertTrue(rocket.land());
    }

    @Test
    void Carry1UpdatesRocketCargoWeight1Test() {
        Item item = new Item("test", 1);
        rocket.carry(item);

        assertEquals(1, rocket.getCargoWeight());
    }

    @Test
    void Carry2UpdatesRocketWeight2Test() {
        Item item = new Item("test", 2);
        rocket.carry(item);

        assertEquals(2, rocket.getCargoWeight());
    }

    @Test
    void CanCarryTrueWhenWeightLimitNotExceededTest() {
        Item item = new Item("test", 1);

        assertTrue(rocket.canCarry(item));
    }

    @Test
    void CanCarryFalseWhenWeightLimitExceededTest() {
        Item item = new Item("test", 2);

        assertFalse(rocket.canCarry(item));
    }
}