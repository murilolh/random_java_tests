package arrayapp.containerwithmostwater;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerWithMostWaterTest {

    private static ContainerWithMostWater containerWithMostWater;

    @BeforeAll
    static void beforeAll() {
        containerWithMostWater = new ContainerWithMostWater();
    }

    static Stream<Arguments> containerWithMostWaterArguments() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of(new int[]{1, 1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("containerWithMostWaterArguments")
    public void containerWithMostWaterTest(int[] height, int expectedMaxArea) {
        assertEquals(expectedMaxArea, containerWithMostWater.maxArea(height));
    }
}
