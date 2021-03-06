import java.util.Random;
import java.util.Arrays;

/**
 * Generates an array
 *
 * @author Bhavyai Gupta
 */
public class Generator {
    /**
     * Creates an unsorted array of size <code>size</code> with random numbers
     *
     * @param size the size of the array
     * @return the generated array
     */
    public static int[] getRandomArray(int size) {
        int arr[] = new int[size];

        // using seed = size to get same random numbers for the same size of array
        Random r = new Random(size);
        Random digits = new Random(size);

        // fill the array with random numbers
        for (int i = 0; i < size; i++) {
            int multiplier = (int) Math.pow(10, (digits.nextInt(5) + 2));
            arr[i] = (int) (r.nextDouble() * multiplier);
        }

        return arr;
    }

    /**
     * Creates a sorted array of size <code>size</code> filled with random numbers
     * in ascending order
     *
     * @param size the size of the array
     * @return the generated array
     */
    public static int[] getSortedArray(int size) {
        int arr[] = Generator.getRandomArray(size);

        Arrays.sort(arr);

        return arr;
    }

    /**
     * Creates a sorted array of size <code>size</code> filled with random numbers
     * in descending order
     *
     * @param size the size of the array
     * @return the generated array
     */
    public static int[] getReverseSortedArray(int size) {
        int arr[] = Generator.getSortedArray(size);

        int arrReverse[] = new int[size];

        for (int i = 0; i < size; i++) {
            arrReverse[i] = arr[size - i - 1];
        }

        return arrReverse;
    }
}
