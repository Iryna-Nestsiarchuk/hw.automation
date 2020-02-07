package pvt.java;

public class Sort {
    public void quickSort(int[] array, int leftBorder, int rightBorder) {
        int pivot = array[leftBorder + (rightBorder - leftBorder) / 2];
        int i = leftBorder;
        int j = rightBorder;
        while (i <= j) {
            while (array[i] < pivot) {
                i = i + 1;
            }
            while (array[j] > pivot) {
                j = j - 1;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i = i + 1;
                j = j - 1;
            }
        }
        if (leftBorder < j)
            quickSort(array, leftBorder, j);
        if (rightBorder > i)
            quickSort(array, i, rightBorder);
    }

    public void shellSort(int[] array) {
        int h = 1;
        while (h * 3 < array.length) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            hSort(array, h);
            h = h / 3;
        }
    }

    private void hSort(int[] array, int h) {
        int length = array.length;
        for (int i = h; i < length; i++) {
            for (int j = i; j >= h; j = j - h) {
                if (array[j] < array[j - h]) {
                    int temp = array[j];
                    array[j] = array[j - h];
                    array[j - h] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
