/*

BitmapMatrixApplication.java

A bitmap image can be represented as a matrix of dimensions
M x N, where each position of the matrix can assume an integer value within a
interval. Construct an algorithm that receives as input the matrix A [MxN] where
m, n ∈ {0, 1, 2, ..., 15}. The output of your algorithm must be a String indicating the
number of times each (m, n) was found in the matrix. In the event that some
element has not been found, the algorithm must return that the quantity is zero
for that element. String format is free.

Args: MatrixWidth(int) MatrixHeight(int) ElementQtd(int)

*/
package bitmapmatrixapp.app;

import bitmapmatrixapp.domain.Matrix;

public class BitmapMatrixApplication {

  private static int matrixWidth;
  private static int matrixHeight;
  private static int elementQtd;

  public static void main(String[] args) {
    getArgs(args);
    Matrix matrix = new Matrix(matrixWidth, matrixHeight, elementQtd);
    matrix.populateWithRandomValues();
    matrix.printMatrix();
    matrix.calculateElementCount();
    matrix.printElementCount();
  }

  private static void getArgs(String[] args) {
    if (args.length > 2) {
      matrixWidth = Integer.parseInt(args[0]);
      matrixHeight = Integer.parseInt(args[1]);
      elementQtd = Integer.parseInt(args[2]);
    } else {
      System.err.println("Invalid arguments count:" + args.length);
    }
  }
}
