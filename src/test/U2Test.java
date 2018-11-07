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

}