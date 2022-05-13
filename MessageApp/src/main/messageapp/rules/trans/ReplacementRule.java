package messageapp.rules.trans;

import messageapp.domain.Message;

/**
 * Transformation Rule to replace every $ with e, ^ with y and & with u.
 */
public class ReplacementRule implements TransformationRule {

	@Override
	public void transform(Message message) {
		message.setBody(message.getBody()
				.replace('$', 'e')
				.replace('^', 'y')
				.replace('&', 'u'));
	}

}
