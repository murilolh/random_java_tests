package messageapp.rules.trans;

import messageapp.domain.Message;

/**
 * Interface for Message Transformation Rules.
 */
public interface TransformationRule {

	/**
	 * Perform a transformation on a message.
	 * 
	 * @param message Message to be transformed.
	 */
	void transform(Message message);
	
}
