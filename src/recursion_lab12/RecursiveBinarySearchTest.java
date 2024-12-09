package recursion_lab12;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Arrays;

public class RecursiveBinarySearchTest {
    
    @Test
    public void testIntegerBinarySearchExistingElement() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(3, RecursiveBinarySearch.binarySearchRecursive(arr, 7));
    }
    
    @Test
    public void testIntegerBinarySearchNonExistingElement() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(-1, RecursiveBinarySearch.binarySearchRecursive(arr, 6));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIntegerBinarySearchNullArray() {
        RecursiveBinarySearch.binarySearchRecursive(null, 5);
    }
    
    @Test
    public void testStringBinarySearchExistingElement() {
        String[] arr = {"apple", "banana", "cherry", "date", "elderberry"};
        assertEquals(2, RecursiveBinarySearch.binarySearchRecursive(arr, "cherry"));
    }
    
    @Test
    public void testStringBinarySearchNonExistingElement() {
        String[] arr = {"apple", "banana", "cherry", "date", "elderberry"};
        assertEquals(-1, RecursiveBinarySearch.binarySearchRecursive(arr, "fig"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testStringBinarySearchNullArray() {
        RecursiveBinarySearch.binarySearchRecursive(null, "test");
    }
    
    @Test
    public void testBinarySearchMultipleIndices() {
        int[] arr = {1, 2, 2, 2, 3, 4, 5, 5, 5};
        List<Integer> expectedIndices = Arrays.asList(1, 2, 3);
        List<Integer> actualIndices = RecursiveBinarySearch.binarySearchMultipleIndices(arr, 2);
        
        assertEquals(expectedIndices, actualIndices);
    }
    
    @Test
    public void testBinarySearchMultipleIndicesNoMatch() {
        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> actualIndices = RecursiveBinarySearch.binarySearchMultipleIndices(arr, 6);
        
        assertTrue(actualIndices.isEmpty());
    }
}