import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;
 class ArithemeticTest {

     @Test
     void testAdd() {
         assertEquals(5, Arithemetic.in(2, 3), "2 + 3 должно быть 5");
         assertThrows(ArithmeticException.class,
                 () -> Arithemetic.in(Integer.MAX_VALUE, 1),
                 "Переполнение при сложении должно вызывать исключение"
         );
     }

     @Test
     void testSubtract() {
         assertEquals(1, Arithemetic.minus(4, 3), "4 - 3 должно быть 1");
         assertThrows(ArithmeticException.class,
                 () ->  Arithemetic.minus(Integer.MIN_VALUE, 1),
                 "Переполнение при вычитании должно вызывать исключение"
         );
     }

     @Test
     void testMultiply() {
         assertEquals(6, Arithemetic.multiplication(2, 3), "2 * 3 должно быть 6");
         assertThrows(ArithmeticException.class,
                 () -> Arithemetic.multiplication(Integer.MAX_VALUE, 2),
                 "Переполнение при умножении должно вызывать исключение"
         );
     }

     @Test
     void testDivide() {
         assertEquals(2.0, Arithemetic.division(6, 3), "6 / 3 должно быть 2.0");
         assertThrows(ArithmeticException.class,
                 () -> Arithemetic.division(1, 0),
                 "Деление на ноль должно вызывать исключение"
         );
     }

}
