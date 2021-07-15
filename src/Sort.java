/**
 * Provides sorting algorithms
 *
 * @author Bhavyai Gupta
 * @version 1.0.0
 */
public class Sort {
    /**
     * Sorts the <code>arr</code> inplace using Bubble Sort
     *
     * @param arr an integer array which is to be sorted in ascending order
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
