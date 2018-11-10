package test;

import main.Item;
import main.U1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class U1Test {

    @Test
    void U1CostEquals100MillionTest() {
        U1 u1 = new U1();

        assertEquals(100, u1.getCost());
    }

    @Test
    void U1WeightsEquals10TonnesTest() {
        U1 u1 = new U1();

        assertEquals(10, u1.getCargoWeight());
    }

    @Test
    void U1NoCargoLaunchExplosion0PercentTest() {
        U1 u1 = new U1();

        assertEquals(0.0, u1.getLaunchExplosionChance());
    }

    @Test
    void U1FullCargoLaunchExplosion5PercentTest() {
        U1 u1 = new U1();

        Item item = new Item("test", 8);
        u1.carry(item);

        assertEquals(0.05, u1.getLaunchExplosionChance());
    }

    @Test
    void U1NoCargoLandingCrash0PercentTest() {
        U1 u1 = new U1();

        assertEquals(0.0, u1.getLandingCrashChance());
    }

    @Test
    void U1FullCargoLandingCrash1PercentTest() {
        U1 u1 = new U1();

        Item item = new Item("test", 8);
        u1.carry(item);

        assertEquals(0.01, u1.getLandingCrashChance());
    }
}