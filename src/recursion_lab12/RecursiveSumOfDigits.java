package recursion_lab12;

/**
 * A utility class for calculating the sum of digits in a signed integer recursively.
 */
public class RecursiveSumOfDigits {
    /**
     * Calculates the sum of digits in a signed integer using recursion.
     * Handles both positive and negative numbers.
     *
     * @param num The signed integer
     * @return The sum of the digits
     */
    public static int sumOfDigits(int num) {
        // Base case: when the number is 0
        if (num == 0) {
            return 0;
        }

        // Recursive case: add the last digit and recur on the remaining digits
        return Math.abs(num % 10) + sumOfDigits(num / 10);
    }
}