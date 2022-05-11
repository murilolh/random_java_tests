/*

Fibonacci.java

The Fibonacci sequence is a sequence of natural numbers, in which the first two terms are 0 and 1, and each subsequent
term corresponds to the sum of the two preceding ones.
In mathematical terms, the sequence is defined recursively by the formula below,
with the first two terms F0 = 0 and F1 = 1.
Given an N input, implement a function that returns the value of the Nth
position of the sequence.

f(0) = 0
f(1) = 1
f(n) = f(n-1) + f(n-2), if n > 1

- Goal:
  - Implement the algorithm in two different ways: recursive and non-recursively.

Args: 0: n (value of the Nth position of the sequence)
	  1: "R" for recursive implementation
	     "M" for memoization implementation
	     Nothing for iterative implementation

*/
package fibonacciapp.app;

import fibonacciapp.domain.FibonacciCalculator;

public class Fibonacci {

	public static void main(String[] args) {

		FibonacciCalculator calculator = new FibonacciCalculator();

		if (args.length == 0 || Long.parseLong(args[0]) < 0) {
			System.out.println("ERROR");
		} else if (args.length > 1 && "R".equals(args[1])) {
			System.out.println("RESULT = " + calculator.fibonacciRecursive(Integer.valueOf(args[0])));
		} else if (args.length > 1 && "M".equals(args[1])) {
			System.out.println("RESULT = " + calculator.fibonacciRecursiveMemo(Integer.valueOf(args[0])));
		} else {
			System.out.println("RESULT = " + calculator.fibonacciNonRecursive(Integer.valueOf(args[0])));
		}
	}
}
