package pvt.java;

import java.util.Arrays;

public class Task1_6 {
    public static void main(String[] args) {
        int[] array = Array.createArray();
        Array.printInitialArray(array);
        int[] multipliedArray1 = array.clone();
        int[] multipliedArray2 = array.clone();
        int step = 3;
        int multiplier = 2;
        //Option1
        System.out.println("The result of multiplying each 3rd element by 2 (option 1): ");
        for (int i = step - 1; i < array.length; i = i + step) {
            multipliedArray1[i] = multipliedArray1[i] * multiplier;
        }
        Array.printArray(multipliedArray1);
        //Option 2:
        System.out.println("The result of multiplying each 3rd element by 2 (option 2): ");
        for (int i = 0; i < array.length; i++) {
            if ((i + 1) % step == 0) {
                multipliedArray2[i] = multipliedArray2[i] * multiplier;
            }
        }
        Array.printArray(multipliedArray2);
    }
}
