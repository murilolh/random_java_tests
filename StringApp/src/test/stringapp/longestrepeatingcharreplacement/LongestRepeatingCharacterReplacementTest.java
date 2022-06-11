package stringapp.longestrepeatingcharreplacement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestRepeatingCharacterReplacementTest {

    private LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement;

    @BeforeEach
    void setUp() {
        longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
    }

    static Stream<Arguments> getLongestRepeatingCharacterReplacementArguments() {
        return Stream.of(
                Arguments.of("ABAB", 2, 4),
                Arguments.of("AABABBA", 1, 4),
                Arguments.of("AAAAAAAAAA", 1, 10),
                Arguments.of("ABABABABCCCCABABABC", 1, 5),
                Arguments.of("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 26, 26)
        );
    }

    @ParameterizedTest
    @MethodSource("getLongestRepeatingCharacterReplacementArguments")
    void lengthOfLongestSubstringTest(String string, int k, int result) {
        assertEquals(result, longestRepeatingCharacterReplacement.characterReplacement(string, k));
    }
}
