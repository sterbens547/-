import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleeTest {

    @Test
    public void testCalculateArea() {
        Assert.assertEquals(Trianglee.aree(5, 4), 10.0, "Площадь треугольника 5x4 должна быть 10");
        assertThrows (() -> Trianglee.aree(1, -2), "Отрицательные значения должны вызывать исключение");
    }

    }
