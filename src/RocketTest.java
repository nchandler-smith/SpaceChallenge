import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RocketTest {

    @Test
    void LaunchReturnsTrue() {
        Rocket rocket = new Rocket();

        assertTrue(rocket.launch());
    }

    @Test
    void LandReturnsTrue() {
        Rocket rocket = new Rocket();

        assertTrue(rocket.land());
    }

    @Test
    void Carry1UpdatesRocketWeight1() {
        Rocket rocket = new Rocket();

        Item item = new Item("test", 1);
        rocket.carry(item);

        assertEquals(1, rocket.getWeight());
    }

    @Test
    void Carry2UpdatesRocketWeight2() {
        Rocket rocket = new Rocket();

        Item item = new Item("test", 2);
        rocket.carry(item);

        assertEquals(2, rocket.getWeight());
    }

    @Test
    void CanCarryTrueWhenWeightLimitNotExceeded() {
        Rocket rocket = new Rocket();

        Item item = new Item("test", 1);

        assertTrue(rocket.canCarry(item));
    }

    @Test
    void CanCarryFalseWhenWeightLimitExceeded() {
        Rocket rocket = new Rocket();

        Item item = new Item("test", 2);

        assertFalse(rocket.canCarry(item));
    }
}