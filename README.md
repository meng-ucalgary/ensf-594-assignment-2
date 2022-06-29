# ENSF-594 Assignment 2

Assignment on comparison of sorting algorithms by doing an empirical analysis of a few sorting algorithms.

## How to build and run

1. Clone the repository to your local machine.

2. Run the script [`launch.sh`](launch.sh) or [`launch.cmd`](launch.cmd) to launch the program.

3. Then follow the onscreen instructions

## How it works

1. User launches the program

2. The program asks for the ordering of input array. Acceptable values are listed below.

   - ascending
   - descending
   - random

3. Then the program asks for the size of the input array. Empty arrays and negative sizes are not allowed. For demonstration in this project, following sizes are used

   - 10
   - 100
   - 1000
   - 10,000
   - 100,000
   - 1,000,000

4. Once ordering of input array and size are available, the program will generate the input array. For reference, this array would be stored in the directory [outputs/](outputs/), and the exact file name will be displayed. For integrity reasons, an exactly same array is generated for a given ordering and size on a given system.

5. Then the program asks for the algorithm to sort the generated array. Accepted values are

   - bubble - for sorting with Bubble Sort
   - insertion - for sorting with Insertion Sort
   - merge - for sorting with Merge Sort
   - quick - for sorting with Quick Sort

6. After the sorting completes, the program spits out the time (in milliseconds) it took to sort the input array. This time is captured manually in the file [Tables_and_Graphs.xlsx](Tables_and_Graphs.xlsx) in an appropriate table.

7. Finally the programs asks to save the sorted array in a file. The file would always be saved with `.txt` extension, and cannot contain special characters. The exact file name of the output file is displayed after it has been saved.

## Execution Screenshots

Refer the [Screenshots](Screenshots/) folder.

The file names follow the pattern - "\<order name\>\_\<input array size\>\_algorithm.png"

For example, execution screenshot of merge sort on an input of unsorted array of size 1000 can be referred in the file [rand_1000_merge.png](Screenshots/rand_1000_merge.png)
