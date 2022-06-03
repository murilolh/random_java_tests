package stringapp.anagram;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Valid Anagram LC: 242
 * Find All Anagrams in a String LC: 438
 */
public class AnagramService {

    /**
     * Given two strings, return true if they are anagrams, and false otherwise.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     */
    public static boolean isAnagramArray(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] alphabet = new int[26];
        for (char c : s1.toCharArray()) {
            alphabet[c - 'a']++;
            alphabet[c - 'a']--;
        }

        for (int i : alphabet)
            if (i != 0)
                return false;

        return true;

    }

    public static boolean isAnagramMap(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        final Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            updateAnagramMap(c, map, true);
            updateAnagramMap(c, map, false);
        }

        for (Character c : map.keySet())
            if (map.get(c) != 0)
                return false;

        return true;
    }

    private static void updateAnagramMap(Character c, Map<Character, Integer> m, boolean isIncreasing) {
        int increment = isIncreasing ? 1 : -1;
        m.put(c, m.getOrDefault(c, 0) + increment);
    }

    /**
     * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
     */
    public static List<Integer> findAnagrams(String s1, String s2) {
        List<Integer> result = new LinkedList<>();

        if (s2.length() > s1.length())
            return result;

        final Map<Character, Integer> map = getStringCharacterMap(s2);

        int counter = map.size();
        int windowStart = 0;
        int windowEnd = 0;

        while (windowEnd < s1.length()) {
            char endChar = s1.charAt(windowEnd);
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0)
                    counter--;
            }
            windowEnd++;

            while (counter == 0) {
                addStringIfWindowIsAnagram(result, windowStart, windowEnd, s2.length());

                char startChar = s1.charAt(windowStart);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0)
                        counter++;
                }
                windowStart++;
            }
        }

        return result;
    }

    /**
     * If counter = 0, there's an anagram in the window (windowEnd - windowStart). If the window size is equal to s2, the window is the anagram
     */
    private static void addStringIfWindowIsAnagram(List<Integer> result, int windowStart, int windowEnd, int anagramSize) {
        if (windowEnd - windowStart == anagramSize)
            result.add(windowStart);
    }

    private static Map<Character, Integer> getStringCharacterMap(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : string.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        return map;
    }
}
