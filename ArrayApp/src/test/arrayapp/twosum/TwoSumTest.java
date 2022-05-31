package arrayapp.twosum;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TwoSumTest {

    private static TwoSum twoSum;

    @BeforeAll
    static void beforeAll() {
        twoSum = new TwoSum();
    }

    static Stream<Arguments> twoSumArguments() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),
                Arguments.of(new int[]{3, 3}, 7, null),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, 18, new int[]{7, 9}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, 27, new int[]{12, 13}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, 28, null),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, 6, new int[]{1, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("twoSumArguments")
    public void twoSumTest(int[] numbers, int target, int[] expected) {
        assertArrayEquals(expected, twoSum.twoSum(numbers, target));
    }

    static Stream<Arguments> twoSumSortedArguments() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
                Arguments.of(new int[]{2, 3, 4}, 6, new int[]{1, 3}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{-1, 0}, -1, new int[]{1, 2}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, 27, new int[]{13, 14})
        );
    }

    @ParameterizedTest
    @MethodSource("twoSumSortedArguments")
    public void twoSumSortedTest(int[] numbers, int target, int[] expected) {
        assertArrayEquals(expected, twoSum.twoSumSorted(numbers, target));
    }
}
