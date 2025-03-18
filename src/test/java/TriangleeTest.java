import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleeTest {

    @Test
    public void testAree() {

        assertEquals(Trianglee.aree(5, 4), 10.0);
        assertThrows(() -> Trianglee.aree(-1, 2));
    }


    }
