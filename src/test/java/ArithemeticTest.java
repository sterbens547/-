import static org.testng.Assert.*;

public class ArithemeticTest {

    @Test
    public void testAdd() {
        assertEquals(Arithemetic.in(2, 3), 5, "2 + 3 должно быть 5");
        assertThrows(() -> Arithemetic.in(Integer.MAX_VALUE, 1), "Переполнение при сложении должно вызывать исключение");
    }

    @Test
    public void testSubtract() {
        assertEquals(Arithemetic.minus(4, 3), 1, "4 - 3 должно быть 1");
        assertThrows(() -> Arithemetic.minus(Integer.MIN_VALUE, 1), "Переполнение при вычитании должно вызывать исключение");
    }

    @Test
    public void testMultiply() {
        assertEquals(Arithemetic.multiplication(2, 3), 6, "2 * 3 должно быть 6");
        assertThrows(() -> Arithemetic.multiplication(Integer.MAX_VALUE, 2), "Переполнение при умножении должно вызывать исключение");
    }

    @Test
    public void testDivide() {
        assertEquals(Arithemetic.division(6, 3), 2.0, "6 / 3 должно быть 2.0");
        assertThrows(() -> Arithemetic.division(1, 0), "Деление на ноль должно вызывать исключение");
    }
}