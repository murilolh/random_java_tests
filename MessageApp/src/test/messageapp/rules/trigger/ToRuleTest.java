package messageapp.rules.trigger;

import java.util.Collections;

import messageapp.domain.Message;
import messageapp.rules.trans.ReversalRule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToRuleTest {

	private final TriggerRule rule = new ToRule(Collections.singletonList(new ReversalRule()));
	
	@Test
	public void verifyRuleTestOK() {
		assertTrue(rule.apply(
				new Message("Path", "test@domain.com,test2.gmail.com", "FROM", "SUBJECT", "BODY")));
	}
	
	@Test
	public void verifyRuleFalseTest() {
		assertFalse(rule.apply(
				new Message("Path", "test@domain.net,test2.gmail.com", "FROM", "SUBJECT", "BODY")));
	}

	@Test
	public void verifyRuleDomainAsTheNameTest() {
		assertFalse(rule.apply(
				new Message("Path", "domain.com@gmail.com,test2.gmail.com", "FROM", "SUBJECT", "BODY")));
	}
	
}
