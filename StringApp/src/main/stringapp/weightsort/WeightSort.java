package stringapp.weightsort;


import org.jetbrains.annotations.VisibleForTesting;
import stringapp.utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <pre>
 * You are provided a string containing a list of positive integers separated by a space (" ").
 * Take each value and calculate the sum of its digits, which we call it's "weight".
 * Then return the list in ascending order by weight, as a string joined by a space.
 *
 * For example 99 will have "weight" 18, 100 will have "weight" 1 so in the output 100 will come before 99.
 *
 * Example:
 *
 * "56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes:
 * "100 180 90 56 65 74 68 86 99"
 *
 * When two numbers have the same "weight", let's consider them to be strings and not numbers:
 *
 * 100 is before 180 because its "weight" (1) is less than the one of 180 (9)
 * and 180 is before 90 since, having the same "weight" (9) it comes before as a string.
 *
 * All numbers in the list are positive integers and the list can be empty.
 * </>
 */
public class WeightSort {

    public static String orderWeight(String string) {
        return stringContainsMultipleIntegers(string) ? orderWeightString(string) : string;
    }

    private static String orderWeightString(String string) {
        final String[] splitString = string.split(" ");

        final Map<Integer, List<String>> weightHashMap = getSortedWeightMap(splitString);
        return getSortedWeightString(weightHashMap);
    }

    @VisibleForTesting
    protected static Map<Integer, List<String>> getSortedWeightMap(String[] splitString) {
        final Map<Integer, List<String>> sortedWeightMap = new TreeMap<>();

        for (String intString: splitString)
            populateSortedWeightMap(sortedWeightMap, intString);

        return sortedWeightMap;
    }

    private static void populateSortedWeightMap(Map<Integer, List<String>> sortedWeightHashMap, String intString) {
        final Integer stringWeight = sumStringDigits(intString);
        final List<String> updatedStringList = updateStringList(sortedWeightHashMap, intString, stringWeight);

        sortedWeightHashMap.put(stringWeight, updatedStringList);
    }

    @VisibleForTesting
    protected static Integer sumStringDigits(String intString) {
        int sum = 0;
        for (int i = 0; i < intString.length(); i++)
            sum += Integer.parseInt("" + intString.charAt(i));
        return sum;
    }

    private static List<String> updateStringList(Map<Integer, List<String>> sortedWeightHashMap, String intString, Integer stringWeight) {
        final List<String> stringList = sortedWeightHashMap.getOrDefault(stringWeight, new LinkedList<>());
        stringList.add(intString);

        Collections.sort(stringList);
        return stringList;
    }

    @VisibleForTesting
    protected static String getSortedWeightString(Map<Integer, List<String>> weightHashMap) {
        return weightHashMap.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.joining(" "));
    }

    private static boolean stringContainsMultipleIntegers(String string) {
        return !StringUtils.stringIsNullOrEmpty(string) && string.contains(" ");
    }
}
