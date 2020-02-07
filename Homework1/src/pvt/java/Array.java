package pvt.java;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    private static int enterArraySize() {
        System.out.println("Please, enter the array size: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        return size;
    }

    public static int[] createArray() {
        int size = enterArraySize();
        int[] array = new int[size];
        int multiplier = 10;
        for (int i = 0; i < size; i++) {
            array[i] = (int) Math.round(Math.random() * multiplier);
        }
        return array;
    }

    public static void printInitialArray(int[] array) {
        System.out.println("Initial array: " + Arrays.toString(array));
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
