package test;

import main.Item;
import main.Rocket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RocketTest {

    @Test
    void LaunchReturnsTrueTest() {
        Rocket rocket = new Rocket();

        assertTrue(rocket.launch());
    }

    @Test
    void LandReturnsTrueTest() {
        Rocket rocket = new Rocket();

        assertTrue(rocket.land());
    }

    @Test
    void Carry1UpdatesRocketWeight1Test() {
        Rocket rocket = new Rocket();

        Item item = new Item("test", 1);
        rocket.carry(item);

        assertEquals(1, rocket.getWeight());
    }

    @Test
    void Carry2UpdatesRocketWeight2Test() {
        Rocket rocket = new Rocket();

        Item item = new Item("test", 2);
        rocket.carry(item);

        assertEquals(2, rocket.getWeight());
    }

    @Test
    void CanCarryTrueWhenWeightLimitNotExceededTest() {
        Rocket rocket = new Rocket();

        Item item = new Item("test", 1);

        assertTrue(rocket.canCarry(item));
    }

    @Test
    void CanCarryFalseWhenWeightLimitExceededTest() {
        Rocket rocket = new Rocket();

        Item item = new Item("test", 2);

        assertFalse(rocket.canCarry(item));
    }
}