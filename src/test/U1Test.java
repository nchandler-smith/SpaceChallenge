package test;

import main.Item;
import main.U1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class U1Test {

    U1 u1;

    @BeforeEach
    void setup() {
        u1 = new U1();
    }

    @Test
    void U1CostEquals100MillionTest() {
        assertEquals(100, u1.getCost());
    }

    @Test
    void U1WeightsEquals10TonnesTest() {
        assertEquals(10, u1.getCargoWeight());
    }

    @Test
    void U1NoCargoLaunchExplosion0PercentTest() {
        assertEquals(0.0, u1.getLaunchExplosionChance());
    }

    @Test
    void U1FullCargoLaunchExplosion5PercentTest() {
        Item item = new Item("test", 8);

        u1.carry(item);

        assertEquals(0.05, u1.getLaunchExplosionChance());
    }

    @Test
    void U1NoCargoLandingCrash0PercentTest() {
        assertEquals(0.0, u1.getLandingCrashChance());
    }

    @Test
    void U1FullCargoLandingCrash1PercentTest() {
        Item item = new Item("test", 8);

        u1.carry(item);

        assertEquals(0.01, u1.getLandingCrashChance());
    }
}