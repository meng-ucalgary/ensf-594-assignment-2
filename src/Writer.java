import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Writes an array to a file on the disk
 *
 * @author Bhavyai Gupta
 */
public class Writer {
    /**
     * Write the array <code>arr</code> to file <code>filename</code>
     *
     * @param arr      the array to be written in a file
     * @param filename the filename in which array is to be written
     */
    public static boolean toFile(int[] arr, String filename) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)), true);

            for (int i = 0; i < arr.length; i++) {
                pw.println(arr[i]);
            }

            pw.close();

            return true;
        }

        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
