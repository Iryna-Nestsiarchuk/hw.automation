package pvt.java;

public class Task1_12 {
    public static void main(String[] args) {
        int[] array = Array.createArray();
        Array.printInitialArray(array);
        int maxIdx = 0;
        int minIdx = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[maxIdx] < array[i]) {
                maxIdx = i;
            }
            if (array[minIdx] > array[i]) {
                minIdx = i;
            }
        }
        System.out.println("Max array element index: " + maxIdx);
        System.out.println("Min array element index: " + minIdx);
    }
}
