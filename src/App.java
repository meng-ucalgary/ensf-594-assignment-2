import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import org.fusesource.jansi.AnsiConsole;

/**
 * Provides interface to the project "Comparison of Sorting Algorithms"
 *
 * @author Bhavyai Gupta
 */
public class App {
    private BufferedReader br;
    private String order;
    private int size;
    private String algorithm;
    private String outputFile;
    private File outputPath;

    /**
     * Constructs App object with default initializations
     */
    private App() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.outputPath = new File("outputs");
        AnsiConsole.systemInstall();

        // create directory for storing files if it doesn't exist
        if (!this.outputPath.isDirectory()) {
            if (!this.outputPath.mkdirs()) {
                System.err.printf("%n[%s] Unable to create directory \'%s\'. Please check.%n",
                        ColorText.text("FAIL", Color.RED), outputPath.getAbsolutePath());
            }
        }
    }

    /**
     * Provides CLI and interacts with all other classes and methods
     */
    private void main() {
        // while block to get "order" from user
        // --------------------------------------------------------------------------------
        while (true) {
            System.out.printf("%n[%s] Please enter the order of array (ascending/descending/random): ",
                    ColorText.text("QUES", Color.YELLOW));

            try {
                String temp = this.br.readLine();

                if (temp.trim().equalsIgnoreCase("ascending")) {
                    this.order = "ascending";
                    break;
                }

                else if (temp.trim().equalsIgnoreCase("descending")) {
                    this.order = "descending";
                    break;
                }

                else if (temp.trim().equalsIgnoreCase("random")) {
                    this.order = "random";
                    break;
                }

                else {
                    throw new InvalidInputException(
                            String.format("[%s] Please enter a valid order", ColorText.text("FAIL", Color.RED)));
                }
            }

            catch (InvalidInputException e) {
                System.err.printf("%s", e.getMessage());
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }
        // --------------------------------------------------------------------------------

        // while block to get "size" from user
        // --------------------------------------------------------------------------------
        while (true) {
            System.out.printf("[%s] Please enter the size of array (eg 10/100/1000/10000/100000/1000000): ",
                    ColorText.text("QUES", Color.YELLOW));

            try {
                this.size = Integer.parseInt(this.br.readLine());

                if (this.size < 1) {
                    throw new InvalidInputException(
                            String.format("[%s] Please enter a valid size", ColorText.text("FAIL", Color.RED)));
                }

                else {
                    break;
                }
            }

            catch (NumberFormatException e) {
                System.err.printf("[%s] Please enter a numerical values%n", ColorText.text("FAIL", Color.RED));
            }

            catch (InvalidInputException e) {
                System.err.printf("%s%n", e.getMessage());
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }
        // --------------------------------------------------------------------------------

        // the input array
        int[] inputArr;

        // now generate the array with random numbers in "order" order
        // --------------------------------------------------------------------------------
        switch (this.order) {
            // ascending order
            case "ascending": {
                inputArr = Generator.getSortedArray(this.size);
                System.out.printf("%n[%s] Array of size %d in %s order created successfully%n",
                        ColorText.text("INFO", Color.BLUE), this.size, this.order);
            }
                break;

            // descending order
            case "descending": {
                inputArr = Generator.getReverseSortedArray(this.size);
                System.out.printf("%n[%s] Array of size %d in %s order created successfully%n",
                        ColorText.text("INFO", Color.BLUE), this.size, this.order);
            }
                break;

            // random order
            default: {
                inputArr = Generator.getRandomArray(this.size);
                System.out.printf("%n[%s] Array of size %d in %s order created successfully%n",
                        ColorText.text("INFO", Color.BLUE), this.size, this.order);
            }
        }
        // --------------------------------------------------------------------------------

        // store the input array, just for a possible future reference
        // --------------------------------------------------------------------------------
        String inputFileName = "input" + "_" + this.order + "_" + String.valueOf(this.size) + ".txt";
        File inputFile = new File(this.outputPath.getAbsolutePath() + File.separator + inputFileName);

        if (Writer.toFile(inputArr, inputFile.getAbsolutePath())) {
            System.out.printf("[%s] Input array stored at \'%s\'%n", ColorText.text("INFO", Color.BLUE),
                    ColorText.text(inputFile.getAbsolutePath(), Color.MAGENTA));
        }

        else {
            System.err.printf("[%s] Something went wrong while saving input array \'%s\'. Please check%n",
                    ColorText.text("FAIL", Color.RED), inputFile.getAbsolutePath());
        }
        // --------------------------------------------------------------------------------

        while (true) {
            System.out.printf("%n[%s] Please enter the algorithm to sort the array (bubble/insertion/merge/quick): ",
                    ColorText.text("QUES", Color.YELLOW));

            try {
                String temp = this.br.readLine();

                if (temp.trim().equalsIgnoreCase("bubble")) {
                    this.algorithm = "bubble";

                    // capture start time
                    long startTime = System.nanoTime();

                    // sort using bubble sort
                    Sort.bubbleSort(inputArr);

                    // capture stop time
                    long stopTime = System.nanoTime();

                    double elapsedTime = (double) (stopTime - startTime) / 1_000_000;

                    // report the time taken
                    System.out.printf("[%s] Time taken for %s sort = %s milliseconds%n",
                            ColorText.text("INFO", Color.BLUE), this.algorithm,
                            ColorText.text(String.format("%.5f", elapsedTime), Color.GREEN));

                    break;
                }

                else if (temp.trim().equalsIgnoreCase("insertion")) {
                    this.algorithm = "insertion";

                    // capture start time
                    long startTime = System.nanoTime();

                    // sort using insertion sort
                    Sort.insertionSort(inputArr);

                    // capture stop time
                    long stopTime = System.nanoTime();

                    double elapsedTime = (double) (stopTime - startTime) / 1_000_000;

                    // report the time taken
                    System.out.printf("[%s] Time taken for %s sort = %s milliseconds%n",
                            ColorText.text("INFO", Color.BLUE), this.algorithm,
                            ColorText.text(String.format("%.5f", elapsedTime), Color.GREEN));

                    break;
                }

                else if (temp.trim().equalsIgnoreCase("merge")) {
                    this.algorithm = "merge";

                    // capture start time
                    long startTime = System.nanoTime();

                    // sort using merge sort
                    Sort.mergeSort(inputArr);

                    // capture stop time
                    long stopTime = System.nanoTime();

                    double elapsedTime = (double) (stopTime - startTime) / 1_000_000;

                    // report the time taken
                    System.out.printf("[%s] Time taken for %s sort = %s milliseconds%n",
                            ColorText.text("INFO", Color.BLUE), this.algorithm,
                            ColorText.text(String.format("%.5f", elapsedTime), Color.GREEN));

                    break;
                }

                else if (temp.trim().equalsIgnoreCase("quick")) {
                    this.algorithm = "quick";

                    try {
                        // capture start time
                        long startTime = System.nanoTime();

                        // sort using quick sort
                        Sort.quickSort(inputArr);

                        // capture stop time
                        long stopTime = System.nanoTime();

                        double elapsedTime = (double) (stopTime - startTime) / 1_000_000;

                        // report the time taken
                        System.out.printf("[%s] Time taken for %s sort = %s milliseconds%n",
                                ColorText.text("INFO", Color.BLUE), this.algorithm,
                                ColorText.text(String.format("%.5f", elapsedTime), Color.GREEN));
                    }

                    catch (StackOverflowError e) {
                        System.err.printf("[%s] Stack Overflow. Could not measure time%n",
                                ColorText.text("FAIL", Color.RED));
                        Runtime.getRuntime().exit(1);
                    }

                    break;
                }

                else {
                    throw new InvalidInputException(
                            String.format("[%s] Please enter a valid algorithm", ColorText.text("FAIL", Color.RED)));
                }
            }

            catch (InvalidInputException e) {
                System.err.printf("%s", e.getMessage());
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }
        // --------------------------------------------------------------------------------

        // while block to get "outputFile" from user
        // --------------------------------------------------------------------------------
        while (true) {
            System.out.printf("[%s] Please enter the filename to store sorted array (eg \"%s_sort.txt\"): ",
                    ColorText.text("INFO", Color.BLUE), this.algorithm);

            try {
                String temp = this.br.readLine();

                if (temp.equals("") || temp == null) {
                    throw new InvalidInputException(
                            String.format("[%s] Please enter a filename", ColorText.text("FAIL", Color.RED)));
                }

                else {
                    // take only acceptable characters for the filename
                    temp = temp.replaceAll("[^a-zA-Z0-9_. ]*", "");

                    // making sure file is saved with proper extension
                    if (!temp.endsWith(".txt")) {
                        this.outputFile = temp + ".txt";
                    }

                    else {
                        this.outputFile = temp;
                    }

                    // to-be filename: outputPath/outputFile
                    File f = new File(this.outputPath.getAbsolutePath() + File.separator + this.outputFile);

                    // if-else block to ensure not to overwrite existing files
                    if (f.exists()) {
                        throw new InvalidInputException(
                                String.format("[%s] \'%s\' already exists. Please choose a different name",
                                        ColorText.text("FAIL", Color.RED), f.getAbsolutePath()));
                    }

                    else {
                        if (Writer.toFile(inputArr, f.getAbsolutePath())) {
                            System.out.printf("[%s] File \'%s\' successfully saved%n",
                                    ColorText.text("INFO", Color.BLUE),
                                    ColorText.text(f.getAbsolutePath(), Color.MAGENTA));
                        }

                        else {
                            System.err.printf("[%s] Something went wrong while saving file \'%s\'. Please check%n",
                                    ColorText.text("FAIL", Color.RED), f.getAbsolutePath());
                        }

                        break;
                    }

                }
            }

            catch (InvalidInputException e) {
                System.err.printf("%s%n", e.getMessage());
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }
        // --------------------------------------------------------------------------------
    }

    /**
     * Entry point of the project
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        App app = new App();
        app.main();

        System.out.printf("%nBye!%n");
    }
}
