package pvt.java;

import java.util.Arrays;

public class Task1_9 {
    public static void main(String[] args) {
        int[] array = Array.createArray();
        Array.printInitialArray(array);
        if (array.length % 2 == 0) {
            for (int i = 0; i < array.length; i = i + 2) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        } else {
            for (int i = 0; i < array.length - 1; i = i + 2) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        System.out.println("An array where the neighbors were swapped: " );
        Array.printArray(array);
    }
}
