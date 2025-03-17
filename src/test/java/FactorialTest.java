import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class FactorialTest {

    @Test
    void testCalculateFactorial() {
        assertEquals(120, Factorial.factorial(5));
        assertEquals(1, Factorial.factorial(0));
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
    }
}

