package messageapp.rules.trigger;

import java.util.Collections;

import messageapp.domain.Message;
import messageapp.rules.trans.ReversalRule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubjectRuleTest {

    private final TriggerRule rule = new SubjectRule(Collections.singletonList(new ReversalRule()));

    @Test
    public void verifyRuleTestOK() {
        assertTrue(rule.apply(
                new Message("Path", "TO", "FROM", "SECURE:", "BODY")));
    }

    @Test
    public void verifyRuleNotSecureTest() {
        assertFalse(rule.apply(
                new Message("Path", "TO", "FROM", "NOTSECURE:", "BODY")));
    }

    @Test
    public void verifyRuleSecureNotAtTheStartTest() {
        assertFalse(rule.apply(
                new Message("Path", "TO", "FROM", "Start of the message SECURE: end of the message", "BODY")));
    }

}
