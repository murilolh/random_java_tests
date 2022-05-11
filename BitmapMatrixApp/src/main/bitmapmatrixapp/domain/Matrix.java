package bitmapmatrixapp.domain;

import java.util.HashMap;
import java.util.Map;

public class Matrix {
    protected final int width;
    protected final int height;
    protected final int elementQtd;
    protected final Integer[][] values;
    protected Map<Integer, Integer> elementCountMap;

    public Matrix(int width, int height, int elementQtd) {
        this.width = width;
        this.height = height;
        this.elementQtd = elementQtd;
        values = new Integer[width][height];
        elementCountMap = new HashMap<>();
    }

    public void populateWithRandomValues() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                values[i][j] = (int) Math.floor(Math.random() * elementQtd);
            }
        }
    }

    public void printMatrix() {
        System.out.println("Matrix");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(values[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void calculateElementCount() {
        int key, value;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                key = values[i][j];
                value = elementCountMap.get(key) != null ? elementCountMap.get(key) + 1 : 1;
                elementCountMap.put(key, value);
            }
        }
    }

    public void printElementCount() {
        System.out.println("Element:Quantity");
        for (int i = 0; i <= (elementQtd - 1); i++) {
            System.out.println(i + ":" + (elementCountMap.get(i) != null ? elementCountMap.get(i) : 0));
        }
    }
}
