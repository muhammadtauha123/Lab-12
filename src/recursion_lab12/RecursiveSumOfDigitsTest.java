package recursion_lab12;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RecursiveSumOfDigitsTest {

    @Test
    void testPositiveNumber() {
        int result = RecursiveSumOfDigits.sumOfDigits(12345);
        assertEquals(15, result, "The sum of digits of 12345 should be 15.");
    }
    
    @Test
    void testNegativeNumber() {
        int result = RecursiveSumOfDigits.sumOfDigits(-987);
        assertEquals(24, result, "The sum of digits of -987 should be 24.");
    }

    @Test
    void testZero() {
        int result = RecursiveSumOfDigits.sumOfDigits(0);
        assertEquals(0, result, "The sum of digits of 0 should be 0.");
    }
}

