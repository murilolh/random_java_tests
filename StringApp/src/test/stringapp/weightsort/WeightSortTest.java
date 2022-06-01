package stringapp.weightsort;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightSortTest {

    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals("2000 103 123 4444 99", WeightSort.orderWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
        assertEquals("000000 123 2345 12384 162371 236723 08934 3267321 99999999999",
                WeightSort.orderWeight("123 2345 12384 08934 3267321 236723 000000 162371 99999999999"));
        assertEquals("1000 7776 845451 8991 9981 999 7777",
                WeightSort.orderWeight("1000 999 8991 845451 7776 7777 9981"));
    }

    @Test
    public void emptyStringShouldReturnEmpty() {
        assertEquals("", WeightSort.orderWeight(""));
    }

    @Test
    public void stringWithOneIntegerShouldReturnTheInteger() {
        assertEquals("1", WeightSort.orderWeight("1"));
        assertEquals(String.valueOf(Integer.MAX_VALUE), WeightSort.orderWeight(String.valueOf(Integer.MAX_VALUE)));
    }

    @Test
    public void getSortedWeightMapBasicTest() {
        Map<Integer, List<String>> sortedWeightHashMap = new TreeMap<>();

        sortedWeightHashMap.put(2, List.of("2000"));
        sortedWeightHashMap.put(6, List.of("123"));
        sortedWeightHashMap.put(4, List.of("103"));
        sortedWeightHashMap.put(18, List.of("99"));
        sortedWeightHashMap.put(16, List.of("4444"));

        final String testString = "103 123 4444 99 2000";
        final String[] splitString = testString.split(" ");

        assertEquals(sortedWeightHashMap, WeightSort.getSortedWeightMap(splitString));
    }

    @Test
    public void getSortedWeightMapElementsWithSameWeightTest() {
        Map<Integer, List<String>> sortedWeightHashMap = new TreeMap<>();

        sortedWeightHashMap.put(36, List.of("9999"));
        sortedWeightHashMap.put(6, List.of("123"));
        sortedWeightHashMap.put(2, List.of("11", "11", "2000"));
        sortedWeightHashMap.put(4, List.of("10003", "22"));
        sortedWeightHashMap.put(32, List.of("44444444"));
        sortedWeightHashMap.put(10, List.of("1234000"));

        final String testString = "2000 10003 1234000 44444444 9999 11 11 22 123";
        final String[] splitString = testString.split(" ");

        assertEquals(sortedWeightHashMap, WeightSort.getSortedWeightMap(splitString));
    }

    @Test
    public void sumStringDigitsTest() {
        assertEquals(1, WeightSort.sumStringDigits("1"));
        assertEquals(3, WeightSort.sumStringDigits("12"));
        assertEquals(20, WeightSort.sumStringDigits("11111111111111111111"));
        assertEquals(180, WeightSort.sumStringDigits("99999999999999999999"));
        assertEquals(300, WeightSort.sumStringDigits("2347638457634258973465897345374856345543798888888888"));
    }

    @Test
    public void getSortedWeightStringBasicTest() {
        Map<Integer, List<String>> sortedWeightHashMap = new TreeMap<>();

        sortedWeightHashMap.put(2, List.of("2000"));
        sortedWeightHashMap.put(6, List.of("123"));
        sortedWeightHashMap.put(4, List.of("103"));
        sortedWeightHashMap.put(18, List.of("99"));
        sortedWeightHashMap.put(16, List.of("4444"));

        assertEquals("2000 103 123 4444 99", WeightSort.getSortedWeightString(sortedWeightHashMap));
    }

    @Test
    public void getSortedWeightStringElementsWithSameWeightTest() {
        Map<Integer, List<String>> sortedWeightHashMap = new TreeMap<>();

        sortedWeightHashMap.put(36, List.of("9999"));
        sortedWeightHashMap.put(6, List.of("123"));
        sortedWeightHashMap.put(2, List.of("11", "11", "2000"));
        sortedWeightHashMap.put(4, List.of("10003", "22"));
        sortedWeightHashMap.put(32, List.of("44444444"));
        sortedWeightHashMap.put(10, List.of("1234000"));

        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightSort.getSortedWeightString(sortedWeightHashMap));
    }
}
