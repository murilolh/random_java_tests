package stringapp.minimimwindowsubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings string1 and string2 of lengths L1 and L2 respectively, return the minimum window substring of string1 such that every character
 * in string2 (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * LC: 76
 */
public class MinimumWindowSubstring {
    public String minWindow(String string1, String string2) {
        final Map<Character, Integer> charCount = new HashMap<>();
        for (char c : string2.toCharArray())
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);

        int windowStart = 0;
        int windowEnd = 0;
        int counter = charCount.size();
        int minLength = Integer.MAX_VALUE;
        int startSubstring = 0;

        while (windowEnd < string1.length()) {
            char endChar = string1.charAt(windowEnd);
            if (charCount.containsKey(endChar)) {
                charCount.put(endChar, charCount.get(endChar) - 1);
                if (charCount.get(endChar) == 0)
                    counter--;
            }
            windowEnd++;

            while (counter == 0) {
                if (minLength > (windowEnd - windowStart)) {
                    minLength = windowEnd - windowStart;
                    startSubstring = windowStart;
                }

                char startChar = string1.charAt(windowStart);
                if (charCount.containsKey(startChar)) {
                    charCount.put(startChar, charCount.get(startChar) + 1);
                    if (charCount.get(startChar) > 0)
                        counter++;
                }
                windowStart++;
            }
        }

        return minLength > string1.length() ? "" : string1.substring(startSubstring, startSubstring + minLength);
    }
}
