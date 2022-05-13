package messageapp.rules.trigger;

import messageapp.domain.Message;
import messageapp.rules.trans.TransformationRule;

import java.util.List;

/**
 * Trigger Rule to verify if the "BODY" field of a message contains 10 consecutive digits anywhere.
 */
public class BodyRule extends TriggerRule {

    public static final String TEN_CONSECUTIVE_DIGITS_PATTERN = ".*\\d{10,}.*";

    public BodyRule(List<TransformationRule> rules) {
        super(rules);
    }

    @Override
    public boolean verify(Message message) {
        return message
                .getBody()
                .replace(System.lineSeparator(), "")
                .matches(TEN_CONSECUTIVE_DIGITS_PATTERN);
    }

}
