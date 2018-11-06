import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void ItemClassHasANameStringFieldTest(){
        Item item = new Item("", 0);

        assertEquals("", item.getName());
    }

    @Test
    void ItemClassHasAWieghtIntFieldTest(){
        Item item = new Item("", 0);

        assertEquals(0, item.getWeight());
    }
}