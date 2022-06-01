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
        for (int i = 0; i < s1.length(); i++) {
            alphabet[s1.charAt(i) - 'a']++;
            alphabet[s2.charAt(i) - 'a']--;
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
        for (int i = 0; i < s1.length(); i++) {
            updateAnagramMap(s1.charAt(i), map, true);
            updateAnagramMap(s2.charAt(i), map, false);
        }

        for (Character c : map.keySet())
            if (map.get(c) != 0)
                return false;

        return true;
    }

    private static void updateAnagramMap(Character c, Map<Character, Integer> m, boolean isIncreasing) {
        int i = isIncreasing ? 1 : -1;
        m.put(c, m.getOrDefault(c, 0) + i);
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
        int start = 0;
        int end = 0;

        while (end < s1.length()) {
            char c = s1.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    counter--;
            }
            end++;

            while (counter == 0) {
                char tempChar = s1.charAt(start);

                if (map.containsKey(tempChar)) {
                    map.put(tempChar, map.get(tempChar) + 1);
                    if (map.get(tempChar) > 0)
                        counter++;
                }

                if (end - start == s2.length())
                    result.add(start);

                start++;
            }
        }

        return result;
    }

    private static Map<Character, Integer> getStringCharacterMap(String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s2.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        return map;
    }
}
