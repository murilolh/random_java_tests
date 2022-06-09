package arrayapp.longestconsecutivesequence;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers numbers, return the length of the longest consecutive elements sequence.
 * LC: 128
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] numbers) {
        final Set<Integer> numbersSet = generateNumberSet(numbers);

        int longestSequence = 0;
        for (int number : numbersSet)
            if (isStartOfSequence(number, numbersSet))
                longestSequence = Math.max(longestSequence, getLongestSequenceForCurrentNumber(number, numbersSet));

        return longestSequence;
    }

    private Set<Integer> generateNumberSet(int[] numbers) {
        final Set<Integer> numbersSet = new HashSet<>();
        for (int num : numbers)
            numbersSet.add(num);
        return numbersSet;
    }

    private boolean isStartOfSequence(int number, Set<Integer> numbersSet) {
        return !numbersSet.contains(number - 1);
    }

    private int getLongestSequenceForCurrentNumber(int number, Set<Integer> numbersSet) {
        int currentNumber = number;
        int currentSequence = 1;

        while (numbersSet.contains(currentNumber + 1)) {
            currentNumber++;
            currentSequence++;
        }

        return currentSequence;
    }
}
