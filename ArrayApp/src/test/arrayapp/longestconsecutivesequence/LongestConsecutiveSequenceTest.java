package arrayapp.longestconsecutivesequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestConsecutiveSequenceTest {

    private LongestConsecutiveSequence longestConsecutiveSequence;

    @BeforeEach
    void setUp() {
        longestConsecutiveSequence = new LongestConsecutiveSequence();
    }

    static Stream<Arguments> longestConsecutiveSequenceArguments() {
        return Stream.of(
                Arguments.of(new int[]{100, 4, 200, 1, 3, 2}, 4),
                Arguments.of(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9),
                Arguments.of(new int[]{1, 3, 5, 7, 9}, 1),
                Arguments.of(new int[]{}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("longestConsecutiveSequenceArguments")
    void longestConsecutiveSequenceTest(int[] numbers, int expectedResult) {
        assertEquals(expectedResult, longestConsecutiveSequence.longestConsecutive(numbers));
    }
}
