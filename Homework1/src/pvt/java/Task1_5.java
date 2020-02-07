package pvt.java;

public class Task1_5 {
    public static void main(String[] args) {
        int[] array = Array.createArray();
        Array.printInitialArray(array);
        int product = 1;
        for (int i = 0; i < array.length; i++) {
            product = product * array[i];
        }
        System.out.println("Production of array elements: " + product);
    }
}
