package arrayapp.threesum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array numbers, return all the triplets [numbers[i], numbers[j], numbers[k]] such that i != j, i != k, and j != k,
 * and numbers[i] + numbers[j] + numbers[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * LC: 15
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);

        final List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < numbers.length && numbers[i] <= 0; i++)
            if (i == 0 || numbers[i - 1] != numbers[i])
                twoSum(i, numbers, result);

        return result;
    }

    private void twoSum(int leftIndex, int[] numbers, List<List<Integer>> result) {
        int centerIndex = leftIndex + 1;
        int rightIndex = numbers.length - 1;
        while (centerIndex < rightIndex) {
            int sum = numbers[leftIndex] + numbers[centerIndex] + numbers[rightIndex];
            if (sum < 0)
                centerIndex++;
            else if (sum > 0)
                rightIndex--;
            else {
                result.add(List.of(numbers[leftIndex], numbers[centerIndex++], numbers[rightIndex--]));
                while (centerIndex < rightIndex && numbers[centerIndex] == numbers[centerIndex - 1])
                    centerIndex++;
            }
        }
    }
}
