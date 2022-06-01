package stringapp.reversewords;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWordsTest {

    static Stream<Arguments> getReverseStringArguments() {
        return Stream.of(
                Arguments.of("abcde", "edcba"),
                Arguments.of("TEST TEST TEST", "TSET TSET TSET"),
                Arguments.of("TEST TEST              TEST", "TSET TSET              TSET"),
                Arguments.of("327489 HSADKJ asdjkh 2389MSDHJAkasdklj329 asdk3298ASDK asd903ajs3 ASJDSAHsadhjaiw",
                        "984723 JKDASH hkjdsa 923jlkdsakAJHDSM9832 KDSA8923kdsa 3sja309dsa wiajhdasHASDJSA")
        );
    }

    @ParameterizedTest
    @MethodSource("getReverseStringArguments")
    void reverseWordsTest(String original, String expected) {
        assertEquals(expected, ReverseWords.reverseWords(original));
    }

    @ParameterizedTest
    @MethodSource("getReverseStringArguments")
    void reverseWordsStringBuilderTest(String original, String expected) {
        assertEquals(expected, ReverseWords.reverseWordsStringBuilder(original));
    }

    @ParameterizedTest
    @MethodSource("getReverseStringArguments")
    void reverseWordsStreamTest(String original, String expected) {
        assertEquals(expected, ReverseWords.reverseWordsStream(original));
    }
}
