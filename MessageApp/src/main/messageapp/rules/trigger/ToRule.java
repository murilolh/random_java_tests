package messageapp.rules.trigger;

import java.util.List;

import messageapp.domain.Message;
import messageapp.rules.trans.TransformationRule;

/**
 * Trigger Rule to verify if the "TO" field of a message has an e-mail with the domain "domain.com".
 */
public class ToRule extends TriggerRule {

	private static final String DOMAIN = "@domain.com";

	public ToRule(List<TransformationRule> rules) {
		super(rules);
	}

	@Override
	public boolean verify(Message message) {
		return message.getTo().contains(DOMAIN);
	}
}
