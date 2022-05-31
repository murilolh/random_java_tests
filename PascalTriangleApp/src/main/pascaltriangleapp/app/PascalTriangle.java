package pascaltriangleapp.app;

import java.util.LinkedList;
import java.util.List;

/**
 * Pascal's Triangle LC: 118
 * Pascal's Triangle II LC: 119
 */
public class PascalTriangle {

    /**
     * Given an integer numRows, return the first numRows of Pascal's triangle.
     */
    public List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> pascalTriangle = new LinkedList<>();
        pascalTriangle.add(List.of(1));

        for (int rowIndex = 1; rowIndex < numRows; rowIndex++)
            pascalTriangle.add(getNextRow(pascalTriangle.get(rowIndex - 1), rowIndex));

        return pascalTriangle;
    }

    private List<Integer> getNextRow(List<Integer> currentRow, int rowIndex) {
        final List<Integer> nextRow = new LinkedList<>();
        nextRow.add(1);

        for (int i = 0; i < rowIndex / 2; i++)
            nextRow.add(currentRow.get(i) + currentRow.get(i + 1));

        int maxIndexToRepeat = (int) (Math.ceil((float) rowIndex / 2) - 1f);
        for (int i = maxIndexToRepeat; i >= 0; i--)
            nextRow.add(nextRow.get(i));

        return nextRow;
    }

    /**
     * Given an integer rowIndex, return the rowIndex^th (0-indexed) row of the Pascal's triangle.
     */
    public List<Integer> getRow(int rowNumber) {
        List<Integer> currentRow = new LinkedList<>();
        currentRow.add(1);

        for (int rowIndex = 1; rowIndex < rowNumber + 1; rowIndex++)
            generateNextRow(currentRow, rowIndex);

        return currentRow;
    }

    private void generateNextRow(List<Integer> currentRow, int rowIndex) {
        int oldValue = 1;
        int currentIndex;
        for (currentIndex = 1; currentIndex <= rowIndex / 2; currentIndex++) {
            int newValue = currentRow.get(currentIndex);
            currentRow.set(currentIndex, newValue + oldValue);
            oldValue = newValue;
        }

        int maxIndexToRepeat = (int) (Math.ceil((float) rowIndex / 2) - 1f);
        for (int i = maxIndexToRepeat; i >= 1; i--, currentIndex++)
            currentRow.set(currentIndex, currentRow.get(i));
        currentRow.add(1);
    }
}
