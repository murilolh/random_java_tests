package messageapp.rules.trigger;

import java.util.Collections;

import messageapp.domain.Message;
import messageapp.rules.trans.ReversalRule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BodyRuleTest {

	private final TriggerRule rule = new BodyRule(Collections.singletonList(new ReversalRule()));
	
	@Test
	public void verifyRuleTestOK() {
		assertTrue(rule.apply(
				new Message("Path", "TO", "FROM", "SUBJECT", "qwert1234567890qwert")));
	}
	
	@Test
	public void verifyRule9DigitsTest() {
		assertFalse(rule.apply(
				new Message("Path", "TO", "FROM", "SUBJECT", "qwert123567890qwert")));
	}

	@Test
	public void verifyRuleScatteredDigitsTest() {
		assertFalse(rule.apply(
				new Message("Path", "TO", "FROM", "SUBJECT", "q1w2e3r4t5q6w7e8r9t000000")));
	}

	@Test
	public void verifyRuleMoreThan10DigitsTest() {
		assertTrue(rule.apply(
				new Message("Path", "TO", "FROM", "SUBJECT", "q1w2e3r4t5q6w7e8r9t00000000000000000000")));
	}
	
}
