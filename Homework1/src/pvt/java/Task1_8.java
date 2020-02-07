package pvt.java;

import java.util.ArrayList;

public class Task1_8 {
    public static void main(String[] args) {
        int[] array = Array.createArray();
        Array.printInitialArray(array);
        boolean flag = false;
        int countZeros = 0;
        ArrayList idxZeros = new ArrayList();
        int i = 0;
        while (i < array.length) {
            if (array[i] == 0) {
                flag = true;
                countZeros = countZeros + 1;
                idxZeros.add(i);
            }
            i = i + 1;
        }
        System.out.println((!flag) ? "No zero elements." : "The indexes of zero elements: " + idxZeros);
    }
}

