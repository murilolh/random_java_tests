package messageapp.rules.trigger;

import java.util.List;

import messageapp.domain.Message;
import messageapp.rules.trans.TransformationRule;

/**
 * Trigger Rule to verify if the "SUBJECT" field of a message starts with the word "SECURE:" without the double quotes.
 */
public class SubjectRule extends TriggerRule {

	private static final String SECURE = "SECURE:";

	public SubjectRule(List<TransformationRule> rules) {
		super(rules);
	}

	@Override
	public boolean verify(Message message) {

		return message.getSubject().startsWith(SECURE);
	}

}
