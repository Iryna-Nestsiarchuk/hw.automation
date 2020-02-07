package pvt.java;

import java.util.Arrays;

public class Task1_15 {
    public static void main(String[] args) {
        int[] array = Array.createArray();
        int size = array.length;
        Array.printInitialArray(array);
        int[] newArray = new int[size];
        int shift = 2;
        for (int i = 0; i < size; i++) {
            if (i + shift < size) {
                newArray[i + shift] = array[i];
            } else {
                newArray[i + shift - size] = array[i];
            }
        }
        System.out.println("Cyclically shifted array: " + Arrays.toString(newArray));
    }
}
