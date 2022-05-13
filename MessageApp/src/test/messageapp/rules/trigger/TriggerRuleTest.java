package messageapp.rules.trigger;

import messageapp.domain.Message;
import messageapp.rules.trans.TransformationRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TriggerRuleTest {

    private TriggerRule rule;

    @BeforeEach
    public void setUp() {
        rule = new DummyTriggerRule(Collections.singletonList(new DummyTransformationRule()));
    }

    @Test
    public void shouldTransformTest() {
        Message message = new Message("Path", "TO", "FROM", "SUBJECT", "BODY");

        assertTrue(rule.apply(message));
        assertEquals("This body was transformed: BODY", message.getBody());
    }

    @Test
    public void shouldNotTransformEmptyTest() {
        Message message = new Message("Path", "TO", "FROM", "SUBJECT", "");

        assertFalse(rule.apply(message));
        assertEquals("", message.getBody());
    }

    @Test
    public void shouldNotTransformNullTest() {
        Message message = new Message("Path", "TO", "FROM", "SUBJECT", null);

        assertFalse(rule.apply(message));
        assertEquals("", message.getBody());
    }

    private static class DummyTriggerRule extends TriggerRule {

        public DummyTriggerRule(List<TransformationRule> rules) {
            super(rules);
        }

        @Override
        protected boolean verify(Message message) {
            return !message.getBody().isEmpty();
        }
    }

    private static class DummyTransformationRule implements TransformationRule {

        @Override
        public void transform(Message message) {
            message.setBody("This body was transformed: " + message.getBody());
        }
    }

}
