import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComparsionTest {

    @Test
    void testCompre()  {
        Assertions.assertEquals("5 больше 3", Comparison.comp(5, 3));
        Assertions.assertEquals("3 меньше 5", Comparison.comp(3, 5));
        Assertions.assertEquals("5 равно 5", Comparison.comp(5, 5));
    }
}
