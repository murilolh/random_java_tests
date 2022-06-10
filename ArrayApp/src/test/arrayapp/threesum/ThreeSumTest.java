package arrayapp.threesum;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThreeSumTest {

    private static ThreeSum threeSum;

    @BeforeAll
    static void beforeAll() {
        threeSum = new ThreeSum();
    }

    static Stream<Arguments> threeSumArguments() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 1, 2, -1, -4}, List.of(List.of(-1, -1, 2), List.of(-1, 0, 1))),
                Arguments.of(new int[]{}, Collections.emptyList()),
                Arguments.of(new int[]{1, 2, 3}, Collections.emptyList()),
                Arguments.of(new int[]{1, 2, -3}, List.of(List.of(1, 2, -3))),
                Arguments.of(new int[]{1, 1, 2, -3}, List.of(List.of(1, 2, -3))),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 2, -3}, List.of(List.of(1, 2, -3))),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1, -3}, Collections.emptyList()),
                Arguments.of(new int[]{1, 1, 1}, Collections.emptyList()),
                Arguments.of(new int[]{0, 0, 0}, List.of(List.of(0, 0, 0))),
                Arguments.of(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0},
                        List.of(List.of(-5, 1, 4), List.of(-4, 0, 4), List.of(-4, 1, 3), List.of(-2, -2, 4), List.of(-2, 1, 1), List.of(0, 0, 0)))
        );
    }

    @ParameterizedTest
    @MethodSource("threeSumArguments")
    public void threeSumTest(int[] numbers, List<List<Integer>> expected) {
        List<List<Integer>> result = threeSum.threeSum(numbers);
        for (List<Integer> expectedList : expected)
            assertTrue(assertThatListExists(result, expectedList));
    }

    private boolean assertThatListExists(List<List<Integer>> expectedResult, List<Integer> resultList) {
        for (List<Integer> expectedResultList : expectedResult)
            if (expectedResultList.containsAll(resultList))
                return true;
        return false;
    }
}
