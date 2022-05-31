package arrayapp.twosum;

import java.util.HashMap;

/**
 * TwoSum LC: 1
 * TwoSum Sorted LC: 167
 */
public class TwoSum {

    /**
     * Given an array of integers numbers and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (indexMap.containsKey(target - numbers[i]))
                return new int[]{indexMap.get(target - numbers[i]), i};

            indexMap.put(numbers[i], i);
        }

        return null;
    }

    /**
     * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
     * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
     * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * Your solution must use only constant extra space.
     */
    public int[] twoSumSorted(int[] numbers, int target) {
        int leftSumIndex = 0;
        int rightSumIndex = numbers.length - 1;
        while (numbers[leftSumIndex] + numbers[rightSumIndex] != target)
            if (numbers[leftSumIndex] + numbers[rightSumIndex] > target)
                rightSumIndex--;
            else
                leftSumIndex++;
        return new int[]{leftSumIndex + 1, rightSumIndex + 1};
    }

}
