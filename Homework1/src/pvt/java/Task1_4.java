package pvt.java;

public class Task1_4 {
    public static void main(String[] args) {
        int[] array = Array.createArray();
        System.out.println("Output all the elements of array in direct order:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("Output all the elements of array in reverse order:");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
