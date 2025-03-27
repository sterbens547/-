import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TraingleeTest {


    @Test
    void testCalculateArea() {
        assertEquals(10.0, Trianglee.aree(5, 4), "Площадь треугольника 5x4 должна быть 10");
        assertThrows(IllegalArgumentException.class,
                () -> Trianglee.aree(-1, 2),
                "Отрицательные значения должны вызывать исключение"
        );
    }
}
