package arrayapp.besttimebuysellstock;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeBuySellStockTest {
    private static BestTimeBuySellStock bestTimeBuySellStock;

    @BeforeAll
    static void beforeAll() {
        bestTimeBuySellStock = new BestTimeBuySellStock();
    }

    static Stream<Arguments> bestTimeBuySellStockArguments() {
        return Stream.of(
                Arguments.of(new int[]{7,1,5,3,6,4}, 5),
                Arguments.of(new int[]{7,6,4,3,1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("bestTimeBuySellStockArguments")
    public void bestTimeBuySellStockTest(int[] prices, int expectedMaxProfit) {
        assertEquals(expectedMaxProfit, bestTimeBuySellStock.maxProfit(prices));
    }
}
