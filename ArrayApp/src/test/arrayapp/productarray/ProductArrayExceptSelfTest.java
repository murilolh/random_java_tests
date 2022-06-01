package arrayapp.productarray;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductArrayExceptSelfTest {
    static Stream<Arguments> getProductExceptSelfArguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                Arguments.of(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0}),
                Arguments.of(new int[]{-1, 2, -3, 4, -5}, new int[]{120, -60, 40, -30, 24}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{362880, 181440, 120960, 90720, 72576, 60480, 51840, 45360, 40320})
        );
    }

    @ParameterizedTest
    @MethodSource("getProductExceptSelfArguments")
    void productExceptSelfTest(int[] numbers, int[] result) {
        assertArrayEquals(result, ProductArrayExceptSelf.productExceptSelf(numbers));
    }
}
