import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class FactorialTest {
    @org.testng.annotations.Test
    public static void testFactorial() {
        assertEquals(Factorial.factorial(5), 120);
        assertEquals(Factorial.factorial(0), 1);
        assertThrows(() -> Factorial.factorial(-1));
    }
}

