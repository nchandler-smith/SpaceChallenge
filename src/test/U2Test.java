package test;

import main.Item;
import main.U2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class U2Test {

    U2 u2;

    @BeforeEach
    void setup() {
        u2 = new U2();
    }

    @Test
    void U2CostEquals120MillionTest() {
        assertEquals(120, u2.getCost());
    }

    @Test
    void U2WeightsEquals0TonnesTest() {
        assertEquals(0, u2.getCargoWeight());
    }

    @Test
    void U2NoCargoLaunchExplosion0PercentTest() {
        assertEquals(0.0, u2.getLaunchExplosionChance());
    }

    @Test
    void U15TonnesCarg0LaunchExplosion2AndAHalfPercentTest() {
        Item item = new Item("test", 5);

        u2.carry(item);

        assertEquals(0.0182, u2.getLaunchExplosionChance(), 0.0002);
    }

    @Test
    void U2FullCargoLaunchExplosion4PercentTest() {
        Item item = new Item("test", 11);

        u2.carry(item);

        assertEquals(0.04, u2.getLaunchExplosionChance());
    }

    @Test
    void U2NoCargoLandingCrash0PercentTest() {
        assertEquals(0.0, u2.getLandingCrashChance());
    }

    @Test
    void U2FiveTonnesCargoLandingCrash8PercentTest() {
        Item item = new Item("test", 5);

        u2.carry(item);

        assertEquals(0.0364, u2.getLandingCrashChance(), 0.0001);
    }

    @Test
    void U2FullCargoLandingCrash8PercentTest() {
        Item item = new Item("test", 11);

        u2.carry(item);

        assertEquals(0.08, u2.getLandingCrashChance());
    }
}