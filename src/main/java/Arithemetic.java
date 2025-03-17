public class Arithemetic {
    public static int in(int a,int b) {
        return a + b;
    }

    public static int minus (int a,int b) {
        return a - b;
    }

    public static int multiplication (int a,int b) {
        return a * b;
    }

    public static double division (int a,int b) {
        if (b == 0) {
            throw new
                    ArithmeticException("На ноль делить нельзя");
        } return (double) a / b;
    }
}
