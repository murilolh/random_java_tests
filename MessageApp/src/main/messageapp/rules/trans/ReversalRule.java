package messageapp.rules.trans;

import java.util.Arrays;
import java.util.stream.Collectors;

import messageapp.domain.Message;

/**
 * Transformation Rule to reverse every word and keep the same numbers of spaces.
 */
public class ReversalRule implements TransformationRule {

	private final String PALINDROME = " &*&*& ";
	private final String LS = System.lineSeparator();

	@Override
	public void transform(Message message) {
		message.setBody(reverseWords(message.getBody()));
	}

	/**
	 * Reverse every word on a String, preserving spaces and line separators.
	 * 
	 * @param s String that will have all words reversed.
	 * @return Reversed String.
	 */
	private String reverseWords(String s) {
		return Arrays.stream(s.replace(LS, PALINDROME).split(" "))
				.map(word -> new StringBuilder(word).reverse().toString())
				.collect(Collectors.joining(" "))
				.replace(PALINDROME, LS);
	}

}
