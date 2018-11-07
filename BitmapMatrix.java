/*

BitmapMatrix.java

A bitmap image can be represented as an matrix of dimensions
M x N, where each position of the matrix can assume an integer value within a
interval. Construct an algorithm that receives as input the matrix A [MxN] where
m, n ∈ {0, 1, 2, ..., 15}. The output of your algorithm must be a String indicating the
number of times each (m, n) was found in the matrix. In the event that some
element has not been found, the algorithm must return that the quantity is zero
for that element. String format is free.

*/
package com.random_tests_java;

import java.util.HashMap;
import java.util.Map;

public class Matriz {

  public static void main(String[] args) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Integer m = Integer.valueOf(args[0]);
    Integer n = Integer.valueOf(args[1]);

    // Generating random matrix MxN
    System.out.println("Matrix");
    Integer[][] matrix = new Integer[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = (int) Math.floor(Math.random() * 16);
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }

    // Searching the matrix and putting the values in the map
    Integer key, value;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        key = Integer.valueOf(matrix[i][j]);
        value = map.get(key) != null ? map.get(key) + 1 : 1;
        map.put(key, value);
      }
    }

    // Priting
    System.out.println("Element:Quantity");
    for (int i = 0; i <= 15; i++) {
      System.out.println(i + ":" + (map.get(i) != null ? map.get(i) : 0));
    }

  }

}
