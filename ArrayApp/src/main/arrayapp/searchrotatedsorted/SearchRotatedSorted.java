package arrayapp.searchrotatedsorted;

/**
 * LC: 33
 * LC: 153
 */
public class SearchRotatedSorted {

    /**
     * There is an integer array numbers sorted in ascending order (with distinct values).
     * Prior to being passed to your function, numbers is possibly rotated at an unknown pivot index k (1 <= k < numbers.length) such that the resulting
     * array is [numbers[k], numbers[k+1], ..., numbers[n-1], numbers[0], numbers[1], ..., numbers[k-1]] (0-indexed).
     * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
     * Given the array numbers after the possible rotation and an integer target, return the index of target if it is in numbers, or -1 if it is not in numbers.
     * You must write an algorithm with O(log n) runtime complexity.     *
     */
    public int search(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int pivot = (end + start) / 2;

            if (target == numbers[pivot])
                return pivot;

            if (numbers[start] <= numbers[pivot]) {
                if (target >= numbers[start] && target <= numbers[pivot])
                    end = pivot - 1;
                else
                    start = pivot + 1;
            } else {
                if (target >= numbers[pivot] && target <= numbers[end])
                    start = pivot + 1;
                else
                    end = pivot - 1;
            }
        }

        return -1;
    }

    /**
     * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
     * For example, the array numbers = [0,1,2,4,5,6,7] might become:
     * [4,5,6,7,0,1,2] if it was rotated 4 times.
     * [0,1,2,4,5,6,7] if it was rotated 7 times.
     * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
     * Given the sorted rotated array rotated of unique elements, return the minimum element of this array.
     * You must write an algorithm that runs in O(log n) time.
     */
    public int findMin(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        int min = numbers[start];

        while (start <= end) {
            if (numbers[start] < numbers[end])
                return Math.min(min, numbers[start]);

            int pivot = (end + start) / 2;
            min = Math.min(min, numbers[pivot]);

            if (numbers[pivot] >= numbers[start])
                start = pivot + 1;
            else
                end = pivot - 1;
        }

        return min;
    }
}
