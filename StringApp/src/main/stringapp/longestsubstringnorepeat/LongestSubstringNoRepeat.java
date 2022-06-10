package stringapp.longestsubstringnorepeat;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * LC: 3
 */
public class LongestSubstringNoRepeat {
    public int lengthOfLongestSubstring(String string) {
        final Set<Character> currentWindow = new HashSet<>();
        int windowStart = 0;
        int windowEnd = 0;
        int maxLength = 0;

        while (windowEnd < string.length()) {
            if (!currentWindow.contains(string.charAt(windowEnd)))
                currentWindow.add(string.charAt(windowEnd++));
            else
                currentWindow.remove(string.charAt(windowStart++));

            maxLength = Math.max(maxLength, currentWindow.size());
        }

        return maxLength;
    }
}
