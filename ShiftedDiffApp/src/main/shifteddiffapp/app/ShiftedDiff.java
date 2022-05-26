package shifteddiffapp.app;

/**
 * <pre>
 * Write a function that receives two strings and returns the number of characters we would need to rotate the first string forward to match the second.
 *
 * For instance, take the strings "fatigue" and "tiguefa".
 * In this case, the first string can be rotated 5 characters forward to produce the second string, so 5 would be returned. Here are the steps:
 *
 *      no rotations: "fatigue"
 *      1st rotation: "efatigu"
 *      2nd rotation: "uefatig"
 *      3rd rotation: "guefati"
 *      4th rotation: "iguefat"
 *      5th rotation: "tiguefa"
 *
 * If the second string isn't a valid rotation of the first string, the method should return -1.
 *
 * Specification
 * Challenge.shiftedDiff(first, second)
 *      computes the number of rotations to make string first equal to string second, if possible
 *
 * Parameters
 *      first: String - string to be rotated
 *      second: String - target string to be matched by rotating first
 *
 * Return Value
 *      Integer - Number of rotations needed to turn string first into second, -1 if invalid
 *
 * Examples:
 *      "coffee", "eecoff" => 2
 *      "eecoff", "coffee" => 4
 *      "moose", "Moose" => -1
 *      "isn't", "'tisn" => 2
 *      "Esham", "Esham" => 0
 *      "dog", "god" => -1
 * <pre/>
 **/
public class ShiftedDiff {
    public static int shiftedDiff(String first, String second) {
        return stringsAreCompatible(first, second) ? shiftedDiffCompatible(first, second) : -1;
    }

    private static int shiftedDiffCompatible(String first, String second) {
        StringBuilder rotationString = new StringBuilder(second);

        for (int i = 0; i < rotationString.length(); i++)
            if (first.equals(rotationString.toString()))
                return i;
            else
                rotateString(rotationString);

        return -1;
    }

    private static void rotateString(StringBuilder rotationString) {
        char rotateChar = rotationString.charAt(0);
        rotationString.deleteCharAt(0);
        rotationString.append(rotateChar);
    }

    private static boolean stringsAreCompatible(String first, String second) {
        return !Utils.stringsAreNullOrEmpty(first, second) &&
                first.length() == second.length();
    }

    public static class Utils {

        public static boolean stringsAreNullOrEmpty(String... strings) {
            for (String string : strings)
                if (stringIsNullOrEmpty(string))
                    return true;

            return false;
        }

        public static boolean stringIsNullOrEmpty(String string) {
            return string == null || string.isEmpty();
        }
    }
}