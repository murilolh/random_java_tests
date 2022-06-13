package arrayapp.searchrotatedsorted;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchRotatedSortedTest {
    private static SearchRotatedSorted searchRotatedSorted;

    @BeforeAll
    static void beforeAll() {
        searchRotatedSorted = new SearchRotatedSorted();
    }

    static Stream<Arguments> searchArguments() {
        return Stream.of(
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
                Arguments.of(new int[]{-1}, 0, -1),
                Arguments.of(new int[]{1}, 1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("searchArguments")
    public void searchTest(int[] numbers, int target, int expected) {
        assertEquals(expected, searchRotatedSorted.search(numbers, target));
    }

    static Stream<Arguments> findMinArguments() {
        return Stream.of(
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0),
                Arguments.of(new int[]{3, 4, 5, 1, 2}, 1),
                Arguments.of(new int[]{-1}, -1),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{11, 13, 15, 17}, 11),
                Arguments.of(new int[]{5, 1, 2, 3, 4}, 1)

        );
    }

    @ParameterizedTest
    @MethodSource("findMinArguments")
    public void findMinTest(int[] numbers, int expected) {
        assertEquals(expected, searchRotatedSorted.findMin(numbers));
    }
}
