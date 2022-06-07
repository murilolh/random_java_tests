package arrayapp.topfrequentelements;

import java.util.*;

/**
 * Given an integer array numbers and an integer k, return the k most frequent elements. You may return the answer in any order.
 * LC: 347
 */
public class TopFrequentElements {
    public static int[] topKFrequent(int[] numbers, int k) {
        if (k == numbers.length) {
            return numbers;
        }

        final Map<Integer, Integer> numFrequencyMap = generateFrequencyMap(numbers);

        final Queue<Integer> heap = generateMinHeap(k, numFrequencyMap);

        return heapToArray(k, heap);
    }

    private static Map<Integer, Integer> generateFrequencyMap(int[] numbers) {
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int n : numbers)
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);
        return numFrequencyMap;
    }

    private static Queue<Integer> generateMinHeap(int k, Map<Integer, Integer> numFrequencyMap) {
        final Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(numFrequencyMap::get));
        for (Integer number : numFrequencyMap.keySet()) {
            heap.add(number);
            if (heap.size() > k)
                heap.poll();
        }
        return heap;
    }

    private static int[] heapToArray(int k, Queue<Integer> heap) {
        int[] topNumbers = new int[k];
        for (int i = k - 1; i >= 0 && !heap.isEmpty(); --i)
            topNumbers[i] = heap.poll();
        return topNumbers;
    }
}
