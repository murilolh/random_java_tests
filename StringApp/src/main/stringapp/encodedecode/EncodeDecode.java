package stringapp.encodedecode;

import java.util.LinkedList;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 * LC: 271
 */
public class EncodeDecode {
    private static final String DELIMITER = "#$#$";

    public String encode(List<String> strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string: strings)
            stringBuilder
                    .append(string.length())
                    .append(DELIMITER)
                    .append(string);
        return stringBuilder.toString();
    }

    public List<String> decode(String string) {
        List<String> result = new LinkedList<>();

        int currentIndex = 0;
        while (currentIndex < string.length()) {
            int stringLength = getNextStringLength(string, currentIndex);
            currentIndex += String.valueOf(stringLength).length() + DELIMITER.length();

            String decodedString = string.substring(currentIndex, currentIndex + stringLength);
            result.add(decodedString);

            currentIndex += decodedString.length();
        }

        return result;
    }

    private int getNextStringLength(String string, int currentIndex) {
        int stringLengthStartIndex = currentIndex;
        while (string.charAt(currentIndex) != DELIMITER.charAt(0))
            currentIndex++;

        return Integer.parseInt(string.substring(stringLengthStartIndex, currentIndex));
    }
}
