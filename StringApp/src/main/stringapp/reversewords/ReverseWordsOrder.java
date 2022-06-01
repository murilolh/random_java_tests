package stringapp.reversewords;

/**
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space. *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 * LC: 151
 */
public class ReverseWordsOrder {
    public static String reverseWords(String s) {
        StringBuilder currentWord = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar != ' ')
                currentWord.append(currentChar);

            if ((currentChar == ' ' || i == (s.length() - 1)) && currentWord.length() > 0) {
                result.insert(0, currentWord.append(" "));
                currentWord.setLength(0);
            }
        }

        return result.toString().trim();
    }
}
