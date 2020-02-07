package pvt.java;

import java.util.Arrays;

public class Task1_14 {
    public static void main(String[] args) {
        int[] array = Array.createArray();
        int size = array.length;
        Array.printInitialArray(array);
        double[] newArray = new double[size];
        newArray[0] = array[1] / 2.0;
        newArray[size - 1] = array[size - 2] / 2.0;
        for (int i = 1; i < size - 1; i++) {
            newArray[i] = (array[i - 1] + array[i + 1]) / 2.0;
        }
        System.out.println("An array of elements replaced by semi sum of surrounding elements: " + Arrays.toString(newArray));
    }
}
