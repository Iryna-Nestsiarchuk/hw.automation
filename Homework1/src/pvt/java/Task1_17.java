package pvt.java;

import java.util.Arrays;

public class Task1_17 {
    public static void main(String[] args) {
        int[] array1 = Array.createArray();
        int leftBorder = 0;
        int rightBorder = array1.length - 1;
        Array.printInitialArray(array1);
        Sort sort = new Sort();
        sort.quickSort(array1, leftBorder, rightBorder);
        System.out.println("Sorted Array (Quick method): " + Arrays.toString(array1));
        int[] array2 = Array.createArray();
        Array.printInitialArray(array2);
        sort.shellSort(array2);
        System.out.println("Sorted Array (Shell method): " + Arrays.toString(array2));
    }
}
