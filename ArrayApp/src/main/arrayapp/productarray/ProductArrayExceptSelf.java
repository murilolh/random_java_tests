package arrayapp.productarray;

/**
 * Given an integer array numbers, return an array answer such that answer[i] is equal to the product of all the elements of numbers except numbers[i].
 * The product of any prefix or suffix of numbers is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * LC: 238
 */
public class ProductArrayExceptSelf {
    public static int[] productExceptSelf(int[] numbers) {
        int length = numbers.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] product = new int[length];

        /*
            numbers: [1,  2,  3, 4]
            left:    [1,  1,  2, 6]
            right:   [24, 12, 4, 1]
            product: [24, 12, 8, 6]
         */

        left[0] = 1;
        right[length - 1] = 1;

        for (int i = 1; i < length; i++)
            left[i] = numbers[i - 1] * left[i - 1];

        for (int i = length - 2; i >= 0; i--) {
            right[i] = numbers[i + 1] * right[i + 1];
            product[i] = left[i] * right[i];
        }

        product[length - 1] = right[length - 1] * left[length - 1];

        return product;
    }
}
