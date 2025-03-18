import static org.testng.Assert.*;

public class ComparisonTest {

    @org.testng.annotations.Test
    public void testComp() {

        assertEquals(Trianglee.aree(5, 3), "5 больше 3");
        assertEquals(Trianglee.aree(3, 5), "3 меньше 5");
        assertEquals(Trianglee.aree(5, 5), "5 равно 5");
    }

}
