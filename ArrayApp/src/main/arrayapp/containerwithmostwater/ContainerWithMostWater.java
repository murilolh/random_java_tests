package arrayapp.containerwithmostwater;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * LC: 11
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxArea = 0;

        while (leftIndex < rightIndex) {
            int recHeight = Math.min(height[leftIndex], height[rightIndex]);
            int recBase = rightIndex - leftIndex;

            maxArea = Math.max(maxArea, recBase * recHeight);

            if (height[leftIndex] <= height[rightIndex])
                leftIndex++;
            else
                rightIndex--;
        }

        return maxArea;
    }
}
