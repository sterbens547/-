import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FactorialTest {

    @Test
    void testCalculateFactorial() {
        assertEquals(120, Factorial.factorial(5), "Факториал 5 должен быть 120");
        assertEquals(1, Factorial.factorial(0), "Факториал 0 должен быть 1");
        assertThrows(IllegalArgumentException.class,
                () -> Factorial.factorial(-1),
                "Факториал отрицательного числа должен вызывать исключение"
        );
    }
}


