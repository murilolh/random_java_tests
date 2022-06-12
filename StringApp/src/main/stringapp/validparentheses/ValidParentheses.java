package stringapp.validparentheses;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * LC: 20
 */
public class ValidParentheses {
    public boolean isValid(String string) {
        final Deque<Character> verificationStack = new LinkedList<>();
        for (char c : string.toCharArray())
            if (c == '(' || c == '[' || c == '{')
                verificationStack.push(c);
            else if (verificationStack.isEmpty() ||
                    (c == ')' && verificationStack.pop() != '(') ||
                    (c == ']' && verificationStack.pop() != '[') ||
                    (c == '}' && verificationStack.pop() != '{'))
                return false;
        return verificationStack.isEmpty();
    }

    public boolean isValidMap(String string) {
        final Deque<Character> verificationStack = new LinkedList<>();
        final Map<Character, Character> charMap = Map.of(')', '(', ']', '[', '}', '{');
        for (char c : string.toCharArray())
            if (charMap.containsValue(c))
                verificationStack.push(c);
            else if (verificationStack.isEmpty() ||
                    verificationStack.pop() != charMap.get(c))
                return false;
        return verificationStack.isEmpty();
    }
}
