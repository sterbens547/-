public class Trianglee {

    public static double aree(double bas,double hieg) {
        if (bas <= 0 || hieg <= 0) {
            throw new
                    IllegalArgumentException("Число должно быть положительным");
        } return (bas * hieg) / 2;
    }
}
