package messageapp.rules.trans;

import messageapp.domain.Message;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReversalRuleTest {

    private final TransformationRule rule = new ReversalRule();

    static Stream<Arguments> verifyRuleTestOKArguments() {
        return Stream.of(
                createMessageArgument(
                        "TEST TEST TEST" + System.lineSeparator() + "TEST  TEST    TEST",
                        "TSET TSET TSET" + System.lineSeparator() + "TSET  TSET    TSET"),
                createMessageArgument(
                        "ANNA CIVIC KAYAK",
                        "ANNA CIVIC KAYAK"),
                createMessageArgument(
                        "annA civiC kayaK",
                        "Anna Civic Kayak"),
                createMessageArgument(
                        "annA         "+ System.lineSeparator() + "civiC" + System.lineSeparator() + "kayaK",
                        "Anna         " + System.lineSeparator() + "Civic" + System.lineSeparator() + "Kayak"),
                createMessageArgument(
                        "TEST TEST TEST                       TEST  TEST    TEST",
                        "TSET TSET TSET                       TSET  TSET    TSET")
        );
    }

    @ParameterizedTest
    @MethodSource("verifyRuleTestOKArguments")
    public void verifyRuleTestOK(Message givenMessage, String expectedBody) {
        rule.transform(givenMessage);

        assertEquals(expectedBody, givenMessage.getBody());
    }

    private static Arguments createMessageArgument(String givenBody, String expectedBody) {
        return Arguments.of(
                new Message("Path", "TO", "FROM", "SUBJECT", givenBody),
                expectedBody);
    }

}
