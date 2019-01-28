/*

Fibonnaci.java

The Fibonacci sequence is a sequence of natural numbers, in which the
first two terms are 0 and 1, and each subsequent term corresponds to
to the sum of the two preceding ones.
In mathematical terms, the sequence is defined recursively by the formula
below, with the first two terms F0 = 0 and F1 = 1.
Given an N input, implement a function that returns the value of the Nth
position of the sequence.

f(0) = 0
f(1) = 1
f(n) = f(n-1) + f(n-2), if n > 1

- Goal:
  - Implement the algorithm in two different ways: recursive and
non-recursively.

*/
package com.random_tests_java;

public class Fibonacci {

	public static void main(String[] args) {

		if (args.length == 0 || Long.valueOf(args[0]) < 0) {
			System.out.println("ERROR");
		} else if (args.length > 1 && "R".equals(args[1])) {
			System.out.println(fibonacciRecursive(Long.valueOf(args[0])));
		} else if (args.length > 1 && "M".equals(args[1])) {
			System.out.println(fibonacciRecursiveMemo(Long.valueOf(args[0])));
		} else {
			System.out.println(fibonacciNonRecursive(Long.valueOf(args[0])));
		}

	}

	/**
	 * Classic recursive method.
	 * 
	 * @param n input
	 * @return n-th fibonacci number
	 */
	private static Long fibonacciRecursive(Integer n) {
		if (n <= 1) {
			return n.longValue();
		}
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	/**
	 * Recursive method with memoization.
	 * 
	 * @param n input
	 * @return n-th fibonacci number
	 */
	private static Long fibonacciRecursiveMemo(Integer n) {
		List<Long> memo = new ArrayList<Long>();
		memo.add(0l); // Initializing memo with f(0)
		memo.add(1l); // and f(1)
		return fibonacciMemo(n, memo);
	}

	/**
	 * Recursive method with memoization.
	 * 
	 * @param n    input
	 * @param memo List to store previous computations
	 * @return n-th fibonacci number
	 */
	private static Long fibonacciMemo(Integer n, List<Long> memo) {
		if (n <= 1) {
			return n.longValue();
		} else if (memo.size() > n && memo.get(n) != null) {
			return memo.get(n);
		}
		Long result = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
		memo.add(result); // Adding f(n) to memo

		return result;
	}

	/**
	 * Non-recursive solution.
	 * 
	 * @param n input
	 * @return n-th fibonacci number
	 */
	private static Long fibonacciNonRecursive(Integer n) {
		if (n <= 1) {
			return n.longValue();
		}

		Long n1 = 1l; // (n - 1), initially f(1) = 1
		Long n2 = 0l; // (n - 2), initially f(0) = 0
		Long p; // Pivot
		for (int i = 0; i < n - 2; i++) {
			p = n2; // Store the value of (n - 2) in the pivot
			n2 = n1; // (n - 2) is the new (n - 1)
			n1 = n1 + p; // the new (n - 1) is the sum of formers (n - 1) and (n - 2)
		}

		return n1 + n2;
	}

}
