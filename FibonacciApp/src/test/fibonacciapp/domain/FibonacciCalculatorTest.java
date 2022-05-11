package fibonacciapp.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FibonacciCalculatorTest {

    private FibonacciCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new FibonacciCalculator();
    }

    @Test
    public void fibonacciOfZeroTest() {
        int n = 0;

        Long recursiveResult = calculator.fibonacciRecursive(n);
        Long memoResult = calculator.fibonacciRecursiveMemo(n);
        Long iterativeResult = calculator.fibonacciNonRecursive(n);

        Assert.assertEquals(Long.valueOf(0), recursiveResult);
        Assert.assertEquals(recursiveResult, memoResult);
        Assert.assertEquals(memoResult, iterativeResult);
    }

    @Test
    public void fibonacciOfOneTest() {
        int n = 1;

        Long recursiveResult = calculator.fibonacciRecursive(n);
        Long memoResult = calculator.fibonacciRecursiveMemo(n);
        Long iterativeResult = calculator.fibonacciNonRecursive(n);

        Assert.assertEquals(Long.valueOf(1), recursiveResult);
        Assert.assertEquals(recursiveResult, memoResult);
        Assert.assertEquals(memoResult, iterativeResult);
    }

    @Test
    public void fibonacciRecursiveOfRandomNumberTest() {
        int n = generateRandomNumberForTest();
        n = n + 2;

        Long recursiveResult = calculator.fibonacciRecursive(n);
        Long expectedResult = calculator.fibonacciRecursive(n - 1) + calculator.fibonacciRecursive(n - 2);

        Assert.assertEquals(expectedResult, recursiveResult);
    }

    @Test
    public void fibonacciMemoOfRandomNumberTest() {
        int n = generateRandomNumberForTest();
        n = n + 2;

        Long memoResult = calculator.fibonacciRecursiveMemo(n);
        Long expectedResult = calculator.fibonacciRecursiveMemo(n - 1) + calculator.fibonacciRecursiveMemo(n - 2);

        Assert.assertEquals(expectedResult, memoResult);
    }

    @Test
    public void fibonacciIterativeOfRandomNumberTest() {
        int n = generateRandomNumberForTest();
        n = n + 2;

        Long iterativeResult = calculator.fibonacciNonRecursive(n);
        Long expectedResult = calculator.fibonacciNonRecursive(n - 1) + calculator.fibonacciNonRecursive(n - 2);

        Assert.assertEquals(expectedResult, iterativeResult);
    }

    @Test
    public void allMethodsShouldReturnTheSameTest() {
        int n = generateRandomNumberForTest();

        Long recursiveResult = calculator.fibonacciRecursive(n);
        Long memoResult = calculator.fibonacciRecursiveMemo(n);
        Long iterativeResult = calculator.fibonacciNonRecursive(n);

        Assert.assertEquals(recursiveResult, memoResult);
        Assert.assertEquals(memoResult, iterativeResult);
    }

    @Test
    public void memoShouldBeFasterThanRecursiveTest() {
        int n = generateRandomNumberForTest();
        n = n + 2;

        long startRecursive = System.nanoTime();
        calculator.fibonacciRecursive(n);
        long elapsedTimeRecursive = System.nanoTime() - startRecursive;

        long startMemo = System.nanoTime();
        calculator.fibonacciRecursiveMemo(n);
        long elapsedTimeMemo = System.nanoTime() - startMemo;

        System.out.println("n = " + n);
        System.out.println("elapsedTimeRecursive = " + elapsedTimeRecursive);
        System.out.println("elapsedTimeMemo = " + elapsedTimeMemo);
        Assert.assertTrue(elapsedTimeRecursive > elapsedTimeMemo);
    }

    @Test
    public void iterativeShouldBeFasterThanMemoTest() {
        int n = generateRandomNumberForTest();
        n = n + 2;

        long startMemo = System.nanoTime();
        calculator.fibonacciRecursiveMemo(n);
        long elapsedTimeMemo = System.nanoTime() - startMemo;

        long startIterative = System.nanoTime();
        calculator.fibonacciNonRecursive(n);
        long elapsedTimeIterative = System.nanoTime() - startIterative;

        System.out.println("n = " + n);
        System.out.println("elapsedTimeMemo = " + elapsedTimeMemo);
        System.out.println("elapsedTimeIterative = " + elapsedTimeIterative);
        Assert.assertTrue(elapsedTimeMemo > elapsedTimeIterative);
    }

    private int generateRandomNumberForTest() {
        return (int) Math.floor(Math.random() * 20);
    }
}
