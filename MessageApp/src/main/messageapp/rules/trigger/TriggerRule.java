package messageapp.rules.trigger;

import java.util.List;

import messageapp.domain.Message;
import messageapp.rules.trans.TransformationRule;

/**
 * Abstract class to verify and apply Transformations Rules in Messages.
 */
public abstract class TriggerRule {

	private final List<TransformationRule> rules;

	public TriggerRule(List<TransformationRule> rules) {
		super();
		this.rules = rules;
	}

	/**
	 * Verify if a list of Transformation Rules can be applied to a message.
	 * 
	 * @param message Message to be verified.
	 * @return true if the Message can be transformed.
	 */
	protected abstract boolean verify(Message message);

	/**
	 * Apply a list of Transformation Rules if they can be applied to a message.
	 * 
	 * @param message Message to be transformed.
	 * @return true if the transformation operations were executed.
	 */
	public boolean apply(Message message) {
		boolean shouldTransform = verify(message);
		if (shouldTransform)
			for (TransformationRule rule : rules)
				rule.transform(message);
		return shouldTransform;
	}
}
