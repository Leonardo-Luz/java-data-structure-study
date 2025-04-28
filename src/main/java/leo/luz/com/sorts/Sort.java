package leo.luz.com.sorts;

/**
 * Sort
 */
public class Sort {
    private static void swap(int[]array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void Bubble(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1 + i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    private static int Partition(int[] array, int left, int right){
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (array[j] < array[right]) {
                i++;
                swap(array, i, j);
            }
        }

        i++;
        swap(array, i, right);
        return i;
    }

    public static void Quick(int[] array, int left, int right){
        if (left < right) {
            int pivot = Partition(array, left, right);

            Quick(array, left, pivot - 1);
            Quick(array, pivot + 1, right);
        }
    }
}
