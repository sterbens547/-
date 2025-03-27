import static org.testng.Assert.*;

public class ArithemeticTest {

    @org.testng.annotations.Test
    void testIn() {
        assertEquals(Arithemetic.in(2, 3), 5);
    }

    @org.testng.annotations.Test
    void testMinus() {
        assertEquals(Arithemetic.minus(4, 3), 1);
    }

    @org.testng.annotations.Test
    void testMultiplication() {
        assertEquals(Arithemetic.multiplication(2, 3), 6);
    }

    @org.testng.annotations.Test
    void testDivision() {
        assertEquals(Arithemetic.division(6, 3), 2.0);
        assertThrows(() -> Arithemetic.division(1, 0));
    }
}