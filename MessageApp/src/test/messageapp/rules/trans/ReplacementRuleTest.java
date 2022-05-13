package messageapp.rules.trans;

import messageapp.domain.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplacementRuleTest {

	private final TransformationRule rule = new ReplacementRule();

	@Test
	public void verifyRuleTestOK() {
		Message messageOK = new Message("Path", "TO", "FROM", "SUBJECT", "TEST$TEST^TEST&");
		
		rule.transform(messageOK);

		assertEquals("TESTeTESTyTESTu", messageOK.getBody());
	}

}
