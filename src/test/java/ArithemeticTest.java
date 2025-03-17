import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;
 class ArithemeticTest {

    @Test
     void testAdd() {
        assertEquals(5, Arithemetic.in(2, 3));
    }

    @Test
     void testMinus () {
        assertEquals(1,Arithemetic.minus(5,6));
    }

    @Test
     void testMultiplication () {
        assertEquals(10,Arithemetic.multiplication(2,5));
    }

    @Test
     void testDivision () {
        assertEquals(4.0,Arithemetic.division(20,5));
        assertThrows(ArithmeticException.class, () -> Arithemetic.division(10,0));
    }



}
