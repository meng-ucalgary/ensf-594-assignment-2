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

    /**
     * Sorts the <code>arr</code> inplace using Insertion Sort
     *
     * @param arr an integer array which is to be sorted in ascending order
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            // item is the element that needs to be put in sorted left half
            int item = arr[i];

            // j is the max index till where arrays are sorted
            int j = i - 1;

            // loop to make space for 'item' to be inserted at correct position
            while (j >= 0 && arr[j] > item) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = item;
        }
    }

    /**
     * Merges two sorted subarrays of an array <code>arr</code> to form bigger
     * sorted subarray. First subarray extends from [low, mid] and second subarray
     * extends from (mid, high]
     *
     * @param arr  The array whose two different subarrays are to be combined to
     *             form a single sorted subarray
     * @param low  starting index of left subarray
     * @param mid  ending index of left subarray
     * @param high ending index of right subarray
     */
    private static void merge(int arr[], int low, int mid, int high) {
        // create auxiliary arrays to store two halves
        int[] leftHalf = new int[mid - low + 1];
        int[] rightHalf = new int[high - mid];

        // copy lower half into auxiliary space
        for (int i = 0; i < leftHalf.length; i++) {
            leftHalf[i] = arr[i + low];
        }

        // copy right half into auxiliary space
        for (int i = 0; i < rightHalf.length; i++) {
            rightHalf[i] = arr[i + mid + 1];
        }

        // merge auxiliary arrays into main arrays
        int i = 0, j = 0, k = low;
        while (i < leftHalf.length && j < rightHalf.length) {
            // put element from left half if its smaller or equal
            if (leftHalf[i] <= rightHalf[j]) {
                arr[k++] = leftHalf[i++];
            }

            // else put element from right half
            else {
                arr[k++] = rightHalf[j++];
            }
        }

        // copy remaining elements from left half
        while (i < leftHalf.length) {
            arr[k++] = leftHalf[i++];
        }

        // copy remaining elements from right half
        while (j < rightHalf.length) {
            arr[k++] = rightHalf[j++];
        }
    }

    /**
     * Sorts the subarray <code>arr</code> inplace using Merge Sort
     *
     * @param arr  an integer subarray [low, high] which is to be sorted in
     *             ascending order
     * @param low  starting index of subarray
     * @param high ending index of subarray
     */
    private static void mergeSort(int arr[], int low, int high) {
        // array should have more than one element
        if (low < high) {
            // find the midpoint of array
            int mid = low + (high - low) / 2;

            // recursively sort the left half
            Sort.mergeSort(arr, low, mid);

            // recursively sort the right half
            Sort.mergeSort(arr, mid + 1, high);

            // merge the sorted halves
            Sort.merge(arr, low, mid, high);
        }
    }

    /**
     * Sorts the <code>arr</code> inplace using Merge Sort
     *
     * @param arr an integer array which is to be sorted in ascending order
     */
    public static void mergeSort(int arr[]) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Method to find the partition position
     *
     * Source: https://www.programiz.com/dsa/quick-sort
     * Date Accessed: 17-07-2021
     *
     * @param arr  an integer subarray where the position of partition is to be
     *             found
     * @param low  starting index of subarray
     * @param high starting index of subarrays
     * @return the position of the partition
     */
    private static int partition(int arr[], int low, int high) {
        // choose the rightmost element as pivot
        int pivot = arr[high];

        // pointer for greater element
        int i = (low - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                // swapping element at i with element at j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

        // swap the pivot element with the greater element specified by i
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // return the position from where partition is done
        return (i + 1);
    }

    /**
     * Sorts the subarray <code>arr</code> inplace using Quick Sort
     *
     * Source: https://www.programiz.com/dsa/quick-sort
     * Date Accessed: 17-07-2021
     *
     * @param arr  an integer subarray [low, high] which is to be sorted in
     *             ascending order
     * @param low  starting index of subarray
     * @param high ending index of subarray
     */
    private static void quickSort(int arr[], int low, int high) {
        if (low < high) {

            // find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pi = partition(arr, low, high);

            // recursive call on the left of pivot
            quickSort(arr, low, pi - 1);

            // recursive call on the right of pivot
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Sorts the <code>arr</code> inplace using Quick Sort
     *
     * @param arr an integer array which is to be sorted in ascending order
     */
    public static void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }
}
