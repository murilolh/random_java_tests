package arrayapp.topfrequentelements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TopFrequentElementsTest {
    static Stream<Arguments> topKFrequentArguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 6, new int[]{1, 2, 3, 4, 5, 6}),
                Arguments.of(new int[]{1}, 1, new int[]{1}),
                Arguments.of(new int[]{1, 2, 3, 5, 6, 5, 1, 3, 5, 7, 6, 7, 6, 7, 8, 1, 8, 1, 2, 32, 2, 234, 12, 435, 6, 7, 8, 9, 0, 3, 123,
                                21, 453, 4, 345, 456, 3, 2, 1, 434, 1, 3, 5, 67, 8, 53, 1, 34, 211, 5, 7, 453, 8, 8, 2, 34, 22, 22, 22, 22, 22, 22, 22, 22},
                        3,
                        new int[]{22, 1, 8})
        );
    }

    @ParameterizedTest
    @MethodSource("topKFrequentArguments")
    void topKFrequentTest(int[] numbers, int k, int[] expectedResult) {
        assertArrayEquals(expectedResult, TopFrequentElements.topKFrequent(numbers, k));
    }
}
