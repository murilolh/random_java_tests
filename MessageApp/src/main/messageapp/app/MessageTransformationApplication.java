package messageapp.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import messageapp.domain.Message;
import messageapp.rules.trans.ReplacementRule;
import messageapp.rules.trans.ReversalRule;
import messageapp.rules.trigger.BodyRule;
import messageapp.rules.trigger.SubjectRule;
import messageapp.rules.trigger.ToRule;
import messageapp.rules.trigger.TriggerRule;
import messageapp.service.MessageService;
import messageapp.service.MessageServiceImpl;

public class MessageTransformationApplication {

	/**
       The Message Transformer is a system that transforms messages based on rules. Messages are scanned against certain rules and transformations are executed accordingly.
	   Each message contains the following fields:
		- To: comma-separated email addresses
		- From: one email address
		- Subject: subject line
		- Body: message body. This is a multi-line field, and always starts on the next line after the Body:
				field.
		Take a look at any sample message from the provided messages folder to see what messages look like.

		Transformations work on the message body only and leave the other fields intact.

		You’re tasked with creating a message processing system that reads in messages from files to apply
		certain transformations based on configured rules before outputting them to the file system.

		Here are the two transformations that the system is currently configured to perform:
		 - Replace every $ with e, ^ with y and & with u. (Replacement rule)
		 - Reverse every word and keep the same numbers of spaces. (Reversal rule)

		The system currently contains trigger rules that scan the messages and decide which transformations to apply.
		 - The To: field belongs to the domain domain.com then apply the replacement rule
		 - The Subject: field starts with the word “SECURE:” without the double quotes then apply the reversal rule
		 - The Body contains 10 consecutive digits anywhere then apply both the replacement and reversal rules (in this order) 
		
		Pass file paths as arguments to the program.

	 	Argument example: "messages\message1.txt" "messages\message2.txt" "messages\message3.txt" "messages\message4.txt"
	*/
	public static void main(String[] args) {
		if (args != null && args.length > 0) {
			MessageService msgService = new MessageServiceImpl();
			
			List<Message> messages = msgService.read(args);

			msgService.write(msgService.transform(messages, getSystemStoredRules()));
		}
	}

	private static List<TriggerRule> getSystemStoredRules() {
		TriggerRule toRule = new ToRule(Collections.singletonList(new ReplacementRule()));
		TriggerRule subjectRule = new SubjectRule(Collections.singletonList(new ReversalRule()));
		TriggerRule bodyRule = new BodyRule(Arrays.asList(new ReplacementRule(), new ReversalRule()));

		return Arrays.asList(toRule, subjectRule, bodyRule);
	}

}
