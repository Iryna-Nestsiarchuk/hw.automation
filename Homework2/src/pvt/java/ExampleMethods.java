package pvt.java;

public class ExampleMethods {

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println("Min number is: " + Methods.minNumber(a, b));
        System.out.println("Cubed number is: " + Methods.cube(a));
        System.out.println("Squared number is: " + Methods.square(a));
        System.out.println(Methods.isEven(a) ? "Number is even." : "Number is odd.");
    }
}

