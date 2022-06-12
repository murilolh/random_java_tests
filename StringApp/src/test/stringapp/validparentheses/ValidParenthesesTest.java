package stringapp.validparentheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ValidParenthesesTest {

    private ValidParentheses validParentheses;

    @BeforeEach
    void setUp() {
        validParentheses = new ValidParentheses();
    }

    static Stream<Arguments> validParenthesesArguments() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(}", false),
                Arguments.of("([)]{}", false),
                Arguments.of("{(([])())}", true),
                Arguments.of("(", false),
                Arguments.of("]", false)
        );
    }

    @ParameterizedTest
    @MethodSource("validParenthesesArguments")
    public void validParentheses(String string, boolean result) {
        Assertions.assertEquals(result, validParentheses.isValid(string));
    }

    @ParameterizedTest
    @MethodSource("validParenthesesArguments")
    public void validParenthesesMap(String string, boolean result) {
        Assertions.assertEquals(result, validParentheses.isValidMap(string));
    }
}
