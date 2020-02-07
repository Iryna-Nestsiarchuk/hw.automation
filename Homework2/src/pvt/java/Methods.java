package pvt.java;

public class Methods {
    public static int minNumber(int number1, int number2) {
        return Math.min(number1, number2);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int square(int number) {
        int power = 2;
        return (int) Math.pow(number, power);
    }

    public static int cube(int number) {
        int power = 3;
        return (int) Math.pow(number, power);
    }
}
