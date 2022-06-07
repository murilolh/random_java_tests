package arrayapp.containsduplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * LC: 217
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int num : numbers) {
            if (set.contains(num))
                return true;
            set.add(num);
        }

        return false;
    }
}
