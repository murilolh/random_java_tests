package stringapp.minimimwindowsubstring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumWindowSubstringTest {

    private MinimumWindowSubstring minimumWindowSubstring;

    @BeforeEach
    void setUp() {
        minimumWindowSubstring = new MinimumWindowSubstring();
    }

    static Stream<Arguments> getMinimumWindowSubstringArguments() {
        return Stream.of(
                Arguments.of("ADOBECODEBANC", "ABC", "BANC"),
                Arguments.of("a", "a", "a"),
                Arguments.of("a", "aa", "")
        );
    }

    @ParameterizedTest
    @MethodSource("getMinimumWindowSubstringArguments")
    void minimumWindowSubstringTest(String string1, String string2, String result) {
        assertEquals(result, minimumWindowSubstring.minWindow(string1, string2));
    }
}
