package pvt.java;

import java.util.Arrays;

public class Task1_10 {
    public static void main(String[] args) {
        int[] array = Array.createArray();
        Array.printInitialArray(array);
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println("Array which elements were swapped: " + Arrays.toString(array));
    }
}
