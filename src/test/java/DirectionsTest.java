import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionsTest {

    @Test
    void toUnit() {
        assertEquals(-1, Directions.DOWN.toUnit(), "Wrong unit value 1");
        assertEquals(1, Directions.UP.toUnit(), "Wrong unit value 2");
        assertEquals(0, Directions.INPLACE.toUnit(), "Wrong unit value 3");
    }

    @Test
    void fromInt() {
        assertEquals(Directions.UP, Directions.fromInt(-13), "Wrong direction 1");
        assertEquals(Directions.DOWN, Directions.fromInt(7), "Wrong direction 2");
        assertEquals(Directions.INPLACE, Directions.fromInt(0), "Wrong direction 3");
    }
}