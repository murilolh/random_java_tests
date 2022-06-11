package stringapp.longestrepeatingcharreplacement;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * LC: 424
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String string, int k) {
        final Map<Character, Integer> charCount = new HashMap<>();

        int maxLength = 0;
        int maxCount = 0;
        int windowStart = 0;
        int windowEnd = 0;

        while (windowEnd < string.length()) {
            char endChar = string.charAt(windowEnd);
            charCount.put(endChar, (charCount.getOrDefault(endChar, 0) + 1));
            windowEnd++;

            maxCount = Math.max(maxCount, charCount.get(endChar));
            while (windowEnd - windowStart - maxCount > k) {
                char startChar = string.charAt(windowStart);
                charCount.put(startChar, charCount.get(startChar) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart);
        }

        return maxLength;
    }


}
