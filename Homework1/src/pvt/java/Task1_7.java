package pvt.java;

public class Task1_7 {
    public static void main(String[] args) {
        int[] array = Array.createArray();
        Array.printInitialArray(array);
        boolean flag = false;
        int countZeros = 0;
        int i = 0;
        while (i < array.length) {
            if (array[i] == 0) {
                flag = true;
                countZeros = countZeros + 1;
            }
            i = i + 1;
        }
        System.out.println((!flag) ? "No zero elements." : "The number of zero elements: " + countZeros);
    }
}
