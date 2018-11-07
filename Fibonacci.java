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
    if (args.length == 0 || Integer.valueOf(args[0]) < 0) {
      System.out.println("ERROR");
    } else if (args.length > 1 && "R".equals(args[1])) {
      System.out.println(fibonacciRecursive(Integer.valueOf(args[0])));
    } else {
      System.out.println(fibonacciNonRecursive(Integer.valueOf(args[0])));
    }

  }

  private static Integer fibonacciRecursive(Integer n) {
    if (n <= 1) {
      return n;
    }
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
  }

  private static Integer fibonacciNonRecursive(Integer n) {
    if (n <= 1) {
      return n;
    }

    Integer n1 = 1; // (n - 1), initially f(1) = 1
    Integer n2 = 0; // (n - 2), initially f(0) = 0
    Integer p; // Pivot
    for (int i = 0; i < n - 2; i++) {
      p = n2; // Store the value of (n - 2) in the pivot
      n2 = n1; // (n - 2) is the new (n - 1)
      n1 = n1 + p; // the new (n - 1) is the sum of formers (n - 1) and (n - 2)
    }

    return n1 + n2;
  }

}
