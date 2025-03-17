import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TraingleeTest {


    @Test
    void testCalculateArea() {
        assertEquals(10.0, Trianglee.aree(5, 4));
        assertThrows(IllegalArgumentException.class, () -> Trianglee.aree(-1, 2));
    }
}
