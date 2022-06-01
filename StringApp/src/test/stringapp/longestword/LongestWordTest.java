package stringapp.longestword;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestWordTest {
    static Stream<Arguments> getLongestWordArguments() {
        return Stream.of(
                Arguments.of(new String[]{"w", "wo", "wor", "worl", "world"}, "world"),
                Arguments.of(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}, "apple")
        );
    }

    @ParameterizedTest
    @MethodSource("getLongestWordArguments")
    void longestWordTest(String[] dictionary, String result) {
        assertEquals(result, LongestWord.longestWord(dictionary));
    }
}
