package stringapp.palindrome;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeCheckerTest {
    static Stream<Arguments> getPalindromeArguments() {
        return Stream.of(
                Arguments.of("", true),
                Arguments.of("           ", true),
                Arguments.of("abcde", false),
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("Red roses run no risk, sir, on Nurse’s order.", true),
                Arguments.of("He lived as a devil, eh?", true),
                Arguments.of("Sir\n\t    ,    \n\t  I demand     \n\t , I am    \n\t  a maid     \n\tnamed     \n\t Iris.", true),
                Arguments.of("Sir\n\t    ,    \n\t  I demand you     \n\t , I am    \n\t  a maid     \n\tnamed     \n\t Iris.", false)
        );
    }

    @ParameterizedTest
    @MethodSource("getPalindromeArguments")
    void isPalindromeTest(String original, boolean result) {
        assertEquals(result, PalindromeChecker.isPalindrome(original));
    }
}
