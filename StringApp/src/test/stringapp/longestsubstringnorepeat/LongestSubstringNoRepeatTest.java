package stringapp.longestsubstringnorepeat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringNoRepeatTest {

    private LongestSubstringNoRepeat longestSubstringNoRepeat;

    @BeforeEach
    void setUp() {
        longestSubstringNoRepeat = new LongestSubstringNoRepeat();
    }

    static Stream<Arguments> getLongestSubstringNoRepeatArguments() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("abca", 3),
                Arguments.of("bbbbbbbbbbbbb", 1),
                Arguments.of("241572134658672314&&&&&abcdefghijklmnopqrstuvxwyz1234567890#####23456721348576234567", 38)
        );
    }

    @ParameterizedTest
    @MethodSource("getLongestSubstringNoRepeatArguments")
    void lengthOfLongestSubstringTest(String string, int result) {
        assertEquals(result, longestSubstringNoRepeat.lengthOfLongestSubstring(string));
    }
}
