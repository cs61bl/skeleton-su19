import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;


public class DistributionSortsTest {

    private static final Random RANDOM = new Random(61);

    /* Returns a random integer between 0 and 9. */
    private static int randomDigit() {
        return RANDOM.nextInt(10);
    }

    /* Returns a random integer between 0 and 9999. */
    private static int randomInt() {
        return RANDOM.nextInt(10000);
    }

    /* Returns an array with N random integers between 0 and 9999. */
    private static int[] generateRandomIntegerArray(int N) {
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomInt();
        }
        return arr;
    }

    /* Returns an array with N random integers between 0 and 9. */
    private static int[] generateRandomDigitArray(int N) {
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomDigit();
        }
        return arr;
    }

    /* Returns true if ARR is sorted. */
    private static void verifySortedArray(int[] arr) {
        int prev = Integer.MIN_VALUE;
        for (int i : arr) {
            assertTrue("Array is not in sorted order!", i >= prev);
            prev = i;
        }
    }

    private static void runCountingSort(int N) {
        int[] arr = generateRandomDigitArray(N);
        System.out.println("Original array: " + Arrays.toString(arr));
        DistributionSorts.countingSort(arr);
        System.out.println("Output array: " + Arrays.toString(arr));
        verifySortedArray(arr);
    }

    private static void runLSDRadixSort(int N) {
        int[] arr = generateRandomIntegerArray(N);
        System.out.println("Original array: " + Arrays.toString(arr));
        DistributionSorts.lsdRadixSort(arr);
        System.out.println("Output array: " + Arrays.toString(arr));
        verifySortedArray(arr);
    }

    @Test
    public void testCountingSort() {
        runCountingSort(10);
        runCountingSort(50);
        runCountingSort(100);
    }

    @Test
    public void testLSDRadixSort() {
        runLSDRadixSort(10);
        runLSDRadixSort(50);
        runLSDRadixSort(100);
    }
}
