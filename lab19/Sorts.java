import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Sorts {

    // Ensures you get the same sequence of random numbers every single time.
    private static Random generator;
    private static final int RANDOM_SEED = 400;

    /* Returns the result of sorting the values in LIST using insertion sort. */
    public static void insertionSort(List<Integer> list) {
        // TODO: YOUR CODE HERE
    }

    /* Returns the result of sorting the values in LIST using selection sort. */
    public static void selectionSort(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int lowestIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(lowestIndex)) {
                    lowestIndex = j;
                }
            }
            list.add(i, list.remove(lowestIndex));
        }
    }

    /* Returns the result of sorting the values in this list using quicksort. */
    public static void quickSort(List<Integer> list) {
        generator = new Random(RANDOM_SEED);
        quickSort(null, -1, -1); // FIXME
    }

    private static void quickSort(List<Integer> list, int start, int end) {
        // Below are example of how to use the random number generator. You will
        // need to do this in your code somehow!
        generator.nextDouble();
        generator.nextInt(30);
        // TODO: YOUR CODE HERE
    }

    /* Returns the result of sorting the values in this list using merge
       sort. */
    public static void mergeSort(List<Integer> list) {
        // TODO: YOUR CODE HERE (You may use a helper function if you wish.)
    }
}
