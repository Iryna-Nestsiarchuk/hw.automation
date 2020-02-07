package pvt.java;

public class Task1_13 {
    public static void main(String[] args) {
        int[] array = Array.createArray();
        Array.printInitialArray(array);
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1]) {
                flag = true;
                break;
            }
        }
        System.out.println((flag == true) ? "The array is not an ascending sequence." : "The array is an ascending sequence.");
    }
}
