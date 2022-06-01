package stringapp.reversewords;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWordsOrderTest {
    static Stream<Arguments> getReverseStringArguments() {
        return Stream.of(
                Arguments.of("abcde", "abcde"),
                Arguments.of("TEST TEST TEST", "TEST TEST TEST"),
                Arguments.of("TEST TEST              TEST", "TEST TEST TEST"),
                Arguments.of("the sky is blue", "blue is sky the"),
                Arguments.of("  hello world  ", "world hello"),
                Arguments.of("a good   example", "example good a"),
                Arguments.of("327489 HSADKJ asdjkh 2389MSDHJAkasdklj329 asdk3298ASDK asd903ajs3 ASJDSAHsadhjaiw",
                        "ASJDSAHsadhjaiw asd903ajs3 asdk3298ASDK 2389MSDHJAkasdklj329 asdjkh HSADKJ 327489")
        );
    }

    @ParameterizedTest
    @MethodSource("getReverseStringArguments")
    void reverseWordsTest(String original, String expected) {
        assertEquals(expected, ReverseWordsOrder.reverseWords(original));
    }
}
