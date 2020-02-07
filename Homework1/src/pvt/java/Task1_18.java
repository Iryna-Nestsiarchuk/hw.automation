package pvt.java;

import java.util.Arrays;

public class Task1_18 {
    public static void main(String[] args) {
        int[] array = Array.createArray();
        Array.printInitialArray(array);
        Sort sort = new Sort();
        sort.shellSort(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));

    }
}
