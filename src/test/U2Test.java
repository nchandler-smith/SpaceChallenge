package test;

import main.Item;
import main.U2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class U2Test {

    @Test
    void U2CostEquals120MillionTest() {
        U2 u2 = new U2();

        assertEquals(120, u2.getCost());
    }

    @Test
    void U2WeightsEquals18TonnesTest() {
        U2 u2 = new U2();

        assertEquals(18, u2.getCargoWeight());
    }

    @Test
    void U2NoCargoLaunchExplosion0PercentTest() {
        U2 u2 = new U2();

        assertEquals(0.0, u2.getLaunchExplosionChance());
    }

    @Test
    void U2FullCargoLaunchExplosion4PercentTest() {
        U2 u2 = new U2();

        Item item = new Item("test", 11);
        u2.carry(item);

        assertEquals(0.04, u2.getLaunchExplosionChance());
    }

    @Test
    void U2NoCargoLandingCrash0PercentTest() {
        U2 u2 = new U2();

        assertEquals(0.0, u2.getLandingCrashChance());
    }

    @Test
    void U2FullCargoLandingCrash8PercentTest() {
        U2 u2 = new U2();

        Item item = new Item("test", 11);
        u2.carry(item);

        assertEquals(0.08, u2.getLandingCrashChance());
    }
}