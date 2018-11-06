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
}