import static org.testng.Assert.*;

public class ComparisonTest {

    @Test
    public void testCompare() {
        assertEquals(Comparison.comp(5, 3), "5 больше 3", "5 должно быть больше 3");
        assertEquals(Comparison.comp(3, 5), "3 меньше 5", "3 должно быть меньше 5");
        assertEquals(Comparison.comp(5, 5), "5 равно 5", "5 должно быть равно 5");
    }

}
