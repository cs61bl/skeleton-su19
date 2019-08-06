import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class SortsTest {

    private static final int NUM_ITEMS_TO_SORT = 100;
    private static final int RANDOM_SEED = 500;

    private static List<Integer> generateRandomList(int N, boolean isLinkedList) {
        Random generator = new Random(RANDOM_SEED);

        List<Integer> result;
        if (isLinkedList) {
            result = new LinkedList<>();
        } else {
            result = new ArrayList<>();
        }
        for (int k = 0; k < N; k++) {
            result.add(generator.nextInt(100));
        }
        return result;
    }

    private static void verifySortedList(List<Integer> l) {
        int prev = Integer.MIN_VALUE;
        for (int i : l) {
            assertTrue(i >= prev);
            prev = i;
        }
    }

    @Test
    public void testInsertionSort() {
        List<Integer> values = generateRandomList(NUM_ITEMS_TO_SORT, false);
        Sorts.insertionSort(values);
        verifySortedList(values);
    }

    @Test
    public void testSelectionSort() {
        List<Integer> values = generateRandomList(NUM_ITEMS_TO_SORT, false);
        Sorts.selectionSort(values);
        verifySortedList(values);
    }

    @Test
    public void testQuickSort() {
        List<Integer> values = generateRandomList(NUM_ITEMS_TO_SORT, true);
        Sorts.quickSort(values);
        verifySortedList(values);
    }

    @Test
    public void testMergeSort() {
        List<Integer> values = generateRandomList(NUM_ITEMS_TO_SORT, true);
        Sorts.mergeSort(values);
        verifySortedList(values);
    }
}
