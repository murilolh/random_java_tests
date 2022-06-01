package stringapp.utils;

public class StringUtils {
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
